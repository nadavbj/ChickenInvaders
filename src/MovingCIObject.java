
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;
import java.util.WeakHashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;


public abstract class MovingCIObject extends JLabel implements ActionListener {

	protected static Collection<MovingCIObject> aliveMovingObjects=null;
	public static GameFrame board;
	protected static WeakHashMap<String, Icon> picsCache;
	public static Timer timer;
	protected String type;

	public MovingCIObject(String iconPath) {
		this(getIcon(iconPath).getIconWidth(),getIcon(iconPath).getIconHeight());
		setIcon(getIcon(iconPath));
	}
	public MovingCIObject(int width, int height) {
		setText(null);
		if(aliveMovingObjects==null)
		{
			aliveMovingObjects=new HashSet<MovingCIObject>();
			timer=new Timer(50, this);
			timer.start();
		}
		setSize(width,height);
		aliveMovingObjects.add(this);
		timer.addActionListener(this);
	}

	protected abstract boolean bomb(MovingCIObject bomber);


	@Override
	public void actionPerformed(ActionEvent e) {
		Set<MovingCIObject>objectsToDelete=new HashSet<MovingCIObject>();
		for (MovingCIObject movingCIObject : aliveMovingObjects) {
			if(getBounds().intersects(movingCIObject.getBounds()) && movingCIObject!=this)
			{
				if(bomb(movingCIObject))
					objectsToDelete.add(this);
				if(movingCIObject.bomb(this))
					objectsToDelete.add(movingCIObject);
			}
		}
		for (MovingCIObject movingCIObjectToDelete : objectsToDelete) {
			movingCIObjectToDelete.delete();
		}
	}


	public void delete() {
		board.getContentPane().remove(this);
		aliveMovingObjects.remove(this);
		timer.removeActionListener(this);
		board.repaint();
	}


	protected static Icon getIcon(String path){
		if(picsCache==null)
			picsCache=new WeakHashMap<String, Icon>();
		Icon icon=picsCache.get(path);
		if(icon==null)
		{
			icon=new ImageIcon(MovingCIObject.class.getResource(path));
			picsCache.put(path, icon);
		}
		return icon;
	}


}
