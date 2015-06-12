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
	public GreenChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	color=chickenColor.green;
	}


	

	
	public void visit(BlueShot blue) {
		delete(); 
		
	}

	
	public void visit(YellowShot yellow) {
		delete(); 
		
	}

	

}

