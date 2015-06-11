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
	Chicken[][]chickensMat;
	Chicken c;
	public GreenChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	}

	public GreenChicken() {
		super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg",-1,-1);
	}
	
	

	@Override
	public void visit(BlueShot blue) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}

	@Override
	public void visit(YellowShot yellow) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}

	

}

