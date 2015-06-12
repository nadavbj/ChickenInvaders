
public class BlueShot extends Shot {

	static String iconPath = ("/Chicken_Invaders_resources/blue.png");
	
	public BlueShot() {
		super(iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shooting(Visitor v) {
		v.visit(this);
		delete();
	}

	
	
	
	
}
