
import java.awt.event.ActionEvent;

import javax.swing.Icon;


public  class Chicken extends MovingCIObject {
	protected int raw,col;
	private static Chicken[][]chickensMat=null;
	enum chickenColor{red, blue, green, orange, purple, yellow, circle, plus, x};
	chickenColor color;
	public Chicken(int col, int raw,chickenColor c) {
		super("/Chicken_Invaders_resources/chicken/chicken_"+c+".PNG");
		if(getChickensMat()==null)
			setChickensMat(new Chicken[8][4]);
		getChickensMat()[col][raw]=this;
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
	
	public void setChicken(chickenColor c){
		this.color=c;
	}
	
	@Override
	protected boolean bomb(MovingCIObject bomber) {
		if("Shot".equals(bomber.type)){
			return true;
		}	
		return false;
	}
	
	public static Chicken[][] getChickensMat() {
		return chickensMat;
	}
	public static void setChickensMat(Chicken[][] chickensMat) {
		Chicken.chickensMat = chickensMat;
	}
	
	public Chicken[][] firstLevel( ){
		Chicken chickenR=new Chicken(2, 2, Chicken.chickenColor.red);
		for (int i=1;i<=8;i++){
			for (int j=1; j<=4;j++){
				this.chickensMat[i][j] = chickenR;
				
				
				
			}
		}
		return chickensMat;
	}
	
}
