import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrangeChicken extends Chicken{
	Chicken[][]chickensMat;
	Chicken c;
	public OrangeChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_orange.jpg", col, raw);
	
	}
	
	public OrangeChicken() {
		super("/Chicken_Invaders_resources/chicken/chicken_orange.jpg",-1,-1);
	}
	@Override
	public void visit(RedShot red) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}

	
	@Override
	public void visit(YellowShot yellow) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}



}
