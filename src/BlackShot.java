
public class BlackShot extends Shot {
	static String iconPath = ("/Chicken_Invaders_resources/black.png");
	
	public BlackShot() {
		super(iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shooting(Visitor v) {
       
		v.visit(this);
		
	}


	
	


}
