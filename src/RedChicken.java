import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public class RedChicken extends Chicken{

	public RedChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_red.jpg", col, raw);
	color=chickenColor.red;
	}
	

	
	public void visit(RedShot red) {
		delete(); 
		
	}

	
	
	public void visit(BlueShot yellow) {
		int killC=2;
	
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]!=null)
				if(chickensMat[i][j].color==chickenColor.purple)
				{
					chickensMat[i][j].delete();
					killC--;
				}
			}
		}
		
		
	}
	

	
	public void visit(YellowShot yellow) {
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


}
