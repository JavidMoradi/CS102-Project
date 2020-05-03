import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeOptionsPanel extends JPanel
{
    EditorAreaPanel display;
    JComboBox fontComboBox;
    Font displayFont;
    String fontList[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String[] sizes = { "16", "18", "20", "22", "24", "26", "28", "30", "32", "34" };
    JTextField tf;
    Highlighter.HighlightPainter myHighlightPainter = new MyHighlighPainter(Color.cyan);


    public HomeOptionsPanel( EditorAreaPanel display)
    {
        this.display = display;

        setPreferredSize( new Dimension( 200, 130 ) );
        setBorder( BorderFactory.createLineBorder( Color.BLUE) );
        setBackground( Color.darkGray );

        JLabel homeLabel = new JLabel("HOME");
        homeLabel.setPreferredSize(new Dimension(200, 20));
        homeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        homeLabel.setForeground(Color.BLUE);
        homeLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        homeLabel.setOpaque(true);
        homeLabel.setBackground(Color.WHITE);
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add( homeLabel );

        JComboBox fontComboBox = new JComboBox();
        fontComboBox.setPreferredSize( new Dimension(94, 20) );
        fontComboBox.setBackground(Color.CYAN);
        fontComboBox.setToolTipText("Choose type of the font");
        for (int i = 0; i < fontList.length; i++) {
            fontComboBox.addItem(fontList[i]);
            if( display.getEditorFont().getFontName().equals(fontList[i]))
                fontComboBox.setSelectedItem( fontList[i]);
        }
        add ( fontComboBox );
        fontComboBox.addActionListener(new FontListener());

        JComboBox sizeComboBox = new JComboBox();
        sizeComboBox.setPreferredSize( new Dimension(94, 20) );
        sizeComboBox.setBackground(Color.CYAN);
        sizeComboBox.setToolTipText("Choose size of the font");
        for (int i = 0; i < sizes.length; i++) {
            sizeComboBox.addItem(sizes[i]);
            if( display.getEditorFont().getSize() == Integer.parseInt(sizes[i]))
                sizeComboBox.setSelectedItem( sizes[i]);
        }
        add( sizeComboBox );
        sizeComboBox.setSelectedIndex(1);
        sizeComboBox.addActionListener( new SizeListener());

        tf = new JTextField();
        tf.setBackground(Color.WHITE);
        tf.setColumns(19);
        tf.setToolTipText("Enter word(s) you want to search");
        add ( tf );

        JButton clear = new JButton("Clear");
        clear.setBackground(Color.CYAN);
        clear.setPreferredSize( new Dimension( 90, 40) );
        clear.setToolTipText("Clear the text");
        clear.addActionListener(new clearListener());
        add ( clear );

        JButton find = new JButton("Find");
        find.setBackground(Color.CYAN);
        find.setPreferredSize( new Dimension( 90, 40) );
        find.setToolTipText("Find the provided word(s)");
        find.addActionListener(new findListener());
        add ( find );

    }

    class FontListener implements ActionListener {
        String fontName;
        public void actionPerformed( ActionEvent e) {
            fontName = (String) ((JComboBox) e.getSource()).getSelectedItem();
            displayFont = display.getEditorFont();
            display.setEditorFont( new Font( fontName, displayFont.getStyle(), displayFont.getSize() ));
        }
    }

    /*
    class CommentListener implements ActionListener {
        int begin;
        int end;
        String content;
        boolean isCommented;

        public void actionPerformed( ActionEvent e) {
            begin = display.getSelectionFirst();
            end = display.getSelectionLast();
            content = display.getContent();
            if( begin != end) {
                for (int newLine = begin; newLine <= end; newLine++) {
                    if (!content.substring(newLine, newLine + 2).equals("//")) {
                        if (content.substring(newLine - 2, newLine - 1).equals("\n")) {
                            content = content.substring(0, newLine ) + "//" + content.substring(newLine);
                        }
                    } else {
                        content = content.substring(0, newLine) + content.substring(newLine + 2);
                    }
                }
            }
            display.setContent( content);
        }
    }
    */

    class SizeListener implements ActionListener {

        String size;
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            size = (String) cb.getSelectedItem();
            displayFont = display.getEditorFont();
            display.setEditorFont(displayFont.deriveFont((float)Integer.parseInt(size)));
        }
    }

    class MyHighlighPainter extends DefaultHighlighter.DefaultHighlightPainter {
        public MyHighlighPainter(Color color) {
            super(color);
        }
    }

    public void removeHighlights(JTextComponent textComp) {
        Highlighter hlt = textComp.getHighlighter();
        Highlighter.Highlight[] hlts = hlt.getHighlights();

        for (int i = 0; i < hlts.length; i++) {
            if (hlts[i].getPainter() instanceof MyHighlighPainter) {
                hlt.removeHighlight(hlts[i]);
            }
        }
    }

    public void highlight (JTextComponent textComp, String pattern) {

        removeHighlights(textComp);

        try {
            Highlighter hlt = textComp.getHighlighter();
            Document doc = textComp.getDocument();
            String text = doc.getText(0, doc.getLength());
            int pos = 0;

            while ((pos = text.toUpperCase().indexOf(pattern.toUpperCase(), pos)) >= 0) {
                if( pattern.equals("") ) {
                    break;
                }
                hlt.addHighlight(pos, pos + pattern.length(), myHighlightPainter);
                pos += pattern.length();
            }

        } catch ( Exception e ) {

        }
    }

    class findListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            highlight(display.getTextArea(), tf.getText());

        }
    }

    class clearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Highlighter hlt = display.getTextArea().getHighlighter();
            hlt.removeAllHighlights();
        }
    }

}