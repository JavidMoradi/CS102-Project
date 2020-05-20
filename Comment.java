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
    private int start;
    private int end;
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

    public String getType ()
    {
        return comment;
    }

    public int getStartIndex ()
    {
        return start;
    }

    public int getEndIndex ()
    {
        return end;
    }

    public Color getColor ()
    {
        return c;
    }

    public int getLine ()
    {
        return line;
    }

    public String toString ()
    {
        return "Line: " + line + ". " + comment;
    }
}
