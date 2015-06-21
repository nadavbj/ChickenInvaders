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


public class XorChicken extends Chicken{
	private Clip clip;
	public XorChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/Bonus/xor_chicken.PNG", col, raw);
	color=chickenColor.xor;
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
				
				delete();
				if(Chicken.chickensMat[this.raw][this.col+1] != null) chickensMat[this.raw][this.col+1].delete();
				if(Chicken.chickensMat[this.raw][this.col-1] != null) chickensMat[this.raw][this.col-1].delete();
				if(Chicken.chickensMat[this.raw+1][this.col] != null) chickensMat[this.raw+1][this.col].delete();
				if(Chicken.chickensMat[this.raw-1][this.col] != null) chickensMat[this.raw-1][this.col].delete();
				if(Chicken.chickensMat[this.raw+1][this.col+1] != null) chickensMat[this.raw+1][this.col+1].delete();
				if(Chicken.chickensMat[this.raw-1][this.col-1] != null) chickensMat[this.raw-1][this.col-1].delete();
				if(Chicken.chickensMat[this.raw-1][this.col+1] != null) chickensMat[this.raw-1][this.col+1].delete();
				if(Chicken.chickensMat[this.raw+1][this.col-1] != null) chickensMat[this.raw+1][this.col-1].delete();
				
	}

	

	

}

