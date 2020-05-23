import javax.swing.*;
import java.awt.*;
/**
 * ErrorSEttingsFrame that has a panel to allow user rename and recolor errors
 * @authors Javid Moradi, Ahmad Salman, Atasagun Samed Şanap
 * @version 1.1
 */
public class ErrorSettingsFrame extends JFrame {

    private ErrorSettingPanel settings;
    private Dimension size;
    private Toolkit toolkit;

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
