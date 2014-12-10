
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Text extends JPanel{
  
  private SimpleDateFormat dateFormat;
  private JTextArea textArea;
  
  public Text(){
    this.setPreferredSize(new Dimension(700, 50));
    this.setLayout(new BorderLayout());
    this.textArea = new JTextArea();
    this.textArea.setBackground(Color.black);
    this.textArea.setForeground(Color.white);
    this.textArea.setEditable(false);
    this.add(new JScrollPane(this.textArea), BorderLayout.CENTER);
  }
  
  public void showMessage(String message){
    this.textArea.append( message + "\n");
    this.textArea.setCaretPosition(this.textArea.getText().length());
  }
}
