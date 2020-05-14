import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InsertACommentPanel extends JPanel
{

    static Color selectedColor;
    JColorChooser colorChooser;
    JTextField commentField;
    JButton applyButton;
    EditorAreaPanel display;
    JFrame frame;


    public InsertACommentPanel ( EditorAreaPanel display, JFrame frame )
    {
        this.display = display;
        this.frame = frame;

        setLayout ( new BorderLayout () );

        colorChooser = new JColorChooser ();
        add ( colorChooser, BorderLayout.NORTH );
        colorChooser.getSelectionModel ().addChangeListener ( new ColorChangeListener () );

        commentField = new JTextField ();
        commentField.setPreferredSize ( new Dimension ( 650, 80 ) );
        add ( commentField, BorderLayout.CENTER );

        applyButton = new JButton ( "Apply" );
        applyButton.setPreferredSize ( new Dimension ( 100, 40 ) );
        this.add ( applyButton, BorderLayout.SOUTH );
        applyButton.addActionListener ( new ApplyListener () );
    }

    private class ColorChangeListener implements ChangeListener
    {
        public void stateChanged ( ChangeEvent e )
        {
            selectedColor = colorChooser.getColor ();
        }
    }

    private class ApplyListener implements ActionListener
    {
        @Override
        public void actionPerformed ( ActionEvent e )
        {
            Comment c;
            c = new Comment ( commentField.getText (),
                    display.getSelectionFirst (),
                    display.getSelectionLast (),
                    display.getLineNumber ( display.getSelectionFirst () ),
                    selectedColor,
                    FileExplorerPanel.selectedFileName );

            //add comment with 5 parameters!
            CommentsModel.addComment ( c );
            CommentShowPanel.update ();

            frame.dispose ();
        }
    }
}
