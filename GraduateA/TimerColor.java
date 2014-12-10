import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

/**
 * @author Shiwan Zuo
 * Comp 86
 * GraduateAssignment
 * shiwan.zuo@tufts.edu
 *
 */

public class TimerColor implements ActionListener {
	private Container contain;
	private Color bgColor;
	int r = 250;
	int g = 180;
	int b = 180;
	boolean night = false;
	TimerColor (Container contain){
		this.contain = contain;
	}
	
    public void actionPerformed (ActionEvent e) {
    	if(r > 5 && g > 5 && b > 5 && night == false){
    		r-=5;
        	g-=5;
        	b-=5;
    	}
    	else{
			night = true;
    		r+=10;
    		g+=10;
    		b+=10;
    		if (r > 250 && g > 175 && b > 175){
    			night = false;
    			r = 255;
    			g = 180;
    			b = 180;
    		}

    	}
    	bgColor = new Color(r,g,b);
    	contain.setBackground(bgColor);
}

}
