import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.Icon;


public class Egg extends MovingCIObject {

	private static final String IMAGE_PATH = "/Chicken_Invaders_resources/egg.PNG";

	public Egg(Point start) {
		super(IMAGE_PATH);
		setLocation(start);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Egg.this.setLocation(getX(), getY()+1);
	}
	@Override
	protected void bomb(MovingCIObject bomber) {
		super.bomb(bomber);
		if(bomber instanceof Spaceship)
		{
			setIcon(getIcon("/Chicken_Invaders_resources/eggExplosion"));
		}
	}

}
