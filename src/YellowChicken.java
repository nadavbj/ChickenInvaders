import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class YellowChicken extends Chicken{
	Chicken[][]chickensMat;
	Chicken c;
	public YellowChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_yellow.jpg", col, raw);
	
	}
	

	@Override
	public void visit(RedShot red) {
		int killC=2;
		c = new OrangeChicken();
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
		int killC=2;
		c = new GreenChicken();
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
	public void visit(YellowShot yellow) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}




}
