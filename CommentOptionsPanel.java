import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CommentOptionsPanel extends JPanel
{
	EditorAreaPanel display;

	 public CommentOptionsPanel ( EditorAreaPanel display )
	    {
	    	this.display = display;
	        setPreferredSize( new Dimension( 533, 130) );
	        setBackground(Color.darkGray);
	        setBorder( BorderFactory.createLineBorder( Color.BLACK) );

	        JLabel commentOptionsLabel = new JLabel( "COMMENT OPTIONS" );
	        commentOptionsLabel.setPreferredSize( new Dimension(450, 20));
	        commentOptionsLabel.setFont( new Font( "Tahoma", Font.BOLD, 18 ) );
	        commentOptionsLabel.setForeground( Color.BLACK );
	        commentOptionsLabel.setBorder( new LineBorder( new Color(0, 0, 0) ) );
	        commentOptionsLabel.setOpaque( true );
	        commentOptionsLabel.setBackground( Color.WHITE );
	        commentOptionsLabel.setHorizontalAlignment( SwingConstants.CENTER );
	        commentOptionsLabel.setBounds( 200, 36, 201, 40 );
	        add ( commentOptionsLabel );

	        JButton insertCommentButton = new JButton("Insert A Comment");
	        insertCommentButton.setBackground(new Color(164, 129, 255));
	        insertCommentButton.setForeground( Color.BLACK );
		insertCommentButton.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
		insertCommentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        insertCommentButton.setPreferredSize( new Dimension( 210, 40) );
	        insertCommentButton.addActionListener((ActionListener) new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
	                JPanel fields = new JPanel(new GridLayout(2, 1));
	                JTextField field = new JTextField(10);
	                JComboBox<String> comboBox = new JComboBox<>(new String[]{"Color 1", "Color 2", "Color 3"});

	                fields.add(field);
	                fields.add(comboBox);

	                int result = JOptionPane.showConfirmDialog(null, fields, "Insert Comment", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
	                switch (result) {
	                    case JOptionPane.OK_OPTION:
	                        // Process the results...
	                        System.out.println(field.getText());
	                        System.out.println( comboBox.getSelectedItem());
	                        break;
	                }
				}

	        });
	        add ( insertCommentButton, BorderLayout.EAST );

		/*
	        JButton nextCommentButton = new JButton("Next Comment");
	        nextCommentButton.setBackground(Color.blue);
	        nextCommentButton.setForeground( Color.WHITE );
	        nextCommentButton.setPreferredSize( new Dimension( 123, 30) );
	        add ( nextCommentButton, BorderLayout.EAST );

	        JButton previousCommentButton = new JButton("Previous Comment");
	        previousCommentButton.setBackground(Color.blue);
	        previousCommentButton.setForeground( Color.WHITE );
	        previousCommentButton.setPreferredSize( new Dimension( 150, 30) );
	        add ( previousCommentButton, BorderLayout.EAST );
		*/

	        JButton deleteCommentButton = new JButton("Delete Comment");
			deleteCommentButton.setBackground(new Color(164, 129, 255));
			deleteCommentButton.setForeground(Color.BLACK);
			deleteCommentButton.setFont(new Font("Microsoft Tai Le", Font.BOLD, 20));
			deleteCommentButton.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	        deleteCommentButton.setPreferredSize( new Dimension( 210, 40) );
	        deleteCommentButton.addActionListener( new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub

					//another way to remove highlight which is adding a black highlight
					//display.addHighlight( new Color( 0,0,0,255), ((Comment)CommentShowPanel.listFiles.getSelectedValue() ).getStartIndex(), ((Comment)CommentShowPanel.listFiles.getSelectedValue() ).getEndIndex() );
					
					CommentsModel.commentsBag.remove(CommentShowPanel.listFiles.getSelectedValue());
					
					display.removeHighlights();
					display.reHighlight(CommentsModel.commentsBag);

					CommentShowPanel.update();
					CommentShowPanel.touchedForTheFirstTime = true;
				}

	        });
	        add ( deleteCommentButton, BorderLayout.EAST );
	    }
}
