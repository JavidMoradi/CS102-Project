import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
/**
 * @authors Javid Moradi, Ahmad Salman, Onuralp Avcı, Hissam Faramawy, Atasagun Samed Şanap
 * @version 1.1
 */ 
public class CommentShowPanel extends JPanel
{
    public static DefaultListModel model;
    public static JList listFiles;
    public static boolean touchedForTheFirstTime;
    public Comment lastSelectedComment;
    private CommentsModel commentsModel;
    private EditorAreaPanel display;

    public CommentShowPanel ( EditorAreaPanel display )
    {
        touchedForTheFirstTime = true;
        commentsModel = new CommentsModel ( display );

        this.display = display;

        model = new DefaultListModel ();
        listFiles = new JList ( model );
        listFiles.setPreferredSize ( new Dimension ( 497, 700 ) );

        JScrollPane scrollPane = new JScrollPane ();
        scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scrollPane.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        scrollPane.setViewportView ( listFiles );

        listFiles.setFont ( new Font ( "Tahoma", Font.PLAIN, 20 ) );
        add ( scrollPane );

        listFiles.getSelectionModel ().addListSelectionListener ( new ListSelectionListener ()
        {
            @Override
            public void valueChanged ( ListSelectionEvent e )
            {
                // TODO Auto-generated method stub
                if ( listFiles.getSelectedValue () != null )
                {
                 //This condition is important to check when alternating between two files!
                    if ( lastSelectedComment != null && !lastSelectedComment.fileName.equals( FileExplorerPanel.selectedFileName))
                        touchedForTheFirstTime = true;
                        
                    if ( touchedForTheFirstTime )
                    {
                        display.addHighlight ( new Color ( 255, 255, 255, 120 ),
                                ( ( Comment ) CommentShowPanel.listFiles.getSelectedValue () ).getStartIndex (),
                                ( ( Comment ) CommentShowPanel.listFiles.getSelectedValue () ).getEndIndex () );
                        lastSelectedComment = ( Comment ) CommentShowPanel.listFiles.getSelectedValue ();
                        touchedForTheFirstTime = false;

                        EditorAreaPanel.setFocus ( lastSelectedComment );
                    }
                    else
                    {
                        display.addHighlight ( lastSelectedComment.getColor (),
                                lastSelectedComment.getStartIndex (),
                                lastSelectedComment.getEndIndex () );
                        display.addHighlight ( new Color ( 255, 255, 255, 120 ),
                                ( ( Comment ) CommentShowPanel.listFiles.getSelectedValue () ).getStartIndex (),
                                ( ( Comment ) CommentShowPanel.listFiles.getSelectedValue () ).getEndIndex () );
                        lastSelectedComment = ( Comment ) CommentShowPanel.listFiles.getSelectedValue ();

                        EditorAreaPanel.setFocus ( lastSelectedComment );
                    }
                }
            }
        } );

        add ( scrollPane );
        add ( listFiles );
        setVisible ( true );
    }

    /**
     * This method updates model using the data from comments bag
     */
    public static void update ()
    {
        if ( model != null )
        {
            model.removeAllElements ();
            for ( int i = 0; i < CommentsModel.commentsBag.size (); i++ )//int i = CommentsModel.commentsBag.size () - 1; i >= 0; i-- )
            {
                if ( FileExplorerPanel.selectedFileName == null || CommentsModel.commentsBag.get ( i ).fileName.equals (
                        FileExplorerPanel.selectedFileName ) )
                {
                    //System.out.println("Equals(update)");
                    model.addElement ( CommentsModel.commentsBag.get ( i ) );
                }
            }
        }
    }
}
