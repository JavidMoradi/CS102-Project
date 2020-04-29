package project102;

import java.awt.Color;
import java.util.ArrayList;

public class CommentsModel {
	static ArrayList<Comment> commentsBag;
	
	public CommentsModel(){
		commentsBag = new ArrayList<Comment>();
		
		
	}

	public static void addComment( Comment c) {
		commentsBag.add(c);
	}
	
	public static void removeComment( Comment c) {
		int x = 0;
		
		for(int i = 0; i < commentsBag.size(); i++) {
			if( commentsBag.get(i) == c)
				x = i;
		}
			
		commentsBag.remove(x);
	}
	
	public static void pointTheComment( Comment c) {
		int pos;
		String s;
		
		System.out.println(c);
		pos = EditorAreaPanel.getPos( c.getLine());
		System.out.println( pos);
		
		EditorAreaPanel.addNewPointer(pos);
	}
	
	//public static Comment[] getAllCommentsLines( int start, int end) {
		
//	}
}
