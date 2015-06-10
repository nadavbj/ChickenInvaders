import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PurpleChicken extends Chicken{
	GameManager gm;
	public PurpleChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_purple.jpg", col, raw);
	gm = new GameManager();
	}
	
	public PurpleChicken() 
	{
		super("/Chicken_Invaders_resources/chicken/chicken_purple.jpg",-1,-1);
	}

	@Override
	public void visit(RedShot red) {
		gm.ToKill(this.raw,this.col);
		
	}

	
	@Override
	public void visit(BlueShot yellow) {
		gm.ToKill(this.raw,this.col);
		
	}
}
