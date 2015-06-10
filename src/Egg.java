import java.awt.Point;
import java.awt.event.ActionEvent;

import javax.swing.Icon;


public class Egg extends PassiveCIObject {

	private static final String IMAGE_PATH = "/Chicken_Invaders_resources/resizeEgg.png";

	public Egg(Point start) {
		super(IMAGE_PATH);
		setLocation(start);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(exploed>0)
			exploed++;
		if(exploed>10)
		 delete();
		if(exploed==0)
			Egg.this.setLocation(getX(), getY()+2);
	}
	int exploed=0;

	@Override
	public void shooting(Visitor v) {
		// TODO Auto-generated method stub
		
	}


	

	
	//@Override
	//public void accept(Visitor bomber) {}
	/*public void accept(Spaceship bomber) 
	{
		setIcon(getIcon("/Chicken_Invaders_resources/resizeExp.png"));
		exploed=1;	
	}*/
	
}
