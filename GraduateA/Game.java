
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

@SuppressWarnings("serial")
public class Game extends JComponent implements MouseListener, ActionListener{

	private Board board;
	private int HP;
	private boolean key;
	private boolean sword;
	private int monster;
	private int gold;
	private Timer timerPlayer;
	private int speed;
	private int initialPlayerX = 30;
	private int initialPlayerY = 440;
	private boolean setSpeed;
	private int playerArrived;
	private int sound;
	private Music theme;
	private Music hispeed;
	private Music select;
	private MyRadio myRadio;
	private InnerRoom innerRoom;
	private Text text;
	private int currentSelect;
	private int currentPickable;
	private boolean pause = false;
	
    public Game (Board board) {
    	addMouseListener (this);
    	this.board = board;
    	this.HP = 100;
    	this.key = false;
    	this.sword = false;
    	this.monster = 500;
    	this.gold = 0;
    	this.timerPlayer = new Timer(100, this);
    	this.speed = 5;
    	this.setSpeed = false;
    	this.playerArrived = 2;
    	this.theme = new Music("theme.wav");
    	this.hispeed = new Music("hispeed.wav");
    	this.select = new Music("selected.wav");
    	this.sound = 0;
    	this.currentPickable = 6;
    	this.currentSelect = 6;
    }
    
    public void initialize(){
    	this.HP = 100;
    	this.key = false;
    	this.sword = false;
    	this.monster = 500;
    	this.gold = 0;
    	this.speed = 5;
    	this.setSpeed = false;
    	this.playerArrived = 2;
    	this.sound = 0;
    	this.Sound(sound);
    	this.initialPlayerX = 30;
    	this.initialPlayerY = 440;
    	this.currentPickable = 6;
    	this.currentSelect = 6;
    	this.sendMessage("================================Start!================================");
    }
    
    public void setPause(boolean pause){
    	this.pause = pause;
    }
    
    public void setRadioButton( MyRadio myRadio){
    	this.myRadio = myRadio;
    }
    
    public void setInnerRoom(InnerRoom innerRoom){
    	this.innerRoom = innerRoom;
    }
    
    public void setText(Text text){
    	this.text = text;
    }
    
    public void Sound(int sound){
    	this.sound = sound;
    	if(sound == 0){
    		theme.playMusic();
    		hispeed.stopMusic();
    	}
    	if(sound == 1){
    		theme.stopMusic();
    		hispeed.playMusic();
    	}
    	
    	if(sound == 2){
    		theme.stopMusic();
    		hispeed.stopMusic();
    	}
    	
    }
    
    public void setSpeed(int speed){
    	this.speed = speed;
    }
    
    public boolean getSpeedPermit(){
    	return setSpeed;
    }
    
    public Board getBoard(){
    	return board;
    }

    public void actionPerformed (ActionEvent e){
		int xStep = (initialPlayerX - board.getRecX())/speed;//
		int yStep = (initialPlayerY - board.getRecY())/speed;
		
		if(xStep == 0 && yStep == 0){//same room
			stopTimer();
			playerArrived = 1;
		}

    	if (xStep <= 0){//initially left or same column
    		if (yStep > 0){//initially left and downside
    			if(board.getPlayerX() >= board.getRecX() && board.getPlayerY() <= board.getRecY()){
    				stopTimer();
    				playerArrived = 1;
    				initialPlayerY = board.getPlayerY();
    				initialPlayerX = board.getPlayerX();
    			}
    			else {
    				playerArrived = 0;
    				board.setPlayerX(-xStep);
    				board.setPlayerY(-yStep);
    				this.repaint();
    			}
    			
    		}
    		if (yStep < 0){//initially left and upside
    			if(board.getPlayerX() >= board.getRecX() && board.getPlayerY() >= board.getRecY()){
    				stopTimer();
    				playerArrived = 1;
    				initialPlayerY = board.getPlayerY();
    				initialPlayerX = board.getPlayerX();
    			}
    			else {
    				playerArrived = 0;
    				board.setPlayerX(-xStep);
    				board.setPlayerY(-yStep);
    				this.repaint();
    			}
    			
    		}
    	}//initially Left
    	
    	if (xStep > 0){//initially right
    		if (yStep > 0){//initially right and downside
    			if(board.getPlayerX() <= board.getRecX() && board.getPlayerY() >= board.getRecY()){
    				stopTimer();
    				initialPlayerX = board.getPlayerX();
    				initialPlayerY = board.getPlayerY();
    				playerArrived = 1;
    			}
    			else {
    				playerArrived = 0;
    				board.setPlayerX(-xStep);
    				board.setPlayerY(-yStep);
    				this.repaint();
    			}
    			
    		}
    		if (yStep < 0){//initially left and up
    			if(board.getPlayerX() <= board.getRecX() && board.getPlayerY() >= board.getRecY()){
    				stopTimer();
    				playerArrived = 1;
    				initialPlayerX = board.getPlayerX();
    				initialPlayerY = board.getPlayerY();
    			}
    			else {
    				playerArrived = 0;
    				board.setPlayerX(-xStep);
    				board.setPlayerY(-yStep);
    				this.repaint();
    			}
    			
    		}
    	}
    }
   
    public Timer getTimer(){
    	return timerPlayer;
    }

    public void stopTimer(){
    	timerPlayer.stop();
    }
    
    public void sendMessage(String message){
        this.text.showMessage(message);
      }
    
    public void paintComponent(Graphics g){
    	if(!pause){
    		board.paintComponent(g);
    	}    	
    }
    
    public void setKey(boolean key){
    	this.key = key;
    }
    
    public boolean getKey(){
    	return key;
    }
    
    public void setGold(int gold){
    	this.gold = gold;
    }
    
    public int getGold(){
    	return gold;    	
    }
    
    public void setHP(int HP){
    	this.HP = HP;
    }
    
    public int getHP(){
    	return HP;
    }
    
    public void setMonster(int monster){
    	this.monster = monster;
    }
    
    public int getMonster(){
    	return monster;
    }
    
    public void setSword(boolean sword){
    	this.sword = sword;
    }
    
    public boolean getSword(){
    	return sword;
    }
    
    public int getPlayerArrived(){
    	return playerArrived;
    }
    
    public void setCurrentSelect(int i){
    	this.currentSelect = i;
    }
    
    public int getCurrentSelect(){
    	return currentSelect;
    }
    
    public void setCurrentPickable(int i){
    	this.currentPickable = i;
    }
    
    public int getCurrentPickable(){
    	return currentPickable;
    }
    
    public InnerRoom getInnerRoom(){
    	return innerRoom;
    }
    
    public void mouseClicked(MouseEvent event){
    	myRadio.getButtonG().clearSelection();
		if(!pause){
			for (int i = 0; i < 7; i++) {
				//mouse click on room[i]?
				if ((board.getRoom(i).getRoomX() < event.getPoint().x) 
						&& ((board.getRoom(i).getRoomX()+100) > event.getPoint().x)
						&& (board.getRoom(i).getRoomY() < event.getPoint().y)
						&& ((board.getRoom(i).getRoomY()+100) > event.getPoint().y)) 
				{
					this.setCurrentSelect(i);
					board.setRecX(board.getRoom(i).getRoomX());
			    	board.setRecY(board.getRoom(i).getRoomY());
			    	board.getRoom(i).setSelected(true);
			    	if(board.getRoom(i).getLock()){
			    		this.sendMessage("Room "+i+" is selected, this room is unlocked.");
			    		innerRoom.setRoomImage(board.getRoom(i).getImage());
			    		if(board.getRoom(i).getItem().visible){
			    		innerRoom.setItemImage(board.getRoom(i).getItem().getItemImage());
			    		}
			    		else innerRoom.setItemImage("");
			    	}
			    	else{
			    		this.sendMessage("Room "+i+" is selected, this room is locked."+" To move to this room you need a key.");
			    		innerRoom.setRoomImage("locked.jpg");
			    		innerRoom.setItemImage("");
			    	}
				}
				else{ 
					board.getRoom(i).setSelected(false);	
				}
				
				
				//mouse click on the item in room[i]?
				if(board.getRoom(i).getPickable() && board.getRoom(i).getSelected() && ((board.getRoom(i).getRoomX()) < event.getPoint().x) 
						&& ((board.getRoom(i).getRoomX()+70) > event.getPoint().x)
						&& ((board.getRoom(i).getRoomY()) < event.getPoint().y)
						&& ((board.getRoom(i).getRoomY()+40) > event.getPoint().y))
					{
					select.playEffect("selected.wav");		
					board.getRoom(i).setCollected(true);
					board.getRoom(i).getItem().getClicked(this);
					}
		    	else {
		    		board.getRoom(i).setCollected(false);
		    	}
			}
			
			if((board.getPlayerX()+40) < event.getPoint().x && (board.getPlayerX()+60) > event.getPoint().x
					&& (board.getPlayerY()+40) < event.getPoint().y && (board.getPlayerY()+60) > event.getPoint().y 
					&& playerArrived == 1 || 70 < event.getPoint().x && 90 > event.getPoint().x
					&& 480 < event.getPoint().y && 500 > event.getPoint().y && playerArrived == 2){
				this.setSpeed = true;
				if(speed == 1){
					this.sendMessage("Player Speed: fast."+"\nPlayer HP:"+ HP);
				}
				else if(speed == 5){
					this.sendMessage("Player Speed: normal."+"\nPlayer HP:"+ HP);
				}
				else if(speed == 10){
					this.sendMessage("Player Speed: slow."+"\nPlayer HP:"+ HP);
				}
			}
			else{
				this.setSpeed = false;
			}
			
			this.repaint();
		}
      }
      public void mousePressed(MouseEvent e){
      }
      public void mouseReleased(MouseEvent e){
      }
      public void mouseEntered(MouseEvent e){
      }
      public void mouseExited(MouseEvent e){
      }

}
