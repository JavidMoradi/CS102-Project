import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class FileExplorerPanel extends JPanel
{
    JEditorPane dtrPnCode;
    public FileExplorerPanel ()
    {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(-1, 187, 196, 556);
        add(scrollPane);

        DefaultListModel<String> model = new DefaultListModel<String>();

        JList lstFiles = new JList(new AbstractListModel()
        {
            String[] values = new String[]{"File Name #0.java", "File Name #1.java", "File Name #2.java"};

            public int getSize()
            {
                return values.length;
            }

            public Object getElementAt( int index )
            {
                return values[index];
            }
        });
        lstFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(lstFiles);
        lstFiles.setBackground(new Color(204, 0, 102));
        //scrollPane.setLocation( new Point ( 600, 200 ) );

        JLabel lblIcon = new JLabel("");
        lblIcon.setIcon(new ImageIcon("C:\\Users\\onura\\Desktop\\CSProject\\Pictures\\Resim1.png"));
        lblIcon.setBounds(690, 0, 471, 188);
        add(lblIcon);

    }
}
