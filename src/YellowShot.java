
public class YellowShot extends Shot{
	static String iconPath = ("/Chicken_Invaders_resources/yellow.png");
	
	public YellowShot() {
		super(iconPath);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void shooting(Visitor v) {
       
		v.visit(this);
		
	}

	
	

}
