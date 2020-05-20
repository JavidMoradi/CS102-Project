import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * @authors Javid Moradi, Atasagun Samed Şanap, Ahmad Salman
 * @version 1.1
 */
public class HomeOptionsPanel extends JPanel
{
    private EditorAreaPanel display;
    private JComboBox fontComboBox;
    private Font displayFont;
    private String fontList[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    private String[] sizes = {"10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28", "30", "32", "34"};
    private JTextField tf;
    private Highlighter.HighlightPainter myHighlightPainter = new MyHighlighPainter ( Color.red );


    public HomeOptionsPanel ( EditorAreaPanel display )
    {
        this.display = display;

        setPreferredSize ( new Dimension ( 280, 130 ) );
        setBorder ( BorderFactory.createLineBorder ( new Color ( 0, 0, 0, 255 ) ) );
        setBackground ( Color.DARK_GRAY );

        JLabel homeLabel = new JLabel ( "HOME" );
        homeLabel.setPreferredSize ( new Dimension ( 200, 20 ) );
        homeLabel.setFont ( new Font ( "Tahoma", Font.BOLD, 18 ) );
        homeLabel.setForeground ( Color.BLACK );
        homeLabel.setBorder ( new LineBorder ( new Color ( 0, 0, 0 ) ) );
        homeLabel.setOpaque ( true );
        homeLabel.setBackground ( Color.WHITE );
        homeLabel.setHorizontalAlignment ( SwingConstants.CENTER );
        add ( homeLabel );

        JComboBox fontComboBox = new JComboBox ();
        fontComboBox.setPreferredSize ( new Dimension ( 181, 25 ) );
        fontComboBox.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        fontComboBox.setBackground ( new Color ( 164, 129, 255 ) );
        fontComboBox.setToolTipText ( "Choose type of the font" );
        for ( int i = 0; i < fontList.length; i++ )
        {
            fontComboBox.addItem ( fontList[i] );
            if ( display.getEditorFont ().getFontName ().equals ( fontList[i] ) )
            {
                fontComboBox.setSelectedItem ( fontList[i] );
            }
        }
        fontComboBox.setForeground ( Color.black );
        fontComboBox.setFont ( new Font ( "Microsoft Tai Le", Font.BOLD, 13 ) );
        add ( fontComboBox );
        fontComboBox.addActionListener ( new FontListener () );

        JComboBox sizeComboBox = new JComboBox ();
        sizeComboBox.setPreferredSize ( new Dimension ( 50, 25 ) );
        sizeComboBox.setBackground ( new Color ( 164, 129, 255 ) );
        sizeComboBox.setToolTipText ( "Choose size of the font" );
        for ( int i = 0; i < sizes.length; i++ )
        {
            sizeComboBox.addItem ( sizes[i] );
            if ( display.getEditorFont ().getSize () == Integer.parseInt ( sizes[i] ) )
            {
                sizeComboBox.setSelectedItem ( sizes[i] );
            }
        }
        sizeComboBox.setForeground ( Color.BLACK );
        sizeComboBox.setFont ( new Font ( "Microsoft Tai Le", Font.BOLD, 13 ) );
        sizeComboBox.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        add ( sizeComboBox );
        sizeComboBox.addActionListener ( new SizeListener () );

        tf = new JTextField ();
        tf.setBackground ( Color.WHITE );
        tf.setColumns ( 23 );
        tf.setToolTipText ( "Enter word(s) you want to search" );
        add ( tf );

        JButton clear = new JButton ( "Clear" );
        clear.setBackground ( new Color ( 164, 129, 255 ) );
        clear.setForeground ( Color.BLACK );
        clear.setFont ( new Font ( "Microsoft Tai Le", Font.BOLD, 13 ) );
        clear.setPreferredSize ( new Dimension ( 115, 25 ) );
        clear.setToolTipText ( "Clear the text" );
        clear.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        clear.addActionListener ( new clearListener () );
        add ( clear );

        JButton find = new JButton ( "Find" );
        find.setBackground ( new Color ( 164, 129, 255 ) );
        find.setForeground ( Color.BLACK );
        find.setFont ( new Font ( "Microsoft Tai Le", Font.BOLD, 13 ) );
        find.setBorder ( BorderFactory.createLineBorder ( Color.BLACK ) );
        find.setPreferredSize ( new Dimension ( 115, 25 ) );
        find.setToolTipText ( "Find the provided word(s)" );
        find.addActionListener ( new findListener () );
        add ( find );

    }

    /**
     * Remove the searched words from text area
     * @param textComp gets the highlights of the text
     */
    public void removeHighlights ( JTextComponent textComp )
    {
        Highlighter hlt = textComp.getHighlighter ();
        Highlighter.Highlight[] hlts = hlt.getHighlights ();

        for ( int i = 0; i < hlts.length; i++ )
        {
            if ( hlts[i].getPainter () instanceof MyHighlighPainter )
            {
                hlt.removeHighlight ( hlts[i] );
            }
        }
    }

    /**
     * Highlight the searched word on the text area
     * @param textComp gets the highlights of the text
     * @param pattern the searched word
     */
    public void highlight ( JTextComponent textComp, String pattern )
    {

        removeHighlights ( textComp );

        try
        {
            Highlighter hlt = textComp.getHighlighter ();
            Document doc = textComp.getDocument ();
            String text = doc.getText ( 0, doc.getLength () );
            int pos = 0;

            while ( ( pos = text.toUpperCase ().indexOf ( pattern.toUpperCase (), pos ) ) >= 0 )
            {
                if ( pattern.equals ( "" ) )
                {
                    break;
                }
                hlt.addHighlight ( pos, pos + pattern.length (), myHighlightPainter );
                pos += pattern.length ();
            }

        } catch ( Exception e )
        {

        }
    }

    /**
     * Set the font of the text area
     */
    class FontListener implements ActionListener
    {
        String fontName;

        public void actionPerformed ( ActionEvent e )
        {
            fontName = ( String ) ( ( JComboBox ) e.getSource () ).getSelectedItem ();
            displayFont = display.getEditorFont ();
            display.setEditorFont ( new Font ( fontName, displayFont.getStyle (), displayFont.getSize () ) );
        }
    }

    /**
     * sets the font size of the text area
     */
    class SizeListener implements ActionListener
    {

        String size;

        public void actionPerformed ( ActionEvent e )
        {
            JComboBox cb = ( JComboBox ) e.getSource ();
            size = ( String ) cb.getSelectedItem ();
            displayFont = display.getEditorFont ();
            display.setEditorFont ( displayFont.deriveFont ( ( float ) Integer.parseInt ( size ) ) );
        }
    }

    /**
     * gets the highlighter color
     */
    class MyHighlighPainter extends DefaultHighlighter.DefaultHighlightPainter
    {
        public MyHighlighPainter ( Color color )
        {
            super ( color );
        }
    }

    /**
     * finds the inserted word and highlights it
     */
    class findListener implements ActionListener
    {

        public void actionPerformed ( ActionEvent e )
        {
            highlight ( display.getTextArea (), tf.getText () );

        }
    }

    /**
     * clear all the highlights
     */
    class clearListener implements ActionListener
    {
        public void actionPerformed ( ActionEvent e )
        {
            Highlighter hlt = display.getTextArea ().getHighlighter ();
            hlt.removeAllHighlights ();
        }
    }

}
