import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class HomeOptionsPanel extends JPanel
{
    public HomeOptionsPanel()
    {
        setPreferredSize( new Dimension( 200, 130 ) );
        setBorder( BorderFactory.createLineBorder( Color.BLUE) );
        setBackground( Color.darkGray );

        JLabel homeLabel = new JLabel("HOME");
        homeLabel.setPreferredSize(new Dimension(200, 20));
        homeLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        homeLabel.setForeground(Color.BLUE);
        homeLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        homeLabel.setOpaque(true);
        homeLabel.setBackground(Color.WHITE);
        homeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add( homeLabel );

        JComboBox fontComboBox = new JComboBox();
        fontComboBox.setPreferredSize( new Dimension(94, 20) );
        fontComboBox.setBackground(Color.CYAN);
        fontComboBox.setToolTipText("");
        fontComboBox.addItem(" Font ");
        add ( fontComboBox );

        JComboBox sizeComboBox = new JComboBox();
        sizeComboBox.setPreferredSize( new Dimension(94, 20) );
        sizeComboBox.setBackground(Color.CYAN);
        sizeComboBox.setToolTipText("a");
        sizeComboBox.addItem(" Size ");
        add( sizeComboBox );

        JButton commentingAndUncommenting = new JButton("Comment/Uncomment Lines");
        commentingAndUncommenting.setBackground(Color.CYAN);
        commentingAndUncommenting.setBounds(0, 112, 101, 40);
        add ( commentingAndUncommenting );

        JButton indentAll = new JButton("Indent All");
        indentAll.setBackground(Color.CYAN);
        indentAll.setPreferredSize( new Dimension( 195, 25) );
        add ( indentAll );
        
    }
}
