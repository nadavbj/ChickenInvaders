
public interface Visitor  {
	
	//public void shooting(MovingCIObject bomber);

 	public void visit(RedShot red);
 	public void visit(BlueShot blue);
 	public void visit(YellowShot yellow);
 	public void visit(BlackShot black);


}
