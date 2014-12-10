
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JOptionPane;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Sword extends Item{

	private boolean sVisible;
	public Sword(boolean sVisible, boolean visible){
		this.sVisible = sVisible;
		super.visible = visible;
		super.image = "sword.png";
	}
	
	public void paintItem(Graphics item, int locationX, int locationY){
		if(sVisible){
			item.setColor(Color.pink);
			item.drawString("Sword", locationX, locationY);
		}
	}
	
	public void getClicked(Game game){
		game.sendMessage("You find a sword! You need 3330 gold coins to buy it!");
	}
	
	public void gotItem(Game game){
		if (game.getGold() < 3320){
			JOptionPane.showMessageDialog(null,"To collect a sword we need to collect all golds first!","Message",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			game.setSword(true);
			sVisible = false;
			Music sword = new Music("keynsword.wav");
			sword.playEffect("keynsword.wav");
			visible = false;
		}
		}
	}

