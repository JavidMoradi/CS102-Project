import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;


public class FileExplorerPanel extends JPanel implements ListSelectionListener
{

    public static DefaultListModel model;
    public static JList lstFiles;
    static String FileNamesForComments;
    static String selectedFileName;
    JTextField fileName;
    int index;
    File selectedFile;
    ArrayList <Integer> someColorsAndIndexes;


    public FileExplorerPanel ()
    {
        setLayout ( new BorderLayout () );
        setPreferredSize ( new Dimension ( 280, 220 ) );
        selectedFileName = null;

        model = new DefaultListModel ();
        lstFiles = new JList ( model );
        lstFiles.setSelectionMode ( ListSelectionModel.SINGLE_SELECTION );
        lstFiles.setSelectedIndex ( 0 );
        lstFiles.addListSelectionListener ( this );
        JScrollPane scrollPane = new JScrollPane ( lstFiles );

        scrollPane.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
        scrollPane.setHorizontalScrollBarPolicy ( ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
        this.add ( scrollPane );

        lstFiles.setPreferredSize ( new Dimension ( 250, 150 ) );
        lstFiles.setFont ( new Font ( "Tahoma", Font.PLAIN, 20 ) );
        scrollPane.setViewportView ( lstFiles );
        lstFiles.setBackground ( Color.darkGray );
        setBorder ( BorderFactory.createLineBorder ( new Color ( 0, 0, 0, 255 ) ) );

        fileName = new JTextField ( 10 );
        add ( lstFiles, BorderLayout.CENTER );
        lstFiles.setForeground ( Color.WHITE );
    }

    @Override
    public void valueChanged ( ListSelectionEvent e )
    {
        if ( e.getValueIsAdjusting () )
        {
            selectedFileName = ( String ) lstFiles.getSelectedValue ();

            //FileOptionsPanel.displayArea.setContent( lstFiles.getSelectedValue().toString());
            int i = model.indexOf ( lstFiles.getSelectedValue () );
            FileOptionsPanel.displayArea.setContent ( FileOptionsPanel.getFileContent ( i ) );

            if ( FileOptionsPanel.getFileContent ( i ) == null )
            {
                FileOptionsPanel.displayArea.setContent ( "" );
            }

            EditorAreaPanel.setFocus ( 0 );
            /// FileNamesForComments = model.getElementAt(model.indexOf( lstFiles.getSelectedValue() )).toString();
            /// System.out.println( FileNamesForComments);

            ///
//                        for(int k = 0; k <  CommentsModel.commentsBag.size(); k++)
//            {
//                if(CommentsModel.commentsBag.get(k).toString().contains((CharSequence)model.getElementAt(i).toString()))
//                {
//                    EditorAreaPanel.reHighlight(CommentsModel.commentsBag.get(k));
//                    //EditorAreaPanel.reHighlight(CommentShowPanel.model.get(k));
//                    System.out.println(CommentsModel.commentsBag.get(k).toString());
//
//                }
//            }

        }
        EditorAreaPanel.reHighlight ( CommentsModel.commentsBag );
        CommentShowPanel.update ();

        add ( lstFiles );
        setVisible ( true );
    }
}
