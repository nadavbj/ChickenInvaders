import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class X_Chicken extends Chicken{

	public X_Chicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/chicken_x.PNG", col, raw);
	color=chickenColor.x;
	}
	

	

	
	public void visit(BlackShot black) {
		int rowT=this.raw;
		int colT=this.col;
		
		while (this.raw>=0 &&this.col<chickensMat[this.raw].length)   // kill in X style
		{
			chickensMat[this.raw][this.col].delete();
			this.raw--;
			this.col++;
		}
		
		this.raw=rowT+1;
		this.col=colT+1;
		
		while(this.raw<chickensMat.length && this.col<chickensMat[this.raw].length)   // kill in X style
		{
			chickensMat[this.raw][this.col]=null;  	
			this.raw++;
			this.col++;
		}
		
		this.raw=rowT+1;
		this.col=colT-1;
		
		while (this.raw<chickensMat.length && this.col>=0)  
		{
			chickensMat[this.raw][this.col]=null;  	
			this.raw++;
			this.col--;
		}
		
		this.raw=rowT-1;
		this.col=colT-1;
		
		while(this.col>=0 && this.raw>=0)     
		{
			chickensMat[this.raw][this.col]=null;  	
			this.raw--;
			this.col--;
		}
		
		
	}



}
