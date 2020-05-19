import javax.swing.*;
import java.awt.*;

public class ErrorSettingsFrame extends JFrame {

    ErrorSettingPanel settings;
    Dimension size;
    Toolkit toolkit;

    public ErrorSettingsFrame(NewCommentPanel commentPanel) {
        super();
        settings = new ErrorSettingPanel(commentPanel, this);
        add(settings);

        toolkit = getToolkit();
        size = toolkit.getScreenSize();
        setLocation((size.width / 2 - getWidth() / 2) - 350, (size.height / 2 - getHeight() / 2) - 250);

        setLayout(new FlowLayout());

        pack();
        setVisible(true);
    }

}
