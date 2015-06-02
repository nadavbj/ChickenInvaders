import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Spaceship extends MovingCIObject {

	
	private static final String IMAGE_PATH = "/Chicken_Invaders_resources/spaceship.PNG";

	public Spaceship() {
		super(IMAGE_PATH);
		System.out.println(new ImageIcon(IMAGE_PATH).getIconHeight());
	}

	@Override
	protected void bomb(MovingCIObject bomber) {
		// TODO Auto-generated method stub

	}

}
