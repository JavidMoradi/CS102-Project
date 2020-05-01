import java.awt.*;


public class Comment {
	Color c;
	String comment;
	int start;
	int end;
	int line;
	public Comment (String comment, int start, int end, int line, Color c){
		this.comment = comment;
		this.start = start;
		this.end = end;
		this.line = line;
		this.c = c;
	}
	
	public String getType() {
		return comment;
	}
	
	public int getStartIndex()
	{
		return start;
	}
	
	public int getEndIndex()
	{
		return end;
	}
	
	public Color getColor() {
		return c;
	}
	
	public int getLine()
	{
		return line;
	}
	
	public String toString() {
		return "Line: " + line + ". " + comment;
	}
}