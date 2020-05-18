import javax.swing.*;
import java.awt.*;

public class ErrorSettingsFrame extends JFrame
{

    ErrorSettingPanel settings;

    public ErrorSettingsFrame ( NewCommentPanel commentPanel )
    {
        super ();
        setPreferredSize ( new Dimension ( 1080, 720 ) );
        settings = new ErrorSettingPanel ( commentPanel );
        add ( settings );

        setLayout ( new FlowLayout () );

        pack ();
        setVisible ( true );
    }


}
