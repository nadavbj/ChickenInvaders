import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class OrangeChicken extends Chicken{

	public OrangeChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_orange.jpg", col, raw);
	color=chickenColor.orange;
	}
	
	
	public void visit(RedShot red) {
		delete(); 
		
	}

	
	
	public void visit(YellowShot yellow) {
		delete(); 
		
	}



}
