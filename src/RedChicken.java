import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RedChicken extends Chicken{
	GameManager gm;
	public RedChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_red.jpg", col, raw);
	gm = new GameManager();
	}
	

	@Override
	public void visit(RedShot red) {
		gm.ToKill(this.raw,this.col);
		
	}

	
	@Override
	public void visit(BlueShot yellow) {
		gm.kill2Chickens(new PurpleChicken());
		
	}
	

	@Override
	public void visit(YellowShot yellow) {
		gm.kill2Chickens(new OrangeChicken());
		
	}


}
