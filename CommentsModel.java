import java.util.ArrayList;
/**
 * @authors Ahmed Salman, Hissam Faramawy, Atasagun Samed Şanap
 * @version 1.1
 */
public class CommentsModel
{
    static ArrayList <Comment> commentsBag;
    private static EditorAreaPanel display;

    public CommentsModel ( EditorAreaPanel display )
    {
        commentsBag = new ArrayList <Comment> ();
        CommentsModel.display = display;
    }

    /**
     * This method adds comment to the bag and also highlight the code on the panel
     * @param c comment to be added
     */
    public static void addComment ( Comment c )
    {
        commentsBag.add ( c );
        commentsBagChanged ();
        EditorAreaPanel.addHighlight ( c.getColor () );
    }

    /**
     * This method removes the comment from the bag and it also rehighlights the part.
     * @param c comment to be removed
     * @return return true if comment is removed, false it is not found
     */
    public static boolean removeComment ( Comment c )
    {
        int x = 0;
        boolean found;
        found = false;

        for ( int i = 0; i < commentsBag.size (); i++ )
        {
            if ( commentsBag.get ( i ) == c )
            {
                x = i;
            }
            found = true;

            EditorAreaPanel.removeHighlights ();
            EditorAreaPanel.reHighlight ( commentsBag );
        }

        commentsBag.remove ( x );

        commentsBagChanged ();

        return found;

    }

    // Sort comments based on line number from biggest to lowest
    public static void commentsBagChanged ()
    {
//				Comment temp;
//				int maxLine;
//				int maxIndex;
//
//				temp = null;
//				maxIndex = 0;
//
//
//				for( int i = 0; i < commentsBag.size(); i++) {
//					for( int j = i + 1; j < commentsBag.size(); j++) {
//						if( commentsBag.get(j).getLine() > commentsBag.get( maxIndex).getLine()) {
//							maxIndex = j;
//						}
//					}
//					temp = commentsBag.get(maxIndex);
//					commentsBag.set(maxIndex, commentsBag.get(i));
//					commentsBag.set( i, temp);
//					maxIndex = i + 1;
//				}


        CommentShowPanel.update ();


    }


    // public static void pointTheComment( Comment c) {
    //	int pos;
//		String s;

    //	pos = EditorAreaPanel.getPos( c.getLine());
//
    //	EditorAreaPanel.addNewPointer(pos);
//	}

    /**
    * This method returns all comments as string
    * @param fullFileName file name
    * @return returns all comments
    */
    public String getAllComments ( String fullFileName )
    {


        // The Commented Code is Still Under Development, Please don't uncomment it :)
        // ============================================
//		String allComments;
//		allComments = "";
//
//		for (int i = 0; i < commentsBag.size(); i++ )
//		{
////			allComments += "\n" + commentsBag.get(i);
//		}
//		return allComments;
//	}
        // ==========================================
        String allComments;
        allComments = "";

        for ( int i = CommentsModel.commentsBag.size () - 1; i >= 0; i-- )
        {
            if ( CommentsModel.commentsBag.get ( i ).fileName.equals ( fullFileName ) )
            {
                allComments += "\n" + commentsBag.get ( i );
            }
        }
        return allComments;
    }

    //public static Comment[] getAllCommentsLines( int start, int end) {

//	}
}
