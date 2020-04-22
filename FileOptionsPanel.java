import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FileOptionsPanel extends JPanel
{
    public FileOptionsPanel ()
    {
        JButton newFile = new JButton( " New File \u2795 " );
        JButton saveFile = new JButton( " Save File \uD83D\uDCBE " ) ;
        JButton openFile = new JButton( " Open File " ) ;
        JButton closeFile = new JButton( " Close File " ) ;

        //newFile.setBackground ( Color.blue );
        //saveFile.setBackground ( Color.blue );
        //openFile.setBackground ( Color.blue );
       //closeFile.setBackground ( Color.blue );

        setLayout ( new FlowLayout() );
        setPreferredSize( new Dimension ( 430, 35 ) );
        setBackground( Color.BLUE );
        setLocation( 500, 500 );


        add ( newFile );
        add ( saveFile );
        add ( openFile );
        add ( closeFile );

    }
}
