import javax.swing.*;
import java.awt.*;

public class InsertACommentFrame extends JFrame {

    InsertACommentPanel insertACommentPanel;
    public InsertACommentFrame( EditorAreaPanel display) {
        super();
        setPreferredSize( new Dimension( 700, 500 ) );;
        insertACommentPanel = new InsertACommentPanel( display , this);
        add( insertACommentPanel);

        setLayout ( new FlowLayout() );

        pack();
        setVisible(true);
    }




}
