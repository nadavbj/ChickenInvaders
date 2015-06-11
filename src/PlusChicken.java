import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlusChicken extends Chicken{
	Chicken[][]chickensMat;
	Chicken c;
	public PlusChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/chicken_plus.PNG", col, raw);
	}
	

	@Override
	public void visit(RedShot red) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BlueShot blue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(YellowShot yellow) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BlackShot black) {
		chickensMat = Chicken.getChickensMat();
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
