import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CircleChicken extends Chicken{
	Chicken[][]chickensMat;
	Chicken c;
	public CircleChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/chicken_circle.PNG", col, raw);
	
	}
	



	@Override
	public void visit(BlueShot blue) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete();     //killing herself
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
		}
		
		
	}

	
}
