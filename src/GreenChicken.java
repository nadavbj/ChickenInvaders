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


public class GreenChicken extends Chicken{
	private Clip clip;
	public GreenChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	color=chickenColor.green;
	}


	

	
	public void visit(BlueShot blue) {
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
		
	}

	
	public void visit(YellowShot yellow) {
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
		
	}

	

}

