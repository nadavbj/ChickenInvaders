import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.Icon;

import com.sun.org.apache.bcel.internal.generic.RET;


public class Egg extends MovingCIObject {

	private static final String IMAGE_PATH = "/Chicken_Invaders_resources/egg.png";

	public Egg(Point start) {
		super(IMAGE_PATH);
		setLocation(start);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Egg.this.setLocation(getX(), getY()+2);
	}
	boolean exploed=false;
	@Override
	protected boolean bomb(MovingCIObject bomber) {
		if(exploed)
			return true;
		if(bomber instanceof Spaceship)
		{
			try{
			setIcon(getIcon("/Chicken_Invaders_resources/eggExplosion.png"));
			}
			catch(Exception e)
			{
				
			}
			exploed=true;
		}
		return false;
	}

}
