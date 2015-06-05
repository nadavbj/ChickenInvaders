import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Spaceship extends MovingCIObject {

	
	private static final String IMAGE_PATH = "/Chicken_Invaders_resources/spaceship.PNG";

	public Spaceship() {
		super(IMAGE_PATH);
		type="Spaceship";
		board.getContentPane().addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				setLocation(e.getPoint());
				setSize(67, 69);
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});;
	}

	@Override
	protected boolean bomb(MovingCIObject bomber) {
		if("Chicken".equals(bomber.type))
			;//Explode
		return false;

	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	super.actionPerformed(e);
	
}
}
