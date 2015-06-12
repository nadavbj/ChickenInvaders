import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class YellowChicken extends Chicken{
	public YellowChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_yellow.jpg", col, raw);
	color=chickenColor.yellow;
	}
	

	
	public void visit(RedShot red) {
		int killC=2;
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]!=null)
				if(chickensMat[i][j].color==chickenColor.orange)
				{
					chickensMat[i][j].delete();
					killC--;
				}
			}
		}
		
	}

	
	public void visit(BlueShot blue) {
		int killC=2;
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]!=null)
				if(chickensMat[i][j].color==chickenColor.green)
				{
					chickensMat[i][j].delete();
					killC--;
				}
			}
		}
		
	}

	
	public void visit(YellowShot yellow) {
		delete(); 
	}

}
