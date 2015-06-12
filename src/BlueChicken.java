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

	Chicken c;
	public BlueChicken(int col, int raw) {
	super("/Chicken_Invaders_resources/chicken/chicken_blue.jpg", col, raw);
	color=chickenColor.blue;
	}

	

	public void visit(RedShot red) {
		int killC=2;

		
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]!=null)
				if(chickensMat[i][j].color==chickenColor.purple)
				{
					delete();
					killC--;
				}
			}
		}
		
	}


	public void visit(BlueShot blue) {
		
		delete(); 	
		
	}


	public void visit(YellowShot yellow) {
		
		int killC=2;
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]!=null)
				if(chickensMat[i][j].color==chickenColor.green)
				{
					delete();
					killC--;
				}
			}
		}
		
	}



	


	

}

