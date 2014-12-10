
import java.awt.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public abstract class Item {
	
	protected boolean visible;
	protected String image;
	
	public Item(){
		//this.image = image;
	}
	
	public void setItemVisible(boolean visible){
		this.visible = visible;
	}
	
	public boolean getItemVisible(){
		return visible;
	}	
	
	public void setItemImage(String itemImage){
		this.image = itemImage;
	}
	
	public String getItemImage(){
		return image;
	}
	
	public abstract void paintItem(Graphics item, int locX, int locY);
	public abstract void gotItem(Game game);
	public abstract void getClicked(Game game);
		
}
