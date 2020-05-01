import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class CommentShowPanel extends JPanel
{
   public static DefaultListModel model;
   static JList listFiles;
   CommentsModel commentsModel;
   EditorAreaPanel display;

   public CommentShowPanel( EditorAreaPanel display )
   {
	   commentsModel = new CommentsModel();

	   this.display = display;

	   model = new DefaultListModel();
	   listFiles = new JList(model);
	   listFiles.setPreferredSize( new Dimension( 500, 700 ) );

       JScrollPane scrollPane = new JScrollPane();
       scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
       scrollPane.setViewportView(listFiles);

       listFiles.setFont(new Font("Tahoma", Font.PLAIN, 20));
       add(scrollPane);

       listFiles.getSelectionModel().addListSelectionListener( new ListSelectionListener() {
		@Override
		public void valueChanged(ListSelectionEvent e) {
			// TODO Auto-generated method stub
			if( (Comment)listFiles.getSelectedValue() != null)
				CommentsModel.pointTheComment( (Comment)listFiles.getSelectedValue());
		}
       });

       add(scrollPane);
	   add(listFiles);

      //commentJTextArea = new JTextArea("Line 5: You should avoid doing mistakes\r\n"
        //    + "Line 15: Better to use JButton instead of Button\r\n"
          //  + "Line 34: Names does not make sense! \r\n");
      //commentJTextArea.setVisible(true);
      //commentJTextArea.setRows(19);
      //commentJTextArea.setColumns(40);
     // commentJTextArea.setWrapStyleWord(true);
      //commentJTextArea.setFont(new Font("Tahoma", Font.PLAIN, 19));
      //JScrollPane scrollPane = new JScrollPane(commentJTextArea);
      //add(scrollPane);
   }

   public static void update() {

	   if( model != null) {
		   model.removeAllElements();
		   	for(int i = 0; i < CommentsModel.commentsBag.size(); i++)
		   		model.addElement(CommentsModel.commentsBag.get(i));
	   }
   }

   public void setComments ( String allComments )
   {
       int numberOfLines;
       numberOfLines = 0;
       String[] lines = allComments.split("\r\n|\r|\n");
       //numberOfLines = lines.length;
       for ( int i = 1; i < lines.length; i++ )
       {
           model.addElement( lines[i] );
       }
   }
}
