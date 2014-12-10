import java.awt.*;


/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Gold extends Item {
	
	private int denom;
	private String message1 = "   You got a gold!";
	private String message2 = ":D";
	private Game game;
	private ControlPanel controls;
	private Container content;
	
	public Gold(int denom, boolean visible){
		this.denom = denom;
		this.visible = visible;
		super.image = "gold.png";
		//this.goldWindow = new PopWindow(a);
	}
	
	public void paintItem(Graphics item, int locationX, int locationY){
		if(visible){item.setColor(Color.yellow);
        int[] x= {locationX,locationX-5,locationX+5};
        int[] y= {locationY,locationY-5,locationY-10};
        for (int i=0;i<3;i++){
        	for(int j=0;j<3;j++){
        		item.fillOval(x[i], y[j], 5, 5);
        		}
        	}
		}
	}
	
	public void gotItem(Game game){
		ControlPanel controls = new ControlPanel(content,game);
		if(!visible) 
			this.denom = 0;
		game.setGold(game.getGold()+denom);
		PopWindow goldWindow = new PopWindow(game,controls);
		goldWindow.gWindow(message1,message2);
		Music gold = new Music("gold.wav");
		gold.playEffect("gold.wav");
		this.visible = false;
	}
	
	public void getClicked(Game game){
		game.sendMessage("You find "+denom+" gold coins! Pick it up!");
	}

}
