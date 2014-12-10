
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
public class StatePanel extends JPanel{
  
	private JLabel sword;
	private JLabel gold;
	private JLabel key;
	private JLabel HP;
	private JLabel monster;
	private Game game;

	public StatePanel(Game game){
		this.game = game;
		this.setPreferredSize(new Dimension(120, 60));
		this.setBorder(BorderFactory.createTitledBorder("KILL MONSTER"));
		this.setBackground(Color.white);
		this.setLayout (new GridLayout(1,9));
		this.sword = new JLabel("Sword: " + game.getSword());
		this.monster = new JLabel("Monster HP: " + game.getMonster());
		this.gold = new JLabel("Gold: " + game.getGold());
		this.key = new JLabel("Key: " + game.getKey());
		this.HP = new JLabel("HP: " + game.getHP());
		this.add(HP);
		this.add(gold);
		this.add(sword);
		this.add(key);
		this.add(monster);
	}
	
	public void paintComponent(Graphics g) {
		gold.setText("Gold: "+ game.getGold());
		HP.setText("HP: "+game.getHP());
		monster.setText("Monster HP:" + game.getMonster());
		sword.setText("Sword: "+ game.getSword());
		key.setText("Key: " + game.getKey());
		super.paintComponent(g);
	}
}
