
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

@SuppressWarnings("serial")
public class MyComboBox extends JComboBox<String> implements ItemListener {
    private Game game;
    
    public MyComboBox (Game game) {
        this.game = game;
        setBorder(BorderFactory.createTitledBorder("SetSpeed"));
        addItem("FAST");
        addItem("SLOW");
        addItem("NORMAL");
        addItem("SetSpeed");
        setSelectedItem("SetSpeed");// initial
        addItemListener(this);
    }
    
    public void initialize(){
    	setSelectedItem("SetSpeed");
    }

    public void itemStateChanged (ItemEvent e) {
    	
        if(e.getStateChange() == ItemEvent.SELECTED){
            if(((JComboBox)e.getSource()).getSelectedItem().toString().equals("NORMAL"))
            {
            if (game.getSpeedPermit()){
            	game.setSpeed(5);
            	game.Sound(0);
            	game.sendMessage("Player's speed is normal now");
            }
            else {
            	game.sendMessage("Please click on the Player first.");
            	initialize();
            }
        }
        if(((JComboBox)e.getSource()).getSelectedItem().toString().equals("SLOW")){
              if (game.getSpeedPermit()){
              	game.setSpeed(10);
              	game.Sound(0);
              	game.sendMessage("Player's speed is slow now");
              }
              else {
            	  game.sendMessage("Please click on the Player first.");
            	  initialize();
              }
          }
          if(((JComboBox)e.getSource()).getSelectedItem().toString().equals("FAST")){
              if (game.getSpeedPermit()){
              	game.setSpeed(2);
              	game.Sound(1);
              	game.sendMessage("Player's speed is fast now");
              }
              else {
            	  game.sendMessage("Please click on the Player first.");
            	  initialize();
              }
          }
	}
    }
    
}