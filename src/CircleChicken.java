import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CircleChicken extends Chicken{
	GameManager gm;
	public CircleChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/special/chicken_circle.PNG", col, raw);
	gm = new GameManager();
	}
	



	@Override
	public void visit(BlueShot blue) {
		gm.circleChickKill(this.raw,this.col);
		
	}

	
}
