import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class CircleChicken extends Chicken{
	private Clip clip;
	public CircleChicken(int col, int raw) {
		super("/Chicken_Invaders_resources/chicken/special/circle_chicken.PNG", col, raw);
		color=chickenColor.circle;
	}




	public void visit(BlackShot black) {
		
		//play clip
				try {
					URL url = Menu.class.getResource("/Chicken_Invaders_resources/sound/explosion.wav");
					AudioInputStream audioIn = null;
					try {
						audioIn = AudioSystem.getAudioInputStream(url);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					clip = AudioSystem.getClip();
					try {
						clip.open(audioIn);
						clip.loop(0);
					} 
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				catch (UnsupportedAudioFileException murle) {
					System.out.println(murle);
				} catch (LineUnavailableException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(int t = col-1 ; t<=col+1;t++){
					
					// kill the middelROW
					if(chickensMat[this.raw][t]!=null)  chickensMat[this.raw][t].delete();
					

					// kill the upperRow
					if(chickensMat[this.raw-1][t]!=null) chickensMat[this.raw-1][t].delete();
					
					
					// kill the DownRow
					if(chickensMat[raw+1][t]!=null)chickensMat[raw+1][t].delete();
				}
				/*
		if(this.raw>0)    //check if the chicken isn't in the corner
		{
			chickensMat[this.raw-1][this.col].delete();  //killing the chicken in the same this.column 
		}
		if(this.raw<chickensMat.length)
		{
			chickensMat[this.raw+1][this.col].delete();   // //killing the chicken in the same column 
		}
		if(this.col<chickensMat[this.raw].length)
		{
			chickensMat[this.raw][this.col+1].delete();       ////killing the chicken in the same this.raw
		}
		if(this.col>0)
		{
			chickensMat[this.raw][this.col-1].delete();    ///killing the chicken in the same this.raw 
		}
		if(this.raw>0 &&this.col<chickensMat[this.raw].length)
		{
			chickensMat[this.raw-1][this.col+1].delete();      //killing the chicken in cross
		}
		if(this.col>0 && this.raw<chickensMat.length)
		{
			chickensMat[this.raw+1][this.col-1].delete();		//killing the chicken in cross
		}
		if(this.raw>0 && this.col >0)
		{
			chickensMat[this.raw-1][this.col-1].delete();			//killing the chicken in cross
		}
		if(this.raw<chickensMat.length && this.col<chickensMat[this.raw].length)
		{
			chickensMat[this.raw+1][this.col+1].delete();		//killing the chicken in cross
		}*/

		
	}


}
