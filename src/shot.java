import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.management.RuntimeErrorException;
import javax.swing.Icon;


public class shot extends MovingCIObject{

public enum color{red,blue,yellow,black};
static boolean wasCreated=false;

public shot() {
	super(null);
	if(wasCreated)
		throw new RuntimeException("Cant create two shots");
	wasCreated=true;
	setVisible(false);
	addKeyListener(new KeyListener() {
		
		@Override
		public void keyTyped(KeyEvent e) {
			//TODO change color, visibility, and setLocaion
		}
		
		@Override
		public void keyReleased(KeyEvent e) {}
		
		@Override
		public void keyPressed(KeyEvent e) {}
	});
}

@Override
protected void bomb(MovingCIObject bomber) {
	// TODO Auto-generated method stub
	setVisible(false);
}
	@Override
		public void actionPerformed(ActionEvent e) {
			super.actionPerformed(e);
			if(isVisible())
				setLocation(getX(), getY()-1);
		}

}
