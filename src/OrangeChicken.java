import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class OrangeChicken extends Chicken{
	GameManager gm;
	public OrangeChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_orange.jpg", col, raw);
	gm = new GameManager();
	}
	
	public OrangeChicken() {
		super("/Chicken_Invaders_resources/chicken/chicken_orange.jpg",-1,-1);
	}
	@Override
	public void visit(RedShot red) {
		gm.ToKill(this.raw,this.col);
		
	}

	
	@Override
	public void visit(YellowShot yellow) {
		gm.ToKill(this.raw,this.col);
		
	}



}
