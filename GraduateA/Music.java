import java.io.*;
import sun.audio.*;

/**
 * COMP 86
 * GraduateAssignment
 * @author Shiwan Zuo
 * Email: Shiwan.Zuo@tufts.edu
 * 
 */

public class Music {
	
    ContinuousAudioDataStream dataStream;
    
    public Music(String music){

         try{
            InputStream in = new FileInputStream(music);
            AudioStream as = new AudioStream(in);
            AudioData data = as.getData();
            dataStream = new ContinuousAudioDataStream(data);
         }catch(Exception e){}
         
    }
       
    public void playMusic(){ 
    	 
        try{     
            AudioPlayer.player.start(dataStream);
        }catch(Exception e){}
    }     
     
    public void stopMusic(){    
    	
        try{
            AudioPlayer.player.stop(dataStream);
        }catch(Exception e){}
    }
    
    public void playEffect(String music){   
   	 
        try{
            InputStream in = new FileInputStream(music);
            AudioStream as = new AudioStream(in);
            AudioPlayer.player.start(as);
         
        }catch(Exception e){}
    }
    
}
