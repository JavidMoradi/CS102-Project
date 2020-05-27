import java.awt.*;
/**
 * @authors Ahmad Salman, Hissam Faramawy
 * @version 1.1
 */
public class Comment
{
    private Color c;
    private String comment;
    String fileName;
    public int start;
    public int end;
    private int line;

    public Comment ( String comment, int start, int end, int line, Color c )
    {
        this.comment = comment;
        this.start = start;
        this.end = end;
        this.line = line;
        this.c = c;
    }

    public Comment ( String comment, int start, int end, int line, Color c, String fileName )
    {
        this.comment = comment;
        this.start = start;
        this.end = end;
        this.line = line;
        this.c = c;
        this.fileName = fileName;
    }

    /**
     * 
     * @return the comment as string
     */
    public String getType ()
    {
        return comment;
    }

    /**
     * 
     * @return start index of the comment as int
     */
    public int getStartIndex ()
    {
        return start;
    }

    /**
     * 
     * @return end index of comment as int
     */
    public int getEndIndex ()
    {
        return end;
    }

    /**
     * 
     * @return return color of the comment as Color
     */
    public Color getColor ()
    {
        return c;
    }

    /**
     * 
     * @return line number of comment as int
     */
    public int getLine ()
    {
        return line;
    }

    public String toString ()
    {
        return "Line: " + line + ". " + comment;
    }
}
