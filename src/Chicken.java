
import java.awt.event.ActionEvent;

import javax.swing.Icon;


public  class Chicken extends MovingCIObject {
	protected int raw,col;
	private static Chicken[][]chickensMat=null;
	enum chickenColor{red, blue, green, orange, purple, yellow, circle, plus, x};
	chickenColor color;
	private static int direction=3;
	public Chicken(int col, int raw,chickenColor c) {
		super("/Chicken_Invaders_resources/chicken/chicken_"+c+".PNG");
		if(getChickensMat()==null)
			chickensMat=new Chicken[8][4];
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
		
		//long xtime  
		//xtime++;
		//setLocation(getX(),baseY+10*Math.sin(xtime));
		setLocation(getX()+direction, getY());
		if(getX()==10||getX()==board.getWidth()-getWidth()-10)
			direction=-direction;
	}
	
	
	public static Chicken[][] getChickensMat() {
		return chickensMat;
	}
	
	static chickenColor [][][]levels={
			{{chickenColor.red,chickenColor.blue},
				{},
				
			}
			
			
			
	};
	
	public static void load_level(int level){
		chickenColor [][]levelMat=levels[level-1];
		
	}
	
}
