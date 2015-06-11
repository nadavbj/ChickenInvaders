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
	Chicken[][]chickensMat;
	Chicken c;
	public BlueChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	
	}

	
	@Override
	public void visit(RedShot red) {
		int killC=2;
		c = new PurpleChicken();
		chickensMat = Chicken.getChickensMat();
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]==c)
				{
					chickensMat[i][j].delete();
					killC--;
				}
			}
		}
		
	}

	@Override
	public void visit(BlueShot blue) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 	
		
	}

	@Override
	public void visit(YellowShot yellow) {
		c= new GreenChicken();
		chickensMat = Chicken.getChickensMat();
		int killC=2;
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]==c)
				{
					chickensMat[i][j].delete();
					killC--;
				}
			}
		}
		
	}

	@Override
	public void visit(BlackShot black) {
		return;
		
	}
	

}

