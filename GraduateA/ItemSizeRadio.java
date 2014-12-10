
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

@SuppressWarnings("serial")
public class ItemSizeRadio extends JPanel implements ItemListener {

	private Game game;
	private ButtonGroup bg;
	
    
	public ItemSizeRadio ( final Game game) {
		this.game = game;
	    setBorder(BorderFactory.createTitledBorder("ItemSize"));
		ButtonGroup g = new ButtonGroup ();

		JRadioButton cb = new JRadioButton ("Large", false);
		add (cb);
		g.add (cb);
		cb.addItemListener (this);

		cb = new JRadioButton ("Regular", true);
		add (cb);
		g.add (cb);
		cb.addItemListener (this);
		
		bg = g;

	    }
	
	public void initialize(){
		bg.clearSelection();
	}
	public ButtonGroup getButtonG(){
		return this.bg;
	}
    
    public void itemStateChanged (ItemEvent e) {
	if (e.getStateChange()==ItemEvent.SELECTED) {
	    
	    if(((JRadioButton)e.getItem()).getText()=="Large"){
	    	game.getInnerRoom().setScale(2);
	    }
	    
	    if(((JRadioButton)e.getItem()).getText()=="Regular"){
	    	game.getInnerRoom().setScale(1);
	    }
	}
    }
}
