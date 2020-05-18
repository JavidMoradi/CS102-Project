import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class ErrorSettingPanel extends JPanel {

    static Color selectedColor;
    static int selectedErrorPos;
    String[] ERRORS = {"Wrong Indentation", "Inefficient Code", "Naming Conventions Error", "JavaDoc Error", "Blank Line/Space Error", "Comment Error"};
    JColorChooser colorChooser;
    String selectedError;
    DefaultListModel model;
    JList errorTypes;
    JScrollPane scrollPane;
    JTextField renameField;
    JLabel rename;
    JButton applyButton;

    ColorAndText colorAndText;
    NewCommentPanel commentPanel;

    public ErrorSettingPanel(NewCommentPanel commentPanel) {
        this.commentPanel = commentPanel;

        setLayout(new BorderLayout());
        model = new DefaultListModel();
        errorTypes = new JList(model);
        errorTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for (int error = 0; error < ERRORS.length; error++)
            model.addElement(ERRORS[error]);

        errorTypes.setSelectedIndex(0);
        errorTypes.addListSelectionListener(new ErrorSelectionListener());

        scrollPane = new JScrollPane(errorTypes);
        scrollPane.setPreferredSize(new Dimension(200, 200));
        add(scrollPane, BorderLayout.WEST);


        errorTypes.setPreferredSize(new Dimension(180, 150));
        errorTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(errorTypes);
        errorTypes.setBackground(new Color(204, 0, 102));


        colorAndText = new ColorAndText();
        colorAndText.setPreferredSize(new Dimension(600, 360));
        add(colorAndText, BorderLayout.EAST);

        applyButton = new JButton("Apply");
        applyButton.setPreferredSize(new Dimension(100, 40));
        add(applyButton, BorderLayout.SOUTH);
        applyButton.addActionListener(new ApplyListener());

    }

    private class ColorAndText extends JPanel {
        public ColorAndText() {
            colorChooser = new JColorChooser();
            add(colorChooser, BorderLayout.NORTH);
            colorChooser.getSelectionModel().addChangeListener(new ColorChangeListener());

            rename = new JLabel("Rename your error: ");
            add(rename, BorderLayout.WEST);

            renameField = new JTextField();
            renameField.setPreferredSize(new Dimension(300, 30));
            add(renameField, BorderLayout.SOUTH);
        }
    }

    private class ErrorSelectionListener implements ListSelectionListener
    {
        @Override
        public void valueChanged ( ListSelectionEvent e )
        {
            selectedError = (String) errorTypes.getSelectedValue();
            for ( int error = 0; error < ERRORS.length; error++ )
                if ( ERRORS[error].equals ( selectedError ) )
                    selectedErrorPos = error;
        }
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
        public void actionPerformed(ActionEvent e) {
            try {
                commentPanel.editColor(selectedErrorPos, selectedColor);
                commentPanel.editErrorName(selectedErrorPos, renameField.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
