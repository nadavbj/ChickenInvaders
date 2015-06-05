
import java.awt.event.ActionEvent;

import javax.swing.Icon;


public  class Chicken extends MovingCIObject {
	protected int raw,col;
	protected static Chicken[][]chickensMat=null;
	enum chickenColor{red};
	chickenColor color;
	public Chicken(int col, int raw,chickenColor c) {
		super("/Chicken_Invaders_resources/chicken/chicken_"+c+".PNG");
		if(chickensMat==null)
			chickensMat=new Chicken[8][4];
		chickensMat[col][raw]=this;
		this.raw=raw;
		this.col=col;
		type="Chicken";
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		setSize(112, 88);
		if(Math.random()<0.01)
		{
			Egg egg=new Egg(Chicken.this.getLocation());
			board.getContentPane().add(egg);
		}
	}
	@Override
	protected boolean bomb(MovingCIObject bomber) {
		if("Shot".equals(bomber.type)){
			return true;
		}	
		return false;
	}
}
