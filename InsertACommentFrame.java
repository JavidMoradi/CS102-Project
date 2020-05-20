import javax.swing.*;
import java.awt.*;
/** 
 * @authors Ahmad Salman, Onuralp Avcı
 * @version 1.1
 */
public class InsertACommentFrame extends JFrame
{

    private InsertACommentPanel insertACommentPanel;

    public InsertACommentFrame ( EditorAreaPanel display )
    {
        super ();
        setPreferredSize ( new Dimension ( 700, 500 ) );
        insertACommentPanel = new InsertACommentPanel ( display, this );
        add ( insertACommentPanel );

        setLayout ( new FlowLayout () );

        pack ();
        setVisible ( true );
    }


}
