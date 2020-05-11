import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ErrorSettingPanel extends JPanel {

    String [] ERRORS = { "Wrong Indentation", "Inefficient Code", "Naming Conventions Error", "JavaDoc Error", "Blank Line/Space Error", "Comment Error"};
    Color[] colorsArray = { Color.RED, Color.BLUE, Color.MAGENTA,  new Color(24, 147, 196), Color.gray, new Color( 29, 171, 34 )};
    JColorChooser colorChooser;

    static Color selectedColor;
    String selectedError;
    static int selectedErrorPos;

    DefaultListModel model;
    JList errorTypes;
    JScrollPane scrollPane;
    JButton applyButton;

    NewCommentPanel commentPanel;

    public ErrorSettingPanel(NewCommentPanel commentPanel) {
        this.commentPanel = commentPanel;

        setLayout( new BorderLayout());
        model = new DefaultListModel();
        errorTypes = new JList(model);
        errorTypes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        for ( int error = 0; error < ERRORS.length; error++)
            model.addElement( ERRORS[ error]);

        errorTypes.setSelectedIndex(0);
        errorTypes.addListSelectionListener( new ErrorSelectionListener());

        scrollPane = new JScrollPane(errorTypes);
        scrollPane.setPreferredSize( new Dimension( 200, 200));
        this.add(scrollPane,  BorderLayout.WEST);


        errorTypes.setPreferredSize(new Dimension(180, 150));
        errorTypes.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(errorTypes);
        errorTypes.setBackground(new Color(204, 0, 102));

        applyButton = new JButton( "Apply");
        applyButton.setPreferredSize( new Dimension( 100,40));
        this.add( applyButton, BorderLayout.SOUTH);
        applyButton.addActionListener( new ApplyListener());


        colorChooser = new JColorChooser();
        add( colorChooser,  BorderLayout.EAST);
        colorChooser.getSelectionModel().addChangeListener( new ColorChangeListener());


    }


    private class ErrorSelectionListener implements ListSelectionListener {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            selectedError = (String) errorTypes.getSelectedValue();
            for( int error = 0; error < ERRORS.length; error++)
                if ( ERRORS [ error].equals( selectedError))
                    selectedErrorPos = error;
        }
    }

    private class ColorChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            selectedColor = colorChooser.getColor();
        }
    }

    private class ApplyListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            commentPanel.editColor( selectedErrorPos, selectedColor);
        }
    }
}
