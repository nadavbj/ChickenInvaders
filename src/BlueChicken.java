import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BlueChicken extends Chicken{
	private GameManager gm;
	public BlueChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	gm = new GameManager();
	}

	
	@Override
	public void visit(RedShot red) {
		gm.kill2Chickens(new PurpleChicken());
		
	}

	@Override
	public void visit(BlueShot blue) {
		gm.ToKill(this.raw,this.col);
		
	}

	@Override
	public void visit(YellowShot yellow) {
		gm.kill2Chickens(new GreenChicken());
		
	}

	@Override
	public void visit(BlackShot black) {
		// TODO Auto-generated method stub
		
	}
	

}
