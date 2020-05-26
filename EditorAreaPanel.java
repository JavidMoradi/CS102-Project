import org.sonar.scanner.protocol.viewer.TextLineNumber;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.ArrayList;
/**
 * @authors Javid Moradi, Ahmad Salman, Tuna Öğüt, Bill Gates, Hissam Faramawy, Onuralp Avcı, Atasagun Samed Şanap
 * @version 1.1
 */
public class EditorAreaPanel extends JPanel
{
    private static CommentsModel commentControl;
    private static JTextArea editorPanel;
    private static TextLineNumber textLineNumber;
    private static JScrollPane scrollPane = new JScrollPane ( editorPanel );
    //static CommentsModel commentsModel;
    private static int a;
    private static int b;
    private static DefaultHighlighter highlighter;
    private static DefaultHighlighter.DefaultHighlightPainter painter;
    private static ArrayList firstIndexes;
    private static ArrayList lastIndexes;
    private static ArrayList<Color> colorsArrayList;
    private Font editorFont;
    private int firstIndex;
    private int lastIndex;

    public EditorAreaPanel ()
    {
        editorPanel = new JTextArea ();
        editorPanel.setVisible ( true );
        editorPanel.setRows ( 27 );
        editorPanel.setColumns ( 35 );
        editorPanel.setWrapStyleWord ( true );
        editorPanel.setFont ( new Font ( "Microsoft Tai Le", Font.PLAIN, 18 ) );
        editorPanel.setForeground ( Color.WHITE );
        editorPanel.setBackground ( Color.black );
        editorPanel.setCaretColor ( Color.WHITE );

        commentControl = new CommentsModel ( this );


        //TextLineNumber tln = new TextLineNumber(textPane);
        scrollPane = new JScrollPane ( editorPanel );
        textLineNumber = new TextLineNumber ( editorPanel );

        scrollPane.setRowHeaderView ( textLineNumber );
        add ( scrollPane );
        highlighter = ( DefaultHighlighter ) editorPanel.getHighlighter ();
        painter = new DefaultHighlighter.DefaultHighlightPainter ( Color.RED );
        highlighter.setDrawsLayeredHighlights ( false ); // this is the key line

        firstIndexes = new ArrayList ();
        lastIndexes = new ArrayList ();
        colorsArrayList = new ArrayList <Color> ();
    }

    /**
     * gets the content from the EditorAreaPanel and
     * puts all the information into a single String variable
     * @return a String representation of the information
     * written on the main panel
     */
    public static String getContent ()
    {
        String allContent;
        allContent = "";
        allContent = editorPanel.getText () + commentControl.getAllComments ( FileOptionsPanel.theFileName );
        for ( int i = colorsArrayList.size () - 1; i >= 0; i-- )//int i = 0; i < colorsArrayList.size (); i++ )
        {
//            allContent += "\n" + colorsArrayList.get ( i ) + ", " + firstIndexes.get ( i ) + ",*" + lastIndexes.get ( i ) + "*,";
            allContent += "\n" + colorsArrayList.get ( i ) + ", " +
                    CommentsModel.commentsBag.get ( i ).start + ",*" +
                    CommentsModel.commentsBag.get ( i ).end + "*,";
        }
        return allContent;
    }

    /**
     * sets the given parameter to the main code pane;
     * author: Ahmet Salman
     * @param str the String that will be displayed on the main panel
     */
    public void setContent ( String str )
    {
        editorPanel.setText ( str );
    }

    public static int getSelectionFirst ()
    {
        return editorPanel.getSelectionStart ();
    }

    public static int getSelectionLast ()
    {
        return editorPanel.getSelectionEnd ();
    }

    public static void addHighlight ( Color color )
    {
        painter = new DefaultHighlighter.DefaultHighlightPainter ( color );
        a = editorPanel.getSelectionStart ();
        b = editorPanel.getSelectionEnd ();

        try
        {
            highlighter.addHighlight ( a, b, painter );

            firstIndexes.add ( a );
            lastIndexes.add ( b );
            colorsArrayList.add ( color );

        } catch ( BadLocationException exeption )
        {
            // TODO Auto-generated catch block
            exeption.printStackTrace ();
        }
    }

    public static JScrollPane getJScrollPane ()
    {
        return scrollPane;
    }

    public static int getLineNumber ( int pos )
    {
        String text;
        String currentSubString;

        int lineNumber;
        text = editorPanel.getText ();
        lineNumber = 1;

        for ( int i = 0; i <= pos; i++ )
        {
            currentSubString = text.substring ( i, i + 1 );
            if ( currentSubString.equals ( "\n" ) )
            {
                lineNumber++;
            }
        }
        return lineNumber;
    }

    //returns the starting position of the line
    public static int getPos ( int lineNumber )
    {
        int pos;
        int count;
        String text;
        String currentSubString = "";

        count = lineNumber;
        pos = 0;
        text = editorPanel.getText ();

        for ( int i = 0; i < text.length (); i++ )
        {
            currentSubString = text.substring ( i, i + 1 );
            if ( currentSubString.equals ( "\n" ) )
            {
                count--;
            }
            if ( count == 2 )
            {
                pos = i + 2;
            }
        }

        return pos;
    }

    //adds pointer at the specified position
    public static void addNewPointer ( int pos )
    {
        //First we delete any previous pointers (if any)
        //editorPanel.setText(editorPanel.getText().replace(">>",""));

        RemovePointer ();

        //Secondly we add new one
        String str;
        str = ">>";
        editorPanel.insert ( str, pos );

        //reHighlight because normally it loses highlight
        reHighlight ( CommentsModel.commentsBag );
    }

    public static void RemovePointer ()
    {
        String text;
        String currentSubString;

        text = editorPanel.getText ();

        System.out.println ( "entered" );
        for ( int i = 0; i < text.length () - 2; i++ )
        {
            currentSubString = text.substring ( i, i + 2 );
            if ( currentSubString.equals ( ">>" ) )
            {
                System.out.println ( "found" );
                editorPanel.replaceRange ( "", i, i + 2 );
            }
        }
    }

    public static void reHighlight ( ArrayList <Comment> commentsBag )
    {
        int a;
        int b;
        Color color;

        for ( int i = 0; i < commentsBag.size (); i++ )
        {
            System.out.println ( " >>" + FileExplorerPanel.selectedFileName );
            System.out.println ( " >>" + commentsBag.get ( i ).fileName );
            if ( FileExplorerPanel.selectedFileName == null || commentsBag.get ( i ).fileName.equals (
                    FileExplorerPanel.selectedFileName ) )
            {
                //System.out.println("Equals(highlight)");
                a = commentsBag.get ( i ).getStartIndex ();
                b = commentsBag.get ( i ).getEndIndex ();
                color = commentsBag.get ( i ).getColor ();

                painter = new DefaultHighlighter.DefaultHighlightPainter ( color );
                try
                {
                    highlighter.addHighlight ( a, b, painter );
                } catch ( BadLocationException exeption )
                {
                    // TODO Auto-generated catch block
                    exeption.printStackTrace ();
                }
            }
        }
    }

    public static void removeHighlights ()
    {
        Highlighter hlt = editorPanel.getHighlighter ();
        hlt.removeAllHighlights ();
    }

    public static void setFocus ( Comment c )
    {
        editorPanel.setSelectionStart ( c.getStartIndex () );
        editorPanel.setSelectionEnd ( c.getEndIndex () );
    }

    public static void setFocus ( int index )
    {
        editorPanel.setSelectionStart ( index );
        editorPanel.setSelectionEnd ( index );
    }

    public String getAllColorsAndIndexes ()
    {
        String allColorsAndIndexes;
        allColorsAndIndexes = "";

        for ( int i = 0; i < colorsArrayList.size (); i++ )
        {
            allColorsAndIndexes += "\n" + colorsArrayList.get ( i ) + ", " + firstIndexes.get (
                    i ) + ", " + lastIndexes.get ( i );
        }
        return allColorsAndIndexes;
    }

    public Font getEditorFont ()
    {
        return editorPanel.getFont ();
    }

    public void setEditorFont ( Font font )
    {
        editorFont = font;
        editorPanel.setFont ( editorFont );
    }

    public ArrayList getFirstIndexes ()
    {
        return firstIndexes;
    }

    public ArrayList getLastIndexes ()
    {
        return lastIndexes;
    }

    public ArrayList <Color> getColorsArrayList ()
    {
        return colorsArrayList;
    }

    /**
     * This method provides a more accessible way
     * to apply highlighting from other classes
     * this is used in the "Open File" section
     * in the FileOptionsPanel
     * @param color The color of the highlighting that shall be applied
     * @param firstIndex the beginning index of that highlighting
     * @param lastIndex the last index in which the highlighting should stop
     */
    public void addHighlight ( Color color, int firstIndex, int lastIndex )
    {
        painter = new DefaultHighlighter.DefaultHighlightPainter ( color );
        this.firstIndex = firstIndex;
        this.lastIndex = lastIndex;
        try
        {
            highlighter.addHighlight ( firstIndex, lastIndex, painter );
        } catch ( BadLocationException exeption )
        {
            // TODO Auto-generated catch block
            exeption.printStackTrace ();
        }
    }

    /**
     * get the text area
     * @return JtextArea, which is editorPanel
     */
    public JTextArea getTextArea ()
    {
        return editorPanel;
    }
}
