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
	        setPreferredSize( new Dimension( 300, 130) );
	        setBackground(Color.green);
	        setBorder( BorderFactory.createLineBorder( Color.BLUE) );

	        JLabel commentOptionsLabel = new JLabel( "COMMENT OPTIONS" );
	        commentOptionsLabel.setPreferredSize( new Dimension(300, 25));
	        commentOptionsLabel.setFont( new Font( "Tahoma", Font.BOLD, 14 ) );
	        commentOptionsLabel.setForeground( Color.BLUE );
	        commentOptionsLabel.setBorder( new LineBorder( new Color(0, 0, 0) ) );
	        commentOptionsLabel.setOpaque( true );
	        commentOptionsLabel.setBackground( Color.WHITE );
	        commentOptionsLabel.setHorizontalAlignment( SwingConstants.CENTER );
	        commentOptionsLabel.setBounds( 200, 36, 201, 40 );
	        add ( commentOptionsLabel );

	        JButton insertCommentButton = new JButton("Insert A Comment");
	        insertCommentButton.setBackground(Color.blue);
	        insertCommentButton.setForeground( Color.WHITE );
	        insertCommentButton.setPreferredSize( new Dimension( 280, 25) );
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

	        JButton deleteCommentButton = new JButton("Delete Comment");
	        deleteCommentButton.setBackground(Color.blue);
	        deleteCommentButton.setForeground( Color.WHITE );
	        deleteCommentButton.setPreferredSize( new Dimension( 280, 25) );
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
