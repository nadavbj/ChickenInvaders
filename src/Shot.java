 import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.Set;

import javax.management.RuntimeErrorException;
import javax.swing.Icon;


public abstract class Shot extends MovingCIObject implements Visitable{

	
	public Shot(String iconPath) {
		super(iconPath);
		type="Shot";
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		setLocation(getX(),getY()-8);
		if(getY()<=0)
			delete();
		Set<Chicken>objectsToBomb=new HashSet<Chicken>();
		for (Chicken[] row : Chicken.chickensMat) {
			for (Chicken chicken : row) {
				if(chicken!=null)
				if(getBounds().intersects(chicken.getBounds()) )
				{
					objectsToBomb.add(chicken);
				}
			}
			
		}
		for (Chicken movingCIObjectToBomb : objectsToBomb){
			shooting(movingCIObjectToBomb);
		}
	}
	
	
	


	
}
