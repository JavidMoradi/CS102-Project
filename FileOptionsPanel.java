import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOptionsPanel extends JPanel implements ActionListener {
    JButton newFile;
    JButton saveFile;
    JButton openFile;
    JButton closeFile;
    JFileChooser chooser;
    Scanner scan;
    String extension;
    static String fileName;
    File selectedFile;
    static EditorAreaPanel displayArea;
    static CommentShowPanel commentShowPanel;
    static CommentsModel commentsModel;
    //EditorAreaPanel displayArea;
    static String fileContent;
    FileWriter fileWriter;
    String filePath;
    String allComments;
    static ArrayList<String> fileContents;
    ArrayList<String> fileText;

    public FileOptionsPanel( EditorAreaPanel display ) {

        newFile = new JButton(" New File \u2795 ");
        saveFile = new JButton(" Save File \uD83D\uDCBE ");
        openFile = new JButton(" Open File ");
        closeFile = new JButton(" Close File ");

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(1000, 700));
        setBackground(Color.BLUE);
        setLocation(500, 500);

        newFile.addActionListener(this);
        saveFile.addActionListener(this);
        openFile.addActionListener(this);
        closeFile.addActionListener(this);

        add(newFile);
        add(saveFile);
        add(openFile);
        add(closeFile);

        setFocusable(true);


        commentsModel = new CommentsModel();

        displayArea = new EditorAreaPanel();
        commentShowPanel = new CommentShowPanel( displayArea );
        add(displayArea);

        fileContent = "";
        selectedFile = null;
        allComments = "";
        filePath = "";
        fileContents = new ArrayList<>();
        fileText = new ArrayList<String>();

    }

    public void actionPerformed(ActionEvent actionEvent) {
        try {
            // sets the feel to the user's respective machine
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, " Error ");
        }

        if (actionEvent.getActionCommand().equals(newFile.getText())) // The Action Listener For The "New File" Button
        {
            boolean isCreated;
            chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
            {
                try
                {
                    fileName = JOptionPane.showInputDialog(" Please Enter The Name of The New File ");
                    filePath = chooser.getSelectedFile().getAbsolutePath();
                    System.out.println(filePath);
                    selectedFile = new File( filePath + "/" + fileName + ".java" );
                    isCreated = selectedFile.createNewFile();

                    if ( isCreated )
                    {
                       JOptionPane.showMessageDialog(this, " The File Was Created Successfully ", "NOTE",
                            JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, " The File Could Not Be Created, Please Try Again ",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    }

                    fileName += ".java";
                    FileExplorerPanel.model.addElement(fileName);
                    displayArea.setContent( "" );

                } catch (IOException e) {
                    JOptionPane.showMessageDialog(this, " The File Could Not Be Created, Please Try Again ", "WARNING",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (actionEvent.getActionCommand().equals(saveFile.getText())) // The Action Listener For The "Save File"
                                                                              // Button
        {
            saveFile();

        } else if (actionEvent.getActionCommand().equals(openFile.getText())) // The Action Listener For The "Open File"
                                                                              // Button
        {
            try {
                chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                if ( chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION )
                {
                    fileContent = "";
                    selectedFile = chooser.getSelectedFile();

                    scan = new Scanner ( selectedFile );
                    fileName = selectedFile.getName();
                    extension = fileName.substring( fileName.lastIndexOf(".") ); // gets the extension

                    if (!( extension.equals(".java") ) && !( extension.equals(".txt") ) ) //checks the type of the selected file
                    {
                        JOptionPane.showMessageDialog(this, " The File You Have Chosen is Invalid," + "\n"
                                        + " Please Select A Java File (.java) "
                                        + "or A Text Document (.txt) ",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        FileExplorerPanel.model.addElement( fileName );

                        while ( scan.hasNextLine() ) // Reads the File Content
                        {
                            fileText.add( scan.nextLine() + "\n" ); // adding each line into a separate index
                        }

                        for ( int i = 0; i < fileText.size(); i++ )
                        {
                            if ( fileText.get(i).startsWith( "Line: " ) )
                            {
                                allComments += fileText.get(i);
                            }
                            else
                            {
                                fileContent += fileText.get(i);
                            }
                        }
                    }

                    commentShowPanel.setComments( allComments );
                    displayArea.setContent( fileContent ); // Displays the contents of the file

                }
            } catch ( IOException ex ) {
                JOptionPane.showMessageDialog( null, " Error " );
            }


        } else if (actionEvent.getActionCommand().equals(closeFile.getText())) // The Action Listener For The "Close
                                                                               // File" Button
        {
            if (FileExplorerPanel.model.size() > 0) {
//                FileExplorerPanel.model
//                        .remove(FileExplorerPanel.model.indexOf(FileExplorerPanel.lstFiles.getSelectedValue()));
//                        fileContents.remove(FileExplorerPanel.model.indexOf(FileExplorerPanel.lstFiles.getSelectedValue()));
//                        int index = FileExplorerPanel.model.indexOf(FileExplorerPanel.lstFiles.getSelectedValue());
                        //for(int i = fileContents.size(); i > index; i-- )
                        //{
                        //    fileContents.set(i, fileContents.get(i + 1));
                        //}
                FileExplorerPanel.model.remove(FileExplorerPanel.model.size() - 1);
                displayArea.setContent( "" );
                selectedFile = null;
            } else {
                JOptionPane.showMessageDialog(this, " There Are No Files To Close ", "WARNING",
                        JOptionPane.WARNING_MESSAGE);
            }

        } else {

            JOptionPane.showMessageDialog(this, " The Button You Have Pressed is Invalid ", "WARNING",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public static String getFileContent(int index)
     {
        return fileContents.get(index);
    }

    public void saveFile ()
    {
        //commentShowPanel.setComments( commentsModel.getAllComments() );

        if (selectedFile == null) {
            JOptionPane.showMessageDialog(this, " There is no File To Save, Please Open or Create A New File ",
                    "WARNING", JOptionPane.WARNING_MESSAGE);

        } else
            {
            try
            {
                fileWriter = new FileWriter(selectedFile);
                fileWriter.write(displayArea.getContent());

                JOptionPane.showMessageDialog(this, " The File Was Saved Successfully ",
                        "NOTE", JOptionPane.INFORMATION_MESSAGE);
                fileWriter.close();
            }
            catch (IOException e)
            {
                JOptionPane.showMessageDialog(this, " The File Was Not Saved, Please Try Again ",
                        "WARNING", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}