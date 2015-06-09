import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class YellowChicken extends Chicken{
	
	public YellowChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_yellow.PNG", col, raw);
	}
	

	@Override
	public void accept(Visitor m) {
		// TODO Auto-generated method stub
		
	}



}
