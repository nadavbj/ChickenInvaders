import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GreenChicken extends Chicken{
	private GameManager gm;
	public GreenChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	gm = new GameManager();
	}

	public GreenChicken() {
		super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg",-1,-1);
	}
	
	

	@Override
	public void visit(BlueShot blue) {
		gm.ToKill(this.raw,this.col);
		
	}

	@Override
	public void visit(YellowShot yellow) {
		gm.ToKill(this.raw,this.col);
		
	}

	

}

