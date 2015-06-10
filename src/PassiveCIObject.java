import java.awt.event.ActionEvent;


public abstract class PassiveCIObject extends MovingCIObject implements Visitable 
	{
	public PassiveCIObject(String iconPath) {
		super(iconPath);
	}

	public void accept(BlueShot s) {
		// TODO Auto-generated method stub
		
	}

	public void shooting(Visitor v) {
		// TODO Auto-generated method stub
		
	}
}
