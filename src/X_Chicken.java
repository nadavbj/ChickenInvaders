import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class X_Chicken extends Chicken{
	GameManager gm;
	public X_Chicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_x.PNG", col, raw);
	gm = new GameManager();
	}
	

	

	@Override
	public void visit(BlackShot black) {
		gm.xChickKill(this.raw, this.col);
		
	}



}
