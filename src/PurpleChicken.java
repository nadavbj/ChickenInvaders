import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class PurpleChicken extends Chicken{

	public PurpleChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_purple.jpg", col, raw);
	color=chickenColor.purple;
	}
	
	
	public void visit(RedShot red) {
		delete(); 
		
	}

	
	
	public void visit(BlueShot yellow) {
		delete(); 
		
	}
}
