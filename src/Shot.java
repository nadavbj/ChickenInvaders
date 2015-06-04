import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.management.RuntimeErrorException;
import javax.swing.Icon;


public class Shot extends MovingCIObject{

	public enum shotColor{red,blue,yellow,black};
	private shotColor c;
	public Shot(shotColor c) {
		super("/Chicken_Invaders_resources/"+c+".png");
		this.c=c;
	}
	

	@Override
	protected void bomb(MovingCIObject bomber) {
		// TODO Auto-generated method stub
		//setVisible(false);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		setLocation(getX(),getY()-4);
		if(getY()<=0)
			delete();
	}

	public shotColor getColor() {
		return c;
	}

	public void setColor(shotColor c) {
		this.c = c;
	}

}
