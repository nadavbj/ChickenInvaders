import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


public class FluChicken extends Chicken{
	private Clip clip;
	public FluChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/Bonus/flu_chicken.PNG", col, raw);
	color=chickenColor.flu;
	}


	public void visit(BlackShot blue) {
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
				
				int colT = this.col+1;
				int colT2 = this.col+2;
				int colT3 = this.col+3;
				int colT4 = this.col+4;
				
				int rawT = this.raw+1;
				int rawT2 = this.raw+2;
				int rawT3 = this.raw+3;
				
				
				for(int i=0; i<4;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[i][this.raw]!=null) chickensMat[i][this.raw].delete();
				}
				for(int i=0; i<8;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[this.col][i]!=null) chickensMat[this.col][i].delete();
				}
				for(int i=0; i<4;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[i][colT]!=null) chickensMat[i][colT].delete();
				}
				for(int i=0; i<4;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[i][colT2]!=null) chickensMat[i][colT2].delete();
				}
				for(int i=0; i<4;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[i][colT3]!=null) chickensMat[i][colT3].delete();
				}
				for(int i=0; i<4;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[i][colT4]!=null) chickensMat[i][colT4].delete();
				}
				
				
				
				for(int i=0; i<8;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[rawT][i]!=null) chickensMat[rawT][i].delete();
				}
				for(int i=0; i<8;i++)		/// killing all the chickens in the same col
				{
					if(chickensMat[rawT2][i]!=null) chickensMat[rawT2][i].delete();
				}
				chickensMat[0][0].delete();
				chickensMat[0][6].delete();
				chickensMat[0][7].delete();
			
				
				
		
	}

	
	

}

