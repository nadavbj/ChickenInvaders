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


public class X_Chicken extends Chicken{
	private Clip clip;
	public X_Chicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/x_chicken.PNG", col, raw);
	color=chickenColor.x;
	}
	

	

	
	public void visit(BlackShot black) {
		int rowT=this.raw;
		int colT=this.col;
		//delete();
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
				
			
				int i = this.col-1;
				int j = this.raw-1;
				while(i >= 0 && j >= 0){
					if(Chicken.chickensMat[i][j] != null)
						Chicken.chickensMat[i][j].delete();
					i--;
					j--;
				}
				i = this.col-1;
				j =this.raw+1;
				while(i >= 0 && j < Chicken.chickensMat[0].length){
					if(Chicken.chickensMat[i][j] != null)
						Chicken.chickensMat[i][j].delete();
					i--;
					j++;
				}
				i =  this.col+1;
				j =this.raw-1;
				while(i < Chicken.chickensMat.length && j >= 0){
					if(Chicken.chickensMat[i][j] != null)
						Chicken.chickensMat[i][j].delete();
					i++;
					j--;

				}
				i = this.col+1;
				j = this.raw+1;
				while(i < Chicken.chickensMat.length && j < Chicken.chickensMat[0].length){
					if(Chicken.chickensMat[i][j] != null)
						Chicken.chickensMat[i][j].delete();
					i++;
					j++;
				}
				this.delete();
	}
}




