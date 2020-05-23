import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
/**
 * ErrorSettinPanel that contains buttons and a colorchooser to allow user rename and recolor the chosen error types
 * @authors Javid Moradi, Atasagun Samed Şanap, Ahmad Salman
 * @version 1.1
 */
public class ErrorSettingPanel extends JPanel {

    private static Color selectedColor;
    private static int selectedErrorPos;
    private String[] errors = {"Wrong Indentation", "Inefficient Code", "Naming Conventions Error", "JavaDoc Error", "Blank Line/Space Error", "Comment Error"};
    private JColorChooser colorChooser;
    private String selectedError;
    private DefaultListModel model;
    private JList errorTypes;
    private JScrollPane scrollPane;
    private JTextField renameField;
    private JLabel rename;
    private JButton applyButton, okButton, cancelButton;

    private ColorAndText colorAndText;
    private NewCommentPanel commentPanel;

    JFrame frame;


    public ErrorSettingPanel(NewCommentPanel commentPanel, ErrorSettingsFrame frame) {
        this.commentPanel = commentPanel;
        this.frame = frame;

        setLayout(new BorderLayout());
        model = new DefaultListModel();
        errorTypes = new JList(model);
        errorTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        //error names are added
        for (int error = 0; error < errors.length; error++)
            model.addElement(errors[error]);

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

        //buttons are assigned
        JPanel buttonPanel = new JPanel();
        add( buttonPanel, BorderLayout.SOUTH);
        buttonPanel.setLayout( new BorderLayout());
        cancelButton = new JButton("Cancel");
        cancelButton.setPreferredSize(new Dimension(100, 40));
        buttonPanel.add( cancelButton, BorderLayout.WEST );
        cancelButton.addActionListener( new CancelListener());

        JPanel applyAndOkButtonPanel = new JPanel();
        buttonPanel.add( applyAndOkButtonPanel, BorderLayout.EAST);
        applyAndOkButtonPanel.setLayout(new FlowLayout());
        applyButton = new JButton("Apply");
        applyButton.setPreferredSize(new Dimension(100, 40));
        applyAndOkButtonPanel.add(applyButton);
        applyButton.addActionListener(new ApplyListener());

        okButton = new JButton("Ok!");
        okButton.setPreferredSize(new Dimension(100, 40));
        applyAndOkButtonPanel.add(okButton);
        okButton.addActionListener(new OkListener());


    }

    //color and name defining panel
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

    //errorselection listener class to indicate which error is selected
    private class ErrorSelectionListener implements ListSelectionListener
    {
        @Override
        public void valueChanged ( ListSelectionEvent e )
        {
            selectedError = (String) errorTypes.getSelectedValue();
            for ( int error = 0; error < errors.length; error++ )
                if ( errors[error].equals ( selectedError ) )
                    selectedErrorPos = error;
            renameField.setText( errors[selectedErrorPos]);
        }
    }

    //to indicate which color is chosen
    private class ColorChangeListener implements ChangeListener
    {
        public void stateChanged ( ChangeEvent e )
        {
            selectedColor = colorChooser.getColor ();
        }
    }

    //to apply the changes
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

    //to apply the changes and exit
    private class OkListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                commentPanel.editColor(selectedErrorPos, selectedColor);
                commentPanel.editErrorName(selectedErrorPos, renameField.getText());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            frame.dispose();
        }
    }
    //to exit
    private class CancelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    }
}
