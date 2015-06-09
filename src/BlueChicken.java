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
	
	public BlueChicken(int col, int raw) {
	super("/Users/yarden/git/ChickenInvaders/src/Chicken_Invaders_resources/chicken_green", col, raw);
	}
	

	@Override
	public void accept(Visitor m) {
		// TODO Auto-generated method stub
		
	}



}

