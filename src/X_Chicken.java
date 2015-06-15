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
	super("/Chicken_Invaders_resources/chicken/special/x_chicken.png", col, raw);
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
				
				//the current Xchicken
				
/*
				int u =this.raw; int t =this.col ; 
				while (u<3 && t<7)

				{
					if (chickensMat[u+1][t+1]!=null)
					{
					//down right diognal 
					chickensMat[u+1][t+1].delete();
					u++;
					t++;
					}
				}

				u= this.raw;
				t= this.col ; 

				while (u>0 && t<7)

				{
					//up right diognal
					if (chickensMat[u-1][t+1]!=null){
					chickensMat[u-1][t+1].delete();
					u--;
					t++;
					}
				}

				u= this.raw;
				t= this.col ; 

				while (u<3 && t>0)

				{
					//down left diognal
					if (chickensMat[u+1][t-1]!=null){
					chickensMat[u+1][t-1].delete();
					u++;
					t--;
					}
				}

				u= this.raw;
				t= this.col; 

				while (u>0 && t>0)

				{
					if (chickensMat[u-1][t-1]!=null){
					//up left diognal
					chickensMat[u-1][t-1].delete();
					u--;
					t--;
					}
				}
				
				*/
				
				
		while (this.raw>=0 &&this.col<chickensMat[this.raw].length && chickensMat[this.raw][this.col]!=null)   // kill in X style
		{
			chickensMat[this.raw][this.col].delete();
			this.raw--;
			this.col++;
		}
		
		this.raw=rowT+1;
		this.col=colT+1;
		
		while(this.raw<chickensMat.length && this.col<chickensMat[this.raw].length && chickensMat[this.raw][this.col]!=null)   // kill in X style
		{
			chickensMat[this.raw][this.col].delete();  	
			this.raw++;
			this.col++;
		}
		
		this.raw=rowT+1;
		this.col=colT-1;
		
		while (this.raw<chickensMat.length && this.col>=0&& chickensMat[this.raw][this.col]!=null)  
		{
			chickensMat[this.raw][this.col].delete();  	
			this.raw++;
			this.col--;
		}
		
		this.raw=rowT-1;
		this.col=colT-1;
		
		while(this.col>=0 && this.raw>=0&& chickensMat[this.raw][this.col]!=null)     
		{
			chickensMat[this.raw][this.col].delete(); 	
			this.raw--;
			this.col--;
		}
		
		
	}



}
