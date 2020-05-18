import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import java.awt.*;
import java.util.ArrayList;

public class EditorAreaPanel extends JPanel
{
    static CommentsModel commentControl;
    static JTextArea editorPanel;
    static TextLineNumber textLineNumber;
    static JScrollPane scrollPane = new JScrollPane ( editorPanel );
    //static CommentsModel commentsModel;
    static int a;
    static int b;
    static DefaultHighlighter highlighter;
    static DefaultHighlighter.DefaultHighlightPainter painter;
    static ArrayList firstIndexes;
    static ArrayList lastIndexes;
    static ArrayList <Color> colorsArrayList;
    Font editorFont;
    int firstIndex;
    int lastIndex;

    public EditorAreaPanel ()
    {
        editorPanel = new JTextArea ();
        editorPanel.setVisible ( true );
        editorPanel.setRows ( 25 );
        editorPanel.setColumns ( 35 );
        editorPanel.setWrapStyleWord ( true );
        editorPanel.setFont ( new Font ( "Microsoft Tai Le", Font.PLAIN, 18 ) );
        editorPanel.setForeground ( Color.WHITE );
        editorPanel.setBackground ( Color.black );

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

    public static String getContent ()
    {
        String allContent;
        allContent = "";
        allContent = editorPanel.getText () + commentControl.getAllComments ( FileOptionsPanel.theFileName );
        for ( int i = CommentsModel.commentsBag.size () - 1; i >= 0; i-- )//int i = 0; i < colorsArrayList.size (); i++ )
        {
//            allContent += "\n" + colorsArrayList.get ( i ) + ", " + firstIndexes.get ( i ) + ",*" + lastIndexes.get ( i ) + "*,";
            allContent += "\n" + colorsArrayList.get ( i ) + ", " +
                    CommentsModel.commentsBag.get ( i ).start + ",*" +
                    CommentsModel.commentsBag.get ( i ).end + "*,";
        }
        return allContent;
    }

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
//    public static void addNewPointer ( int pos )
//    {
//        //First we delete any previous pointers (if any)
//        //editorPanel.setText(editorPanel.getText().replace(">>",""));
//
//        RemovePointer ();
//
//        //Secondly we add new one
//        String str;
//        str = ">>";
//        editorPanel.insert ( str, pos );
//
//        //reHighlight because normally it loses highlight
//        reHighlight ( CommentsModel.commentsBag );
//    }

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

    public JTextArea getTextArea ()
    {
        return editorPanel;
    }
}
