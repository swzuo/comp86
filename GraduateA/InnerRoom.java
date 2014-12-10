import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import javax.swing.border.LineBorder;


/**
 * @author Shiwan Zuo
 * Comp 86
 * GraduateAssignment
 * shiwan.zuo@tufts.edu
 *
 */

public class InnerRoom extends JComponent{
	private Game game;
	private Image roomImage;
	private Image playerImage;
	private Image itemImage;
	private int y;
	private int scale;
	private boolean pause = false;
	
	public InnerRoom(Container contain, Game game, ControlPanel cp){
		this.setPreferredSize(new Dimension(350,100));
		this.setLayout (new GridLayout(10,1));
		this.setBorder (new LineBorder(Color.black,2));
		this.setBorder(BorderFactory.createTitledBorder("Room View Panel"));
		this.setBackground(Color.white);
		this.game = game;
		game.setInnerRoom(this);
		cp.setInnerRoom(this);
		this.playerImage = Toolkit.getDefaultToolkit().createImage("player.png");
	}
	
	public void initialize(){
		this.roomImage = Toolkit.getDefaultToolkit().createImage("room7.jpg");
		this.itemImage = Toolkit.getDefaultToolkit().createImage("");
		this.y = 350;
		this.scale = 1;
	}
	
	public void setP(int i){
		this.y += i;
	}
	
	public void setIniP(int y){
		this.y = y;
	}
	
	public void setScale(int w){
		this.scale = w;
	}
	
	public void setPause(boolean pause){
		this.pause = pause;
	}
	
	public void setRoomImage(String roomImage){
		this.roomImage = Toolkit.getDefaultToolkit().createImage(roomImage);		
	}
	
	public void setItemImage(String itemImage){
		this.itemImage = Toolkit.getDefaultToolkit().createImage(itemImage);
	}
	
    public void paintComponent(Graphics g){
    	if(!pause){
        	g.drawImage(roomImage,0,4,null);
        	g.drawImage(itemImage, 30, 30, itemImage.getWidth(null)*scale, itemImage.getHeight(null)*scale, null);
        	//g.drawImage(itemImage,100,30,300,400,null);
        	if(game.getCurrentPickable() == game.getCurrentSelect()){
        		g.drawImage(playerImage, 120, y, null);
        	}
    	}
    }

}
