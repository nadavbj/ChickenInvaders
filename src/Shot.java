import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.management.RuntimeErrorException;
import javax.swing.Icon;


public class Shot extends Active {

	
	public Shot(String iconPath) {
		super(iconPath);
		type="Shot";
	}
	
	/*
	@Override
	protected boolean bomb(MovingCIObject bomber) {
		if("Chicken".equals(bomber.type)){
			return true;
		}
		return false;
	}
	*/

	@Override
	public void actionPerformed(ActionEvent e) {
		setLocation(getX(),getY()-4);
		if(getY()<=0)
			delete();
		else
			super.actionPerformed(e);
	}

	

	@Override
	public void shooting(MovingCIObject bomber) {
		 
	}
	public void shooting(PassiveCIObject bomber) {
		 bomber.accept(this);
	}
}
