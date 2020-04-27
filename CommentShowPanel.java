import javax.swing.*;
import java.awt.*;

public class CommentShowPanel extends JPanel
{
    static JTextArea commentJTextArea;
   static String comments = "";

   public CommentShowPanel() {

      commentJTextArea = new JTextArea("Line 5: You should avoid doing mistakes\r\n"
            + "Line 15: Better to use JButton instead of Button\r\n"
            + "Line 34: Names does not make sense! \r\n");
      commentJTextArea.setVisible(true);
      commentJTextArea.setRows(19);
      commentJTextArea.setColumns(40);
      commentJTextArea.setWrapStyleWord(true);
      commentJTextArea.setFont(new Font("Tahoma", Font.PLAIN, 19));
      JScrollPane scrollPane = new JScrollPane(commentJTextArea);

      add(scrollPane);
   }

   public static void addComment(String str) {
      comments += str + "\r\n"  ;
      commentJTextArea.setText(comments);
    }

}
