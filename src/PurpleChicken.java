import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PurpleChicken extends Chicken{
	Chicken[][]chickensMat;
	Chicken c;
	public PurpleChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_purple.jpg", col, raw);
	
	}
	
	public PurpleChicken() 
	{
		super("/Chicken_Invaders_resources/chicken/chicken_purple.jpg",-1,-1);
	}

	@Override
	public void visit(RedShot red) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}

	
	@Override
	public void visit(BlueShot yellow) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}
}
