import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.*;


public class FileExplorerPanel extends JPanel implements ListSelectionListener {

    public static DefaultListModel model;
    JTextField fileName;
    public static JList lstFiles;
    int index;
    File selectedFile;
    ArrayList<Integer> someColorsAndIndexes;


    public FileExplorerPanel() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(280, 220));

        model = new DefaultListModel();
        lstFiles = new JList(model);
        lstFiles.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstFiles.setSelectedIndex(0);
        lstFiles.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(lstFiles);

        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(scrollPane);

        lstFiles.setPreferredSize(new Dimension(250, 150));
        lstFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(lstFiles);
        lstFiles.setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0, 255)));

        fileName = new JTextField(10);
        add(lstFiles, BorderLayout.CENTER);
        lstFiles.setForeground(Color.WHITE);
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

//            someColorsAndIndexes = FileOptionsPanel.getStaticAllColorsAndIndexes();
//            System.out.println(someColorsAndIndexes);
//            System.out.println( FileOptionsPanel.fileName );
//            for (int f = 0; f < allColorsAndIndexes.size(); f += 5)
//            {
//                Color tmpColor;
//
//                int r = allColorsAndIndexes.get(f);
//                int g = allColorsAndIndexes.get(f + 1);
//                int b = allColorsAndIndexes.get(f + 2);
//                tmpColor = new Color(r, g, b);
//                int firstIndex = allColorsAndIndexes.get(f + 3);
//                int lastIndex = allColorsAndIndexes.get(f + 4);
//
//                FileOptionsPanel.displayArea.addHighlight(tmpColor, firstIndex, lastIndex);
//            }
            
       }
        add(lstFiles);
        setVisible(true);
    }
}
