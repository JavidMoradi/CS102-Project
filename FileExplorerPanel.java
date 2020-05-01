import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;


public class FileExplorerPanel extends JPanel implements ListSelectionListener {

    public static DefaultListModel model;
    JTextField fileName;
    public static JList lstFiles;
    int index;
    File selectedFile;


    public FileExplorerPanel() {
        setPreferredSize(new Dimension(200, 220));

        model = new DefaultListModel();
        lstFiles = new JList(model);
        lstFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstFiles.setSelectedIndex(0);
        lstFiles.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(lstFiles);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

        //model.addElement("File Name #0.java");
        //model.addElement("File Name #1.java");

        lstFiles.setPreferredSize(new Dimension(180, 150));
        lstFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(lstFiles);
        lstFiles.setBackground(new Color(204, 0, 102));

        fileName = new JTextField(10);
    }

    @Override
    public void valueChanged(ListSelectionEvent e)
    {
        if (e.getValueIsAdjusting() )
        {
            //FileOptionsPanel.displayArea.setContent( lstFiles.getSelectedValue().toString());
            int i = model.indexOf( lstFiles.getSelectedValue() );
            FileOptionsPanel.displayArea.setContent(FileOptionsPanel.getFileContent(i));

            if( FileOptionsPanel.getFileContent(i) == null )
            {
                FileOptionsPanel.displayArea.setContent("");
            }
       }
        add(lstFiles);
        setVisible(true);
    }
}