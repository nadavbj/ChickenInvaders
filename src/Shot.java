import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.management.RuntimeErrorException;
import javax.swing.Icon;


public class Shot extends Active implements Visitable{

	
	public Shot(String iconPath) {
		super(iconPath);
		type="Shot";
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		setLocation(getX(),getY()-4);
		if(getY()<=0)
			delete();
		else
			super.actionPerformed(e);
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

	@Override
	public void shooting(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	

	
}
