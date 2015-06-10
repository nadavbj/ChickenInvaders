import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class YellowChicken extends Chicken{
	GameManager gm;
	public YellowChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_yellow.jpg", col, raw);
	gm = new GameManager();
	}
	

	@Override
	public void visit(RedShot red) {
		gm.kill2Chickens(new OrangeChicken());
		
	}

	@Override
	public void visit(BlueShot blue) {
		gm.kill2Chickens(new GreenChicken());
		
	}

	@Override
	public void visit(YellowShot yellow) {
		gm.ToKill(this.raw,this.col);
		
	}




}
