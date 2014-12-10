import java.awt.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Key extends Item {
	
	public Key(boolean visible){
		this.visible = visible;
		super.image  = "key.png";
	}
	
	public void paintItem(Graphics item, int locationX, int locationY){
		if(visible == true){
			item.setColor(Color.pink);
			item.drawString("Key", locationX, locationY);
		}
	}
	
	public void gotItem(Game game){
		game.setKey(true);
		this.visible = false;
		Music key = new Music("keynsword.wav");
		key.playEffect("keynsword.wav");
	}
	
	public void getClicked(Game game){
		game.sendMessage("You find a key! Pick it up to unlock rooms!");
	}

}
