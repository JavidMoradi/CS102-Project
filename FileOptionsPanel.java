import org.apache.commons.lang3.StringUtils;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileOptionsPanel extends JPanel implements ActionListener
{
    static String fileName;
    static EditorAreaPanel displayArea;
    static CommentShowPanel commentShowPanel;
    static CommentsModel commentsModel;
    static String fileContent;
    static ArrayList <String> fileContents;
    static ArrayList <Integer> staticAllColorsAndIndexes;
    static String theFileName;
    static String theFilteredFileName;
    JButton newFile;
    JButton saveFile;
    JButton openFile;
    JButton closeFile;
    JFileChooser chooser;
    Scanner scan;
    String extension;
    File selectedFile;
    FileWriter fileWriter;
    String filePath;
    String allComments;
    ArrayList <String> fileText;
    ArrayList <Integer> allColorsAndIndexes;
    String currentFileLineContent;
    ArrayList commentsArrayList;
    ArrayList <Integer> indexesArrayList;
    ArrayList <Color> colorsArrayList;
    ArrayList <Comment> commentArrayList;
    ArrayList <String> fileNamesArrayList;

    public FileOptionsPanel ( EditorAreaPanel display )
    {

        newFile = new JButton ( " New File \u2795 " );
        saveFile = new JButton ( " Save File \uD83D\uDCBE " );
        openFile = new JButton ( " Open File " );
        closeFile = new JButton ( " Close File " );

        setLayout ( new FlowLayout () );
        setPreferredSize ( new Dimension ( 665, 550 ) );
        setBorder ( BorderFactory.createLineBorder ( new Color ( 0, 0, 0, 255 ) ) );
        setBackground ( Color.darkGray );
        setLocation ( 500, 500 );

        newFile.addActionListener ( this );
        saveFile.addActionListener ( this );
        openFile.addActionListener ( this );
        closeFile.addActionListener ( this );

        add ( newFile );
        newFile.setForeground ( Color.BLACK );
        newFile.setBackground ( new Color ( 164, 129, 255 ) );
        newFile.setPreferredSize ( new Dimension ( 150, 25 ) );
        newFile.setFont ( new Font ( newFile.getFont ().toString (), Font.BOLD, 16 ) );

        add ( saveFile );
        saveFile.setForeground ( Color.BLACK );
        saveFile.setBackground ( new Color ( 164, 129, 255 ) );
        saveFile.setPreferredSize ( new Dimension ( 150, 25 ) );
        saveFile.setFont ( new Font ( newFile.getFont ().toString (), Font.BOLD, 16 ) );

        add ( openFile );
        openFile.setForeground ( Color.BLACK );
        openFile.setBackground ( new Color ( 164, 129, 255 ) );
        openFile.setPreferredSize ( new Dimension ( 150, 25 ) );
        openFile.setFont ( new Font ( newFile.getFont ().toString (), Font.BOLD, 16 ) );

        add ( closeFile );
        closeFile.setForeground ( Color.BLACK );
        closeFile.setBackground ( new Color ( 164, 129, 255 ) );
        closeFile.setPreferredSize ( new Dimension ( 150, 25 ) );
        closeFile.setFont ( new Font ( newFile.getFont ().toString (), Font.BOLD, 16 ) );

        setFocusable ( true );


        commentsModel = new CommentsModel ( display );

        displayArea = new EditorAreaPanel ();
        commentShowPanel = new CommentShowPanel ( displayArea );
        add ( displayArea );

        // This is an "Auto-Saving" Feature of some sorts
        EditorAreaPanel.editorPanel.addKeyListener(new KeyAdapter () {
            @Override
            public void keyPressed( KeyEvent e)
            {
                for ( int i = 0; i < 1; i++ ) {
                    saveFileWithoutMessage();
                }
            }
        });

        fileContent = "";
        selectedFile = null;
        allComments = "";
        filePath = "";
        currentFileLineContent = "";
        theFileName = "";
        theFilteredFileName = "";
        fileContents = new ArrayList <> ();
        fileText = new ArrayList <String> ();
        allColorsAndIndexes = new ArrayList <Integer> ();
        commentsArrayList = new ArrayList ();
        indexesArrayList = new ArrayList <Integer> ();
        colorsArrayList = new ArrayList <Color> ();
        commentArrayList = new ArrayList <Comment> ();
        staticAllColorsAndIndexes = new ArrayList <Integer> ();
        fileNamesArrayList = new ArrayList <String> ();
    }

    /**
     * gets the file content of a file specified by an index
     * @param index
     * @return String a string representation of the specific file content
     */
    public static String getFileContent ( int index )
    {
        return fileContents.get ( index );
    }

    /**
     * used for playing an audio file
     * @param musicLocation
     */
    public static void playMusic ( String musicLocation )
    {
        try
        {

            File musicPath = new File ( musicLocation );
            if ( musicPath.exists () )
            {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream ( musicPath );
                Clip clip = AudioSystem.getClip ();
                clip.open ( audioInput );
                clip.start ();

            }
            else
            {
                System.out.println ( "null" );
            }

        } catch ( Exception e )
        {
            e.printStackTrace ();

        }
    }

    /**
     * The ActionListener for the 4 file management buttons
     * which are the Save, Open, Close, and Save File buttons
     * @param actionEvent
     */
    public void actionPerformed ( ActionEvent actionEvent )
    {
        try
        {
            // sets the feel to the user's respective machine
            UIManager.setLookAndFeel ( UIManager.getSystemLookAndFeelClassName () );
        } catch ( Exception e )
        {
            JOptionPane.showMessageDialog ( null, " Error " );
        }

        if ( actionEvent.getActionCommand ().equals (
                newFile.getText () ) ) // The Action Listener For The "New File" Button
        {
            boolean isCreated;
            chooser = new JFileChooser ();
            chooser.setDialogTitle ( " Choose A Directory To Create The File In " );
            chooser.setFileSelectionMode ( JFileChooser.FILES_AND_DIRECTORIES );

            if ( chooser.showDialog ( null, "Create File" ) == JFileChooser.APPROVE_OPTION )
            {
                try
                {
                    fileName = JOptionPane.showInputDialog ( " Please Enter The Name of The New File " );
                    theFileName = fileName;


                    filePath = chooser.getSelectedFile ().getAbsolutePath ();
                    selectedFile = new File ( filePath + "/" + fileName + ".java" );
                    isCreated = selectedFile.createNewFile ();

                    if ( !isCreated )
                    {
                        playMusic ( "ohno.wav" );
                        JOptionPane.showMessageDialog ( this, " The File Could Not Be Created, Please Try Again ",
                                "WARNING", JOptionPane.WARNING_MESSAGE );
                    }
                    else
                    {
                        JOptionPane.showMessageDialog ( this, " The File Was Created Successfully ", "NOTE",
                                JOptionPane.INFORMATION_MESSAGE );
//                        fileName += ".java";
                        FileExplorerPanel.model.addElement ( fileName );

                        fileContent = "";
                        displayArea.setContent ( fileContent );
                        EditorAreaPanel.setFocus ( 0 );
                        fileContents.add ( fileContent );
                        FileExplorerPanel.lstFiles.setSelectedIndex ( fileContents.size () - 1 );
                    }

                } catch ( IOException e )
                {
                    playMusic ( "ohno.wav" );
                    JOptionPane.showMessageDialog ( this, " The File Could Not Be Created, Please Try Again ",
                            "WARNING",
                            JOptionPane.WARNING_MESSAGE );
                }
            }
        }
        else if ( actionEvent.getActionCommand ().equals (
                saveFile.getText () ) ) // The Action Listener For The "Save File"
        // Button
        {
            saveFile ();

        }
        else if ( actionEvent.getActionCommand ().equals (
                openFile.getText () ) ) // The Action Listener For The "Open File"
        // Button
        {
            try
            {
                chooser = new JFileChooser ();

                chooser.setFileSelectionMode ( JFileChooser.FILES_ONLY );

                if ( chooser.showOpenDialog ( null ) == JFileChooser.APPROVE_OPTION )
                {
                    fileContent = "";
                    selectedFile = chooser.getSelectedFile ();

                    System.out.println ( selectedFile );

                    scan = new Scanner ( selectedFile );
                    fileName = selectedFile.getName ();
                    theFileName = fileName;
                    extension = fileName.substring ( fileName.lastIndexOf ( "." ) ); // gets the extension
                    theFileName = theFileName.substring ( 0,
                            theFileName.indexOf ( "." ) ); // removing the .Java from the file name
                    System.out.println ( " The Unfiltered File Name: " + theFileName );


                    if ( !( extension.equals ( ".java" ) ) && !( extension.equals (
                            ".txt" ) ) ) //checks the type of the selected file
                    {
                        playMusic ( "ohno.wav" );
                        JOptionPane.showMessageDialog ( this, " The File You Have Chosen is Invalid," + "\n"
                                        + " Please Select A Java File (.java) "
                                        + "or A Text Document (.txt) ",
                                "WARNING", JOptionPane.WARNING_MESSAGE );
                    }
                    else
                    {
                        fileName = fileName.substring ( 0,
                                fileName.indexOf ( "." ) ); // removing th .Java from the file name

                        FileExplorerPanel.model.addElement ( fileName );
                        FileExplorerPanel.lstFiles.setSelectedIndex ( FileExplorerPanel.model.size() - 1);//fileContents.size () );

                        fileText.clear ();
                        while ( scan.hasNextLine () ) // Reads the File Content
                        {
                            fileText.add ( scan.nextLine () + "\n" ); // adding each line into a separate index
                        }

                        for ( int i = 0; i < fileText.size (); i++ )
                        {
                            currentFileLineContent = fileText.get ( i );

                            int lineNumber = 0;
                            String commentType = "";
                            int firstSelection = 0;
                            int lastSelection = 0;

                            if ( currentFileLineContent.startsWith (
                                    "Line: " ) )//"Line: " ) ) //gets the comments stored in the file
                            {

//                                theFilteredFileName = StringUtils.substringBetween ( currentFileLineContent, "File Name: ", ".java" );
                                commentType = StringUtils.substringAfterLast ( currentFileLineContent, ". " );
                                lineNumber = Integer.parseInt (
                                        StringUtils.substringBetween ( currentFileLineContent, "Line: ", "." ) );

//                                System.out.println ( "The Filtered File Name: " +  theFilteredFileName );

                                commentsArrayList.add ( commentType );
                                commentsArrayList.add ( lineNumber );

                                fileNamesArrayList.add ( theFileName );
                                fileNamesArrayList.add ( theFileName );

                                allComments += fileText.get ( i );


                            }
                            else if ( currentFileLineContent.startsWith (
                                    "java.awt.Color[" ) ) //gets the highlighting stored
                            {
                                firstSelection = Integer.parseInt (
                                        StringUtils.substringBetween ( currentFileLineContent, "], ", "," ) );
                                lastSelection = Integer.parseInt (
                                        StringUtils.substringBetween ( currentFileLineContent, ",*", "*," ) );

                                indexesArrayList.add ( firstSelection );
                                indexesArrayList.add ( lastSelection );

                                // This is extracting the necessary information from the embedding of the highlighting
                                for ( int j = 0; j < 1; j++ )
                                {
                                    allColorsAndIndexes.add ( Integer.parseInt (
                                            StringUtils.substringBetween ( currentFileLineContent, "r=",
                                                    "," ) ) ); // For the "r"
                                    allColorsAndIndexes.add ( Integer.parseInt (
                                            StringUtils.substringBetween ( currentFileLineContent, "g=",
                                                    "," ) ) ); // For the "g"
                                    allColorsAndIndexes.add ( Integer.parseInt (
                                            StringUtils.substringBetween ( currentFileLineContent, "b=",
                                                    "]" ) ) ); // For the "b"
                                    allColorsAndIndexes.add ( firstSelection );// For the first index
                                    allColorsAndIndexes.add ( lastSelection ); // For the Last Index

                                    staticAllColorsAndIndexes.add ( Integer.parseInt (
                                            StringUtils.substringBetween ( currentFileLineContent, "r=", "," ) ) );
                                    staticAllColorsAndIndexes.add ( Integer.parseInt (
                                            StringUtils.substringBetween ( currentFileLineContent, "g=", "," ) ) );
                                    staticAllColorsAndIndexes.add ( Integer.parseInt (
                                            StringUtils.substringBetween ( currentFileLineContent, "b=", "]" ) ) );
                                    staticAllColorsAndIndexes.add ( firstSelection );
                                    staticAllColorsAndIndexes.add ( lastSelection );
                                }
                            }
                            else
                            {
                                fileContent += fileText.get ( i ); // gets the actual code from the file
                            }
                        }
                    }

                    fileContents.add ( fileContent );
                    displayArea.setContent ( fileContent ); // Displays the contents of the file
                    EditorAreaPanel.setFocus ( 0 );

                    for ( int i = 0; i < allColorsAndIndexes.size (); i += 5 )
                    {
                        Color tmpColor;

                        int r = allColorsAndIndexes.get ( i );
                        int g = allColorsAndIndexes.get ( i + 1 );
                        int b = allColorsAndIndexes.get ( i + 2 );
                        tmpColor = new Color ( r, g, b );
                        int firstIndex = allColorsAndIndexes.get ( i + 3 );
                        int lastIndex = allColorsAndIndexes.get ( i + 4 );
                        colorsArrayList.add ( tmpColor );
                        colorsArrayList.add ( tmpColor );

                        displayArea.addHighlight ( tmpColor, firstIndex, lastIndex );
                    }

                    for ( int k = 0; k < commentsArrayList.size (); k += 2 )
                    {
                        String currentCommentType;
                        int currentFirstIndex;
                        int currentLastIndex;
                        int currentLineNumber;
                        Color currentColor;
                        String currentFileName;

                        currentCommentType = ( String ) commentsArrayList.get ( k );
                        currentFirstIndex = indexesArrayList.get ( k );
                        currentLastIndex = indexesArrayList.get ( k + 1 );
                        currentLineNumber = ( int ) commentsArrayList.get ( k + 1 );
                        currentColor = colorsArrayList.get ( k + 1 );
                        currentFileName = fileNamesArrayList.get ( k );

                        System.out.println ( currentFileName );

                        Comment comment;
                        comment = new Comment ( currentCommentType, currentFirstIndex, currentLastIndex,
                                currentLineNumber, currentColor, currentFileName );
                        commentArrayList.add ( comment );
                        CommentsModel.addComment ( comment );
                        CommentShowPanel.update ();
                    }

                    allColorsAndIndexes.clear (); // Clearing the ArrayList of Elements Added Previously
                    commentsArrayList.clear (); // Clearing the ArrayList of Elements Added Previously
                    colorsArrayList.clear ();
                }
            } catch ( IOException ex )
            {
                JOptionPane.showMessageDialog ( null, " Error " );
            }


        }
        else if ( actionEvent.getActionCommand ().equals (
                closeFile.getText () ) ) // The Action Listener For The "Close
        // File" Button
        {
            if ( FileExplorerPanel.model.size () > 0 )
            {
                int index = FileExplorerPanel.model.indexOf ( FileExplorerPanel.lstFiles.getSelectedValue () );
                FileExplorerPanel.model.remove ( index );
                fileContents.remove ( index );

                if ( fileContents.size () == 0 )
                {
                    displayArea.setContent ( "" );
                    CommentShowPanel.model.removeAllElements ();
                }
                else
                {
                    if ( index == 0 && fileContents.size () > 0 )
                    {
                        displayArea.setContent ( getFileContent ( 0 ) );
                        FileExplorerPanel.lstFiles.setSelectedIndex ( 0 );

                        for ( int z = 0; z < commentArrayList.size (); z++ )
                        {
                            CommentsModel.removeComment ( commentArrayList.get ( z ) );
                        }

                    }
                    else
                    {
                        displayArea.setContent ( getFileContent ( index - 1 ) );
                        FileExplorerPanel.lstFiles.setSelectedIndex ( index - 1 );

                        for ( int z = 0; z < commentArrayList.size (); z++ )
                        {
                            CommentsModel.removeComment ( commentArrayList.get ( z ) );
                        }
                    }
                }
            }
            else
            {
                playMusic ( "ohno.wav" );
                JOptionPane.showMessageDialog ( this, " There Are No Files To Close ", "WARNING",
                        JOptionPane.WARNING_MESSAGE );
                displayArea.setContent ( "" );
            }

        }
        else
        {
            playMusic ( "ohno.wav" );
            JOptionPane.showMessageDialog ( this, " The Button You Have Pressed is Invalid ", "WARNING",
                    JOptionPane.WARNING_MESSAGE );
        }

        //by default, the new file is the selected file
        FileExplorerPanel.selectedFileName = theFileName;
    }

    /**
     * Saves the contents on the EditorAreaPanel (Main Code Panel)
     * as well as all the highlighting and comments into the same file
     * that was previously open
     */
    public void saveFile ()
    {
        if ( selectedFile == null )
        {
            playMusic ( "ohno.wav" );
            JOptionPane.showMessageDialog ( this, " There is no File To Save, Please Open or Create A New File ",
                    "WARNING", JOptionPane.WARNING_MESSAGE );

        }
        else
        {
            try
            {
                fileWriter = new FileWriter ( selectedFile );
                fileWriter.write ( EditorAreaPanel.getContent () );

                JOptionPane.showMessageDialog ( this, " The File Was Saved Successfully ",
                        "NOTE", JOptionPane.INFORMATION_MESSAGE );
                fileWriter.close ();
                int index = FileExplorerPanel.model.indexOf ( FileExplorerPanel.lstFiles.getSelectedValue () );
                fileContents.set ( index, EditorAreaPanel.getContent () );
            } catch ( IOException e )
            {
                JOptionPane.showMessageDialog ( this, " The File Was Not Saved, Please Try Again ",
                        "WARNING", JOptionPane.WARNING_MESSAGE );
            }
        }
    }

    /**
     * Has the Same function as the saveFile() method
     * but this one is used for the Auto-saving feature
     * thus does not display a message when anything is saved
     */
    public void saveFileWithoutMessage ()
    {
        try
        {
            fileWriter = new FileWriter ( selectedFile );
            fileWriter.write ( EditorAreaPanel.getContent () );
            fileWriter.close ();
            int index = FileExplorerPanel.model.indexOf ( FileExplorerPanel.lstFiles.getSelectedValue () );
            fileContents.set ( index, EditorAreaPanel.getContent () );
        } catch ( IOException e )
        {

            JOptionPane.showMessageDialog ( this,
                    " The Auto-Saving Feature Is Not Working, Please Close The Program And Re-open It ",
                    "WARNING",
                    JOptionPane.WARNING_MESSAGE );
        }
    }
}
