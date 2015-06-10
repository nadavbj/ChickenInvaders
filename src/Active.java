import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.Set;


public abstract class Active extends MovingCIObject implements Visitor {

	
	
	public Active(String iconPath) {
		super(iconPath);
		// TODO Auto-generated constructor stub
	}
	// 
	@Override
	public void actionPerformed(ActionEvent e) {
		Set<MovingCIObject>objectsToBomb=new HashSet<MovingCIObject>();
		for (MovingCIObject movingCIObject : aliveMovingObjects) {
			if(getBounds().intersects(movingCIObject.getBounds()) && movingCIObject!=this)
			{
				objectsToBomb.add(movingCIObject);
			}
		}
		for (MovingCIObject movingCIObjectToBomb : objectsToBomb){
			shooting(movingCIObjectToBomb);
		}
	}
	
	public void shooting(MovingCIObject bomber) {}

	
	//public void shooting(PassiveCIObject passive) {
		//passive.accept(this);
		//delete();
	
//}
	
	
}
