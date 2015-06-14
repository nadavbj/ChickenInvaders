
public interface Visitor  {
	
	//public void shooting(MovingCIObject bomber);

	public void visit(RedShot shot);
	public void visit(BlackShot shot);
	public void visit(BlueShot shot);
	public void visit(YellowShot shot);
	

}
