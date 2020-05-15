import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;


public class NewCommentPanel extends JPanel {
    Dimension ERRORBUTTONDIMENSION = new Dimension(210, 40);
    Font ERRORFONT = new Font("Microsoft Tai Le", Font.BOLD, 18);

    static ArrayList<Color> errorColors;
    static ArrayList<JButton> errorButtons;
    static ArrayList<String> errorNames;
    int errorNumber;

    File errors;
    FileReader errorsRead;
    BufferedReader bufferedReader;

    EditorAreaPanel display;
    ErrorSettingsFrame errorSettings;

    public NewCommentPanel(EditorAreaPanel display) throws IOException {

        this.display = display;
        setPreferredSize(new Dimension(200, 130));
        setBackground(Color.darkGray);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel insertLabel = new JLabel("ERROR REVIEW OPTIONS");
        insertLabel.setPreferredSize(new Dimension(640, 20));
        insertLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        insertLabel.setForeground(Color.BLACK);
        insertLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
        insertLabel.setOpaque(true);
        insertLabel.setBackground(Color.WHITE);
        insertLabel.setHorizontalAlignment(SwingConstants.CENTER);
        insertLabel.setBounds(200, 36, 201, 40);
        add(insertLabel);

        JButton errorSettingsButton = new JButton();
        errorSettingsButton.setBackground(Color.GRAY);
        errorSettingsButton.setForeground(Color.WHITE);
        errorSettingsButton.setPreferredSize(new Dimension(15, 15));
        add(errorSettingsButton);
        NewCommentPanel thisPanel = this;
        errorSettingsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                errorSettings = new ErrorSettingsFrame(thisPanel);
            }
        });

        errorColors = new ArrayList<Color>();
        errorButtons = new ArrayList<JButton>();
        errorNames = new ArrayList<String>();
        errorNumber = 0;
        errors = new File("errors.txt");

        if (!errors.exists()) {
            errors.createNewFile();
            FileWriter defaultErrors = new FileWriter("errors.txt", true);
            defaultErrors.write("Wrong Indentation,255,0,0\n" +
                                    "Inefficient Code,0,0,255\n" +
                                    "Naming Conventions,255,0,255\n" +
                                    "JavaDoc,24,147,196\n" +
                                    "Blank Line/Space,102,102,102\n" +
                                    "Comment Error,29,171,34\n");
            defaultErrors.close();
        }

        errorsRead = new FileReader(errors);
        bufferedReader = new BufferedReader(errorsRead);
        String errorLine;
        while ((errorLine = bufferedReader.readLine()) != null) {

            String[] errorComponents = errorLine.split(",");
            int red, green, blue;
            Color errorColor;
            JButton errorButton;
            String errorName;

            //errors are drawn from the line
            errorName = errorComponents[0];
            errorNames.add(errorName);

            //errorcolor is created
            red = Integer.parseInt(errorComponents[1]);
            green = Integer.parseInt(errorComponents[2]);
            blue = Integer.parseInt(errorComponents[3]);
            errorColor = new Color(red, green, blue);
            errorColors.add(errorColor);

            //errorbutton is created
            errorButton = new JButton(errorNames.get(errorNumber));
            errorButton.setBackground(errorColors.get(errorNumber));
            errorButton.setForeground(Color.BLACK);
            errorButton.setPreferredSize(ERRORBUTTONDIMENSION);
            errorButton.setFont(ERRORFONT);
            errorButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    Comment errorComment;
                    errorComment = new Comment(errorNames.get(errorNumber),
                            display.getSelectionFirst(),
                            display.getSelectionLast(),
                            display.getLineNumber(display.getSelectionFirst()),
                            errorColors.get(errorNumber),
                            FileExplorerPanel.selectedFileName);
                    CommentsModel.addComment(errorComment);
                    CommentShowPanel.update();
                }
            });
            add ( errorButton );
            errorButtons.add ( errorButton );

            errorNumber++;
        }
        errorsRead.close();
    }

    public void addErrorButton( String newErrorName, Color color) throws IOException {
        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("errors.txt", true)));
        out.println( "newErrorName" + "," + color.getRed() + "," + color.getGreen() + "," + color.getBlue());
        errorNames.add( newErrorName);
        errorColors.add( color);

        JButton errorButton = new JButton(errorNames.get(errorNumber));
        errorButton.setBackground(errorColors.get(errorNumber));
        errorButton.setForeground(Color.BLACK);
        errorButton.setPreferredSize(ERRORBUTTONDIMENSION);
        errorButton.setFont(ERRORFONT);
        errorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Comment errorComment;
                errorComment = new Comment(errorNames.get(errorNumber),
                        display.getSelectionFirst(),
                        display.getSelectionLast(),
                        display.getLineNumber(display.getSelectionFirst()),
                        errorColors.get(errorNumber),
                        FileExplorerPanel.selectedFileName);
                CommentsModel.addComment(errorComment);
                CommentShowPanel.update();
            }
        });
        add ( errorButton );
        errorButtons.add ( errorButton );
        errorNumber++;
    }

    public void editColor(int pos, Color color) {
        errorColors.set(pos, color);
        errorButtons.get(pos).setBackground(color);
    }

    public void editErrorName(int pos, String errorName) {
        errorNames.set(pos, errorName);
        errorButtons.get(pos).setText(errorName);
    }
}
