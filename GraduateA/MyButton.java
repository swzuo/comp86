
import java.awt.*;
import javax.swing.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

@SuppressWarnings("serial")
public class MyButton extends JButton{

	public MyButton (String label) {
	setText (label);
	setForeground (Color.DARK_GRAY);
	setPreferredSize( new Dimension(20,0));
    }
}