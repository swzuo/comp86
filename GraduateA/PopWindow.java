
import java.awt.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Shiwan Zuo
 * Comp 86
 * GraduateAssignment
 * shiwan.zuo@tufts.edu
 *
 */

@SuppressWarnings("serial")
public class PopWindow extends JFrame implements ActionListener{
	
	private Game game;
	private ControlPanel controls;

	
	public PopWindow(final Game game, final ControlPanel controls){
		this.game = game;
		this.controls = controls;
	}
	
	public void setPopWindow(final Game game, final ControlPanel controls){
		this.game = game;
		this.controls = controls;
	}
	
	public void mWindow(String message1, String message2){
		
		setLocation (500, 500);
		setSize (300, 100);
		Container content = getContentPane();
		content.setLayout (new FlowLayout());
		setDefaultCloseOperation (EXIT_ON_CLOSE);

		JLabel label = new JLabel (message1);
		content.add (label);
		
		JLabel label2 = new JLabel (message2);
		content.add (label2);

		JButton Exit = new JButton ("Exit");
		ActionListener ex= new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	System.exit(0);
	        	dispose();
	        }
	    };
	    Exit.addActionListener(ex);
	    content.add (Exit);
	    
		JButton Restart = new JButton ("Restart");
		ActionListener re= new ActionListener(){
	        public void actionPerformed(ActionEvent e){
				reset();
				dispose();
	        }
	    };
	    Restart.addActionListener(re);
	    content.add (Restart);

		// Finally, put our window on the screen
		setVisible (true);
	}
	
	public void reset(){
		game.getBoard().addObjects();
		game.getBoard().initialize();
		controls.initialize();
		game.initialize();
		game.getInnerRoom().initialize();
	}
	
	public void gWindow(String message1, String message2){
		setLocation (500, 500);
		setSize (300, 60);
		Container content = getContentPane();
		content.setLayout (new FlowLayout());
		setDefaultCloseOperation (EXIT_ON_CLOSE);

		JLabel label = new JLabel (message1);
		content.add (label);
		
		JLabel label2 = new JLabel (message2);
		content.add (label2);

		JButton iSee = new JButton ("I see");
		ActionListener ic= new ActionListener(){
	        public void actionPerformed(ActionEvent e){
	        	dispose();
	        }
	    };
	    iSee.addActionListener(ic);
	    content.add (iSee);

		// Finally, put our window on the screen
		setVisible (true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
