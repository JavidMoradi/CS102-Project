import javax.swing.*;
import java.awt.*;

public class FileExplorerPanel extends JPanel
{
    JEditorPane dtrPnCode;
    public FileExplorerPanel ()
    {
        setPreferredSize( new Dimension( 200, 600 ) );
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
        scrollPane.setLocation( new Point ( 600, 200 ) );

    }
}
