

import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

@SuppressWarnings("serial")
public class ControlPanel extends JPanel implements ChangeListener{

	private Container contain;
	private Game game;
	private JSlider slider;
	private MyComboBox speed;
	private MyRadio r1;
	private ItemSizeRadio r2;
	private InnerRoom innerRoom;
	private MyButton move,pick,useKey,useSword,up,down;
	private boolean pause = true;
	
	
	public ControlPanel(Container container,final Game game){
		
		this.setBorder(BorderFactory.createTitledBorder("ControlPanel"));
		this.setPreferredSize(new Dimension(120,100));
		this.setLayout (new GridLayout(10,1));
		
	//this.setBorder (new LineBorder(Color.black,2));
		this.setBackground(Color.white);
		this.contain = container;
		this.game = game;
		
		//add Widgets	    
		this.move = new MyButton ("Move Here");
		ActionListener moveHere= new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	for (int i = 0; i < 7; i++){
	        		Room room = game.getBoard().getRoom(i);
	        		if(room.getSelected()&&room.getLock()){
	        			game.getBoard().setPlayer(true);
	        			room.setPickable(true);
	        			Music move = new Music("move.wav");
	        			move.playEffect("move.wav");
	        			game.getTimer().start();
	        			game.setCurrentPickable(i);
	        			innerRoom.setIniP(350);
	        		}
	        		else{
	        			room.setPickable(false);
	        		}
	        	}
	        	//contain.repaint();
	        }
	    };
	    move.addActionListener(moveHere);
	    add (move);
		
		
		this.pick = new MyButton("Pick Up");
		ActionListener pickItem = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < 6; i++) {
					Room room = game.getBoard().getRoom(i);
					if (room.getPickable()&&room.getCollected()
							&&room.getLock()&&game.getBoard().getPlayer())
					{
						room.getItem().gotItem(game);
						room.getItem().visible = false;
						innerRoom.setItemImage("");
					}
				}
				contain.repaint();
			}
		};
		pick.addActionListener(pickItem);
		add(pick);
		
		this.useKey = new MyButton ("Use Key");
		ActionListener keyUsed= new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	for (int i = 0; i < 6; i++){
	        		Room room = game.getBoard().getRoom(i);
	        		if(room.getSelected()&& !room.getLock()&&game.getKey()){
	        			room.setLock(true);
	        			innerRoom.setRoomImage(room.getImage());
	        			if(room.getItem().visible){
	        				innerRoom.setItemImage(room.getItem().image);
	        			}
	        			}
	        	}
	        	contain.repaint();
	        	
	        }
	    };
	    useKey.addActionListener(keyUsed);
		add(useKey);
		
		this.useSword = new MyButton ("Use Sword");
		ActionListener swordUsed = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Room room = game.getBoard().getRoom(0);
				if (room.getPickable()&&room.getCollected()&&game.getBoard().getPlayer())
					room.getItem().gotItem(game);
				contain.repaint();
			}
		};
	    useSword.addActionListener(swordUsed);
		add(useSword);	 
	
        this.slider = new JSlider(0,300,150);
        slider.setValue(0);
        slider.setPreferredSize(new Dimension(130, 40));
        slider.setBorder(BorderFactory.createTitledBorder(""));
        slider.addChangeListener((javax.swing.event.ChangeListener) this);
        slider.setMajorTickSpacing(20);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setBorder(BorderFactory.createTitledBorder("SetHP"));
        this.add(slider);
        
        this.speed = new MyComboBox (game);
        this.add(speed); 

		this.r1 = new MyRadio (game);
		r1.setLayout(new GridLayout(2,1));
		//r1.initialize(game);
		this.add (r1);
		this.game.setRadioButton(r1);
		
		this.r2 = new ItemSizeRadio (game);
		r2.setLayout(new GridLayout(2,1));
		//r1.initialize(game);
		this.add (r2);
		
		this.up = new MyButton ("↑");
		ActionListener UP = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerRoom.setP(-10);
			}
		};
	    up.addActionListener(UP);
		add(up);
		
		this.down = new MyButton ("↓");
		ActionListener DOWN = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				innerRoom.setP(10);
			}
		};
	    down.addActionListener(DOWN);
		add(down);
		
	}		
	
	public void initialize(){
		this.slider.setValue(0);
		this.r1.initialize();
		this.speed.initialize();
		this.r2.initialize();
	}
	
	public void setPause(boolean pause){
		this.pause = pause;
		move.setEnabled(pause);
		pick.setEnabled(pause);
		useKey.setEnabled(pause);
		useSword.setEnabled(pause);
		up.setEnabled(pause);
		down.setEnabled(pause);
		r1.setEnabled(pause);
		r2.setEnabled(pause);
		speed.setEnabled(pause);
		slider.setEnabled(pause);
	}
	
	public void setStart(boolean start){
		this.pause = start;
		move.setEnabled(pause);
		pick.setEnabled(pause);
		useKey.setEnabled(pause);
		useSword.setEnabled(pause);
		up.setEnabled(pause);
		down.setEnabled(pause);
		r1.setEnabled(pause);
		r2.setEnabled(pause);
		speed.setEnabled(pause);
		slider.setEnabled(pause);
	}
	
	public void setInnerRoom(InnerRoom innerRoom){
		this.innerRoom = innerRoom;
	}
	
    	public void stateChanged(ChangeEvent e) {
    		this.game.setHP(game.getHP() + slider.getValue());
    		contain.repaint();
    	}

	 	protected void paintComponent (Graphics g) {
			super.paintComponent(g);
     		}

}




