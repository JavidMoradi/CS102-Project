import java.awt.GraphicsEnvironment;

import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeOptionsPanel extends JPanel
{
    EditorAreaPanel display;
    JComboBox fontComboBox;
    Font displayFont;
    String fontList[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    String[] sizes = { "8", "9", "10", "11", "12", "14", "16", "18", "20", "22" };
    
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
        fontComboBox.setToolTipText("");
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
        sizeComboBox.setToolTipText("a");
        for (int i = 0; i < sizes.length; i++) {
            sizeComboBox.addItem(sizes[i]);
            if( display.getEditorFont().getSize() == Integer.parseInt(sizes[i]))
                sizeComboBox.setSelectedItem( sizes[i]);
        }
        add( sizeComboBox );
        sizeComboBox.addActionListener( new SizeListener());

        JButton commentingAndUncommenting = new JButton("Comment/Uncomment");
        commentingAndUncommenting.setBackground(Color.CYAN);
        commentingAndUncommenting.setBounds(0, 112, 101, 40);
        add ( commentingAndUncommenting );
        commentingAndUncommenting.addActionListener( new CommentListener());

        JButton indentAll = new JButton("Indent All");
        indentAll.setBackground(Color.CYAN);
        indentAll.setPreferredSize( new Dimension( 195, 25) );
        add ( indentAll );
        
    }
        
    class FontListener implements ActionListener {
        String fontName;
        public void actionPerformed( ActionEvent e) {
            fontName = (String) ((JComboBox) e.getSource()).getSelectedItem();
            displayFont = display.getEditorFont();
            display.setEditorFont( new Font( fontName, displayFont.getStyle(), displayFont.getSize() ));
        }
    }

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
    
    class SizeListener implements ActionListener {

        String size;
        public void actionPerformed(ActionEvent e) {
            JComboBox cb = (JComboBox) e.getSource();
            size = (String) cb.getSelectedItem();
            displayFont = display.getEditorFont();
            display.setEditorFont(displayFont.deriveFont((float)Integer.parseInt(size)));
        }
    }
}