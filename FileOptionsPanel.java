import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileOptionsPanel extends JPanel implements ActionListener {
    JButton newFile;
    JButton saveFile;
    JButton openFile;
    JButton closeFile;
    JFileChooser chooser;
    Scanner scan;
    String extension;
    String fileName;
    File selectedFile;
    EditorAreaPanel displayArea;
    String fileContent;

    public FileOptionsPanel() {
        newFile = new JButton(" New File \u2795 ");
        saveFile = new JButton(" Save File \uD83D\uDCBE ");
        openFile = new JButton(" Open File ");
        closeFile = new JButton(" Close File ");

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(430, 35));
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

        displayArea = new EditorAreaPanel();
        add(displayArea);
        


    }

    public void actionPerformed(ActionEvent actionEvent) {

        if (actionEvent.getActionCommand().equals(newFile.getText())) // The Action Listener For The "New File" Button
        {
            System.out.println(" The New File Button Has Been Pressed ");
            

        } else if (actionEvent.getActionCommand().equals(saveFile.getText())) // The Action Listener For The "Save File" Button
        {
            System.out.println(" The Save File Button Has Been Pressed  ");

        } else if (actionEvent.getActionCommand().equals(openFile.getText())) // The Action Listener For The "Open File" Button
        {
            try {
                //sets the feel to the user's respective machine
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, " Error ");
            }
            try {
                chooser = new JFileChooser();
                chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

                if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    fileContent = "";
                    selectedFile = chooser.getSelectedFile();

                    scan = new Scanner(selectedFile);
                    fileName = selectedFile.getName();
                    extension = fileName.substring(fileName.lastIndexOf("."), fileName.length()); // gets the extension

                    if (!(extension.equals(".java")) && !(extension.equals(".txt"))) //checks the type of the selected file
                    {
                        JOptionPane.showMessageDialog(this, " The File You Have Chosen is Invalid," + "\n"
                                        + " Please Select A Java File (.java) "
                                        + "or a Text Document (.txt) ",
                                "WARNING", JOptionPane.WARNING_MESSAGE);
                    } else {
                        FileExplorerPanel.model.addElement( fileName );

                        while (scan.hasNextLine()) {
                            fileContent += scan.nextLine() + "\n";
                        }
                    }
                    //displayArea.setAText(fileContent); //This is supposed to display the contents of the Java file
                    // but it doesn't. Help!!!!!

                }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, " Error ");
            }

        } else if (actionEvent.getActionCommand().equals(closeFile.getText())) // The Action Listener For The "Close File" Button
        {
            System.out.println(" The Close File Button Has Been Pressed  ");
            FileExplorerPanel.model.remove(FileExplorerPanel.model.size() - 1);


        } else {

            JOptionPane.showMessageDialog(this, " The Button You Have Pressed is Invalid ",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }


}
