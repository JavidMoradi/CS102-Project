import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NewCommentPanel extends JPanel
{
    public NewCommentPanel ()
    {
        setPreferredSize( new Dimension( 400, 130) );
        setBackground( Color.GREEN);
        setBorder( BorderFactory.createLineBorder( Color.BLUE) );

        JLabel insertLabel = new JLabel( "REVIEW OPTIONS" );
        insertLabel.setPreferredSize( new Dimension(400, 25));
        insertLabel.setFont( new Font( "Tahoma", Font.BOLD, 14 ) );
        insertLabel.setForeground( Color.BLUE );
        insertLabel.setBorder( new LineBorder( new Color(0, 0, 0) ) );
        insertLabel.setOpaque( true );
        insertLabel.setBackground( Color.WHITE );
        insertLabel.setHorizontalAlignment( SwingConstants.CENTER );
        insertLabel.setBounds( 200, 36, 201, 40 );
        add ( insertLabel );

//        JLabel errorTypeLabel = new JLabel( "Types of Errors" );
//        errorTypeLabel.setPreferredSize(new Dimension( 250, 25));
//        errorTypeLabel.setForeground( Color.BLUE );
//        errorTypeLabel.setBorder( new LineBorder( new Color(0, 0, 0) ) );
//        errorTypeLabel.setOpaque( true );
//        errorTypeLabel.setBackground( Color.WHITE );
//        errorTypeLabel.setHorizontalAlignment( SwingConstants.CENTER );
//        errorTypeLabel.setBounds( 200, 36, 201, 40 );
//        add ( errorTypeLabel );

        JButton wrongIndentationError = new JButton(" Wrong Indentation");
        wrongIndentationError.setBackground(Color.RED);
        wrongIndentationError.setForeground( Color.WHITE );
        //indentAll.setBounds(0, 148, 201, 40);
        wrongIndentationError.setPreferredSize( new Dimension( 190, 25) );
        add ( wrongIndentationError );

        JButton inefficientError = new JButton("Inefficient Code");
        inefficientError.setBackground(Color.BLUE);
        inefficientError.setForeground( Color.WHITE );
        //indentAll.setBounds(0, 148, 201, 40);
        inefficientError.setPreferredSize( new Dimension( 170, 25) );
        add ( inefficientError );

        JButton namingConventionError = new JButton("Naming Conventions Error");
        namingConventionError.setBackground(Color.MAGENTA);
        namingConventionError.setForeground( Color.WHITE );
        //indentAll.setBounds(0, 148, 201, 40);
        namingConventionError.setPreferredSize( new Dimension( 190, 25) );
        add ( namingConventionError );

        JButton javaDocError = new JButton("JavaDoc Error");
        javaDocError.setBackground(Color.yellow);
        javaDocError.setForeground( Color.BLACK );
        //indentAll.setBounds(0, 148, 201, 40);
        javaDocError.setPreferredSize( new Dimension( 170, 25) );
        add ( javaDocError );

        JButton styleErrorButton = new JButton("Blank Line/Space Error");
        styleErrorButton.setBackground(Color.gray);
        styleErrorButton.setForeground( Color.WHITE );
        //indentAll.setBounds(0, 148, 201, 40);
        styleErrorButton.setPreferredSize( new Dimension( 190, 25) );
        add ( styleErrorButton );

        JButton commentError = new JButton("Comment Error");
        commentError.setBackground(Color.black);
        commentError.setForeground( Color.WHITE );
        //indentAll.setBounds(0, 148, 201, 40);
        commentError.setPreferredSize( new Dimension( 170, 25) );
        add ( commentError );

//        JComboBox errorComboBox = new JComboBox();
//        errorComboBox.setPreferredSize( new Dimension(170, 20) );
//        errorComboBox.setBackground(Color.CYAN);
//        errorComboBox.setToolTipText("");
//        //fontComboBox.setBounds(0, 74, 101, 29);
//        errorComboBox.addItem(" Choose Type ");
//        add ( errorComboBox );


    }

}