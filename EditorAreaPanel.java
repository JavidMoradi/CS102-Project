import javax.swing.*;
import java.awt.*;

public class EditorAreaPanel extends JPanel
{
    JTextArea editorPanel;
     int a,b;
    JButton test;

    public EditorAreaPanel ()
    {
        test = new JButton("TEST");
    	a = 0;
    	b = 0;
        
        editorPanel = new JTextArea("import java.util.Scanner;\r\n" + 
        		"public class Example\r\n" + 
        		"{\r\n" + 
        		"   public static void main(String args[])\r\n" + 
        		"   {\r\n" + 
        		"	int counter, i=0, j=0, temp;\r\n" + 
        		"	int number[] = new int[100];\r\n" + 
        		"	Scanner scanner = new Scanner(System.in);\r\n" + 
        		"	System.out.print(\"How many elements you want to enter: \");\r\n" + 
        		"	counter = scanner.nextInt();\r\n" + 
        		"\r\n" + 
        		"	/* This loop stores all the elements that we enter in an \r\n" + 
        		"	 * the array number. First element is at number[0], second at \r\n" + 
        		"	 * number[1] and so on\r\n" + 
        		"	 */\r\n" + 
        		"	for(i=0; i<counter; i++)\r\n" + 
        		"	{\r\n" + 
        		"	    System.out.print(\"Enter Array Element\"+(i+1)+\": \");\r\n" + 
        		"	    number[i] = scanner.nextInt();\r\n" + 
        		"	}\r\n" + 
        		"	j = i - 1;     \r\n" + 
        		"	i = 0;         \r\n" + 
        		"	scanner.close();\r\n" + 
        		"	while(i<j)\r\n" + 
        		"	{\r\n" + 
        		"  	   temp = number[i];\r\n" + 
        		"	   number[i] = number[j];\r\n" + 
        		"	   number[j] = temp;\r\n" + 
        		"	   i++;\r\n" + 
        		"	   j--;\r\n" + 
        		"	}\r\n" + 
        		"\r\n" + 
        		"	System.out.print(\"Reversed array: \");\r\n" + 
        		"	for(i=0; i<counter; i++)\r\n" + 
        		"	{\r\n" + 
        		"	   System.out.print(number[i]+ \"  \");\r\n" + 
        		"	}       \r\n" + 
        		"   }\r\n" + 
        		"}");
        editorPanel.setVisible( true );
        editorPanel.setRows( 19 );
        editorPanel.setColumns( 40 );
        editorPanel.setWrapStyleWord( true );
        editorPanel.setFont(new Font ("Tahoma", Font.PLAIN, 19) );
        JScrollPane scrollPane = new JScrollPane( editorPanel );
        
                DefaultHighlighter highlighter =  (DefaultHighlighter)editorPanel.getHighlighter();
        DefaultHighlighter.DefaultHighlightPainter painter = new DefaultHighlighter.DefaultHighlightPainter( Color.RED );
        highlighter.setDrawsLayeredHighlights(false); // this is the key line
        
        
        
        test.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		a = editorPanel.getSelectionStart();
        		b = editorPanel.getSelectionEnd();
        		try {
        			highlighter.addHighlight(a, b, painter );
        		} catch (BadLocationException exeption) {
        			// TODO Auto-generated catch block
        			exeption.printStackTrace();
        		}
        	}

        });
        
        add(test);
        add ( scrollPane );
    }
    
    public void setContent ( String str )
    {
        editorPanel.setText( str );
    }

    public String getContent ()
    {
        return editorPanel.getText();
    }
}
