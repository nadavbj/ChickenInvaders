
public class RedShot extends Shot {
	static String iconPath = ("/Chicken_Invaders_resources/red.png");
	
	public RedShot() {
		super(iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shooting(Visitor v) {
       
		v.visit(this);
		
	}

	
	

}
