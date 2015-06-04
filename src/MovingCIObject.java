
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.HashSet;
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

		//board.getContentPane().add(this);
		setSize(width,height);
		aliveMovingObjects.add(this);
		timer.addActionListener(this);
	}

	protected void bomb(MovingCIObject bomber){
		aliveMovingObjects.remove(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		for (MovingCIObject movingCIObject : aliveMovingObjects) {
			if(getBounds().intersects(movingCIObject.getBounds())&& movingCIObject!=this)
			{
				bomb(movingCIObject);
				movingCIObject.bomb(this);
			}
		}
	}


	public void delete() {
		board.getContentPane().remove(this);
		aliveMovingObjects.remove(this);
		timer.removeActionListener(this);
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
