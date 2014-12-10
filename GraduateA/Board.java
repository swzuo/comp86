
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
public class Board extends JComponent{

	private Room[] room = new Room[7];
	private int a = 30;
	private int b = 440;
	private int x = 30;
	private int y= 440;
	private boolean playerMove = false;	
	
	public Board(){	
	}
	
	public void initialize(){
		this.addObjects();
		this.a = 30;
		this.b = 440;
		this.x = 30;
		this.y= 440;
		this.playerMove = false;
		for (int i = 0; i<7; i++){
			room[i].initialize();
		}
	}
	
	public void addObjects(){
		Gold gold1 = new Gold(30,true);
		Gold gold2 = new Gold(300,true);
		Gold gold3 = new Gold(3000,true);
		Gold gold4 = new Gold(3000,false);
		Key key = new Key(true);
		key = new Key(true);
		Monster monster = new Monster(true,true);
		Sword sword = new Sword(true,true);
		
		room[0] = new Room(30,20,true, monster,"room0.jpg");
		room[1] = new Room(180,90,true, key,"room1.jpg");	
		room[2] = new Room(30,160,true, sword,"room2.jpg");
		room[3] = new Room(180,230,false, gold1,"room3.jpg");		
		room[4] = new Room(30,300,true, gold2,"room4.jpg");
		room[5] = new Room(180,370,true, gold3,"room5.jpg");	
		room[6] = new Room(30,440,true, gold4,"room7.jpg");
	}
	
	public Room getRoom(int i){
		return room[i];
	}
	
	public void setRecX(int a){
		this.a = a;
	}
	
	public void setRecY(int b){
		this.b = b;
	}
	
	public int getRecX(){
		return a;
	}
	
	public int getRecY(){
		return b;
	}
	
	public void setPlayer(boolean playerMove){
		this.playerMove = playerMove;
	}
	
	public boolean getPlayer(){
		return playerMove;
	}
	
	public void setPlayerX(int i){
		this.x = x+i;
	}
	
	public void setPlayerY(int j){
		this.y = y+j;
	}
	
	public int getPlayerX(){
		return x;
	}
	
	public int getPlayerY(){
		return y;
	}
    
    public void paintComponent(Graphics r){
    	super.paintComponent(r);
        for(int i=0;i<7;i++){
        	room[i].paintRoom(r);
        	if(!room[i].getLock()){
        		r.drawString("Locked", room[i].getRoomX()+30, room[i].getRoomY()+60);
        	}
        }
        r.drawRect(a, b, 100, 100);
        r.drawLine(120, 100, 180, 130);
        r.drawLine(120, 240, 180, 270);
        r.drawLine(120, 380, 180, 410);
        r.drawLine(127, 190, 200, 180);
        r.drawLine(127, 330, 200, 320);
        r.drawLine(127, 470, 200, 460);
        r.setColor(Color.red);
        r.fillOval(x+40, y+40, 20, 20);
        r.setColor(Color.black);
        r.drawString("P", x+47, y+55);
    }
}
