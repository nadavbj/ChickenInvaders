import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;


public class Spaceship extends Active {

	
	private static final String IMAGE_PATH = "/Chicken_Invaders_resources/spaceship.PNG";

	public Spaceship() {
		super(IMAGE_PATH);
		type="Spaceship";
		board.getContentPane().addMouseMotionListener(new MouseMotionListener() {
// fix
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
	public void visit(RedShot red) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BlueShot blue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(YellowShot yellow) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BlackShot black) {
		// TODO Auto-generated method stub
		
	}

	



}
