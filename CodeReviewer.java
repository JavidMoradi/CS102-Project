import javax.swing.*;
import java.io.IOException;

public class CodeReviewer
{
    public static void main(String[] args) throws IOException
    {
        CodeReviewerFrame frame = new CodeReviewerFrame ( " Program " );
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
}

