import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.management.RuntimeErrorException;
import javax.swing.Icon;


public class Shot extends Active {

	public enum shotColor{red,blue,yellow,black};
	private shotColor c;
	public Shot(shotColor c) {
		super("/Chicken_Invaders_resources/"+c+".png");
		this.c=c;
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

	public shotColor getColor() {
		return c;
	}

	public void setColor(shotColor c) {
		this.c = c;
	}

	@Override
	public void shooting(MovingCIObject bomber) {
		// bomber.accept(this);
		
	}
}
