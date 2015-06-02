
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class MovingCIObject extends JLabel implements ActionListener {
	public static Collection<MovingCIObject> aliveMovingObjects=null;
	public MovingCIObject(String iconPath) {
		setText(null);
		Icon icon=new ImageIcon(this.getClass().getResource(iconPath));
		setIcon(icon);
		try{
		setSize(icon.getIconWidth(),icon.getIconHeight());
		}
		catch(Exception e){
			setSize(10, 10);
		}
		if(aliveMovingObjects==null)
			aliveMovingObjects=new Vector<MovingCIObject>();
		aliveMovingObjects.add(this);
	}
	protected void bomb(MovingCIObject bomber){
		aliveMovingObjects.remove(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		for (MovingCIObject movingCIObject : aliveMovingObjects) {
			//TODO: check for collision
		}
	}
}
