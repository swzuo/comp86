
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
public class MyRadio extends JPanel implements ItemListener {

	private Game game;
	private ButtonGroup bg;
	
    
	public MyRadio ( final Game game) {
		this.game = game;
	   // this.game = game;
		// Border around our JPanel
	    setBorder(BorderFactory.createTitledBorder("SetRoom"));
		//setBorder (new LineBorder(Color.blue, 1));

		// ButtonGroup makes them behave as radio buttons
		ButtonGroup g = new ButtonGroup ();

		JRadioButton cb = new JRadioButton ("Lock", false);
		add (cb);
		g.add (cb);
		cb.addItemListener (this);

		cb = new JRadioButton ("Unlock", false);
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
	    
	    if(((JRadioButton)e.getItem()).getText()=="Lock"){
	    	for(int i = 0; i < 7; i++){
	    		Room room = game.getBoard().getRoom(i);
	    		if(room.getSelected() && !room.getPickable()){
	    			game.getBoard().getRoom(i).setLock(false);
	    			game.sendMessage("The room is locked now.");
	    			game.getInnerRoom().setRoomImage("locked.jpg");
	    			game.getInnerRoom().setItemImage("");
	    		}
	    	}
	    }
	    
	    if(((JRadioButton)e.getItem()).getText()=="Unlock")
	    	for(int i = 0; i < 7; i++){
	    		Room room = game.getBoard().getRoom(i);
	    		if(room.getSelected() && !room.getLock()){
	    			game.getBoard().getRoom(i).setLock(true);
	    			game.sendMessage("The room is unlocked now.");
	    			game.getInnerRoom().setRoomImage(room.getImage());
	    			if(room.getItem().visible){
	    				game.getInnerRoom().setItemImage(room.getItem().getItemImage());
	    			}
	    		}
	    	}
	}
    }
}
