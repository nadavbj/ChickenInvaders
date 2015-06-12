import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class PlusChicken extends Chicken{

	public PlusChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/chicken_plus.PNG", col, raw);
	color=chickenColor.plus;
	}
	

	

	
	public void visit(BlackShot black) {

		for(int i=0; i<chickensMat[this.raw].length; i++)   /// killing all the chickens in the same row
		{
			chickensMat[this.raw][i].delete();
		}
		
		for(int i=0; i<chickensMat.length;i++)		/// killing all the chickens in the same col
		{
			chickensMat[i][this.col].delete();
		}
		
	}


}
