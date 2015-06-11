import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class RedChicken extends Chicken{
	Chicken[][]chickensMat;
	Chicken c;
	public RedChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_red.jpg", col, raw);
	
	}
	

	@Override
	public void visit(RedShot red) {
		chickensMat = Chicken.getChickensMat();
		chickensMat[this.raw][this.col].delete(); 
		
	}

	
	@Override
	public void visit(BlueShot yellow) {
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
	public void visit(YellowShot yellow) {
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


}
