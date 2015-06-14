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


public class PlusChicken extends Chicken{
	private Clip clip;
	public PlusChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/chicken_plus.PNG", col, raw);
	color=chickenColor.plus;
	}
	

	

	
	public void visit(BlackShot black) {
		delete();
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
				for(int t = 0 ; t<8;t++){

					// kill the OrizenalROW
					chickensMat[this.raw][t].delete();
					

				}

				for(int t = 0 ; t<4;t++){

					chickensMat[t][this.col].delete();
					
				}
				/*
		for(int i=0; i<chickensMat[this.raw].length; i++)   /// killing all the chickens in the same row
		{
			chickensMat[this.raw][i].delete();
		}
		
		for(int i=0; i<chickensMat.length;i++)		/// killing all the chickens in the same col
		{
			chickensMat[i][this.col].delete();
		}*/
		
	}


}
