
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JOptionPane;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Monster extends Item{
	
	private boolean mVisible;
	private Game game;
	private ControlPanel controls;
	private Container content;
	
	public Monster(boolean mVisible, boolean visible){
		this.mVisible = mVisible;
		super.image = "monster.png";
		super.visible = visible;
	}
	
	public boolean setLife(Game game){
		if(game.getMonster() < 0)
			mVisible = false;
		return mVisible;
	}
	public void paintItem(Graphics item, int locationX, int locationY){
		if(mVisible){
			item.setColor(Color.pink);
			item.drawString("Monster", locationX, locationY);
		}
	}
	
	public void getClicked(Game game){
		game.sendMessage("You find the monster! Use your sword to kill it!");
	}
	
	public void gotItem(Game game){
		ControlPanel controls = new ControlPanel(content,game);
		if (game.getSword()){
			game.setMonster(game.getMonster()-100);
			if(game.getMonster() == 0){
				game.setMonster(0);
				mVisible = false;
				game.Sound(2);
				Music success =  new Music("success.wav");
				success.playEffect("success.wav");
				String message1 = "Monster is dead!";
				String message2 = "Mission Completed!";
				PopWindow monsterWindow = new PopWindow(game, controls);
				monsterWindow.mWindow(message1,message2);
				visible = false;
				game.getInnerRoom().setRoomImage("win.jpg");
				game.getInnerRoom().setItemImage("");
				
			}
		}
		else {
			game.setHP(game.getHP() - 50);
			if(game.getHP()==0){
				 game.Sound(2);
				 Music pdead =  new Music("playerdead.wav");
				 pdead.playEffect("playerdead.wav");
				 String message1 = "Player is dead!";
					String message2 = "Need Sword!";
					PopWindow monsterWindow = new PopWindow(game, controls);
					monsterWindow.mWindow(message1,message2);
		         //JOptionPane.showMessageDialog(null,"Player is dead, to kill the monster we need a sword.","Message",JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

}
