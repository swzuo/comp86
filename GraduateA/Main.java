
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

@SuppressWarnings("serial")
public class Main extends JFrame{

	private Game game;
	private Container content;
	private PopWindow popWindow;
	private ControlPanel controls;
	private StatePanel sp;
	private InnerRoom innerRoom;
	private Timer timerColor;
	
	public static void main (String [] args) {
		new Main ();
    }
	

    public Main () {
    	// Window setup
		setTitle("Shiwan Zuo's Graduate Assignment");
		setLocation (200, 80);
		setSize (800, 730);
		setDefaultCloseOperation (EXIT_ON_CLOSE);
		this.content = getContentPane();
		content.setLayout (new BorderLayout());
		content.setBackground(Color.white);
		
		TimerColor timerC = new TimerColor(content);
		this.timerColor = new Timer(100,timerC);
		timerColor.setRepeats(true);
		timerColor.start();
		
		JMenuBar dpMenu = new JMenuBar();
		JMenu menu = new JMenu("Menu");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem reset = new JMenuItem("Reset");
		JMenuItem pause = new JMenuItem("Pause");
		JMenuItem start = new JMenuItem("Continue");
		setJMenuBar(dpMenu);
		dpMenu.add(menu);
		menu.add(reset);
		reset.addActionListener(re);
		exit.addActionListener(ex);
		pause.addActionListener(p);
		start.addActionListener(s);
		menu.add(exit);		
		menu.add(pause);
		menu.add(start);
		

		Board board = new Board();
		board.initialize();
		
		this.game = new Game(board);
		game.Sound(0);
		this.sp = new StatePanel(game);
		content.add(sp, BorderLayout.NORTH);
		content.add(game,BorderLayout.CENTER);
		
		this.controls = new ControlPanel(content, game);
		content.add (controls, BorderLayout.WEST);
		
		this.innerRoom = new InnerRoom(content,game,controls);
		innerRoom.initialize();
		content.add(innerRoom, BorderLayout.EAST);  
		
		Text text = new Text();
		content.add(text,BorderLayout.SOUTH);
		game.setText(text);
		game.sendMessage("================================Start!================================");
		
		this.popWindow = new PopWindow(game, controls);
		setVisible (true);
    }
	
    ActionListener ex = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
	}
    };
    
    ActionListener re = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			game.getBoard().addObjects();
			game.getBoard().initialize();
			controls.initialize();
			game.initialize();
			innerRoom.initialize();
	}
    };
    
    ActionListener p = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			controls.setPause(false);
			game.setPause(true);
			content.repaint();
			timerColor.stop();
			innerRoom.setPause(true);
	}
    };
    
    ActionListener s = new ActionListener(){
		public void actionPerformed(ActionEvent e) {
			controls.setPause(true);
			game.setPause(false);
			content.repaint();
			timerColor.start();
			innerRoom.setPause(false);
	}
    };
	
}
