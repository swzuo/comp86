
import java.awt.*;


/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Room{
	
	private boolean lock;
	private boolean selected;
	private boolean collect;
	private boolean pickable;
	//private int num;
	private int x, y;
	private Item item;
	private String image;

	public Room(int x, int y, boolean lock, Item item, String image){
		this.lock = lock;
		this.x = x;
		this.y = y;
		this.item = item;
		this.image = image;
	}
	
	public void initialize(){
		setSelected(false);
		setCollected(false);
		setPickable(false);		
	}
	
	public String getImage(){
		return this.image;
	}
	
	public int getRoomX(){
		return x;
	}
	
	public int getRoomY(){
		return y;
	}
	
	public boolean getLock(){
		return lock;
	}
	
	public void setLock(boolean lock){
		this.lock = lock;
	}
	
	public void setItem(Item item){
		this.item = item;
	}
	
	public Item getItem(){
		return item;
	}
	
	public void setSelected(boolean selected){
		this.selected = selected;
	}
	
	public boolean getSelected(){
		return selected;
	}
	
	public void setCollected(boolean collect){
		this.collect = collect;
	}
	
	public boolean getCollected(){
		return collect;
	}
	
	public void setPickable(boolean pickable){
		this.pickable = pickable;
	}
	
	public boolean getPickable(){
		return pickable;
	}
	
	
	public void paintRoom(Graphics g) {
		g.setColor(Color.orange);
		g.drawOval(x, y, 100, 100);
		if (item!=null){
			item.paintItem(g, x+30, y+30);
		}
		
	}
	
	  public void drawBorderAsSelected(Graphics g){
		    Color original = g.getColor();
		    g.setColor(Color.red);
		    g.drawRect(this.x, this.y, 40, 40);
		    g.setColor(original);
		  }
	
	
}
