
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public  class Chicken extends JLabel implements Visitable  {
	public static GameFrame board;
	protected int raw,col;
	private static Chicken[][]chickensMat=null;
	enum chickenColor{red, blue, green, orange, purple, yellow, circle, plus, x};
	chickenColor color;
	private static int direction=3;
	public Chicken(String iconPath, int col, int raw) {
		super(iconPath);
	//if(getChickensMat()==null)
		//	chickensMat=new Chicken[8][4];
		//getChickensMat()[col][raw]=this;
		this.raw=raw;
		this.col=col;
		
		
	}

	public void actionPerformed(ActionEvent e) {
		setSize(112, 88);
		if(Math.random()<0.01)
		{
			Egg egg=new Egg(Chicken.this.getLocation());
			board.getContentPane().add(egg);
		}
		
		setLocation(getX()+direction, getY());
		if(getX()==10||getX()==board.getWidth()-getWidth()-10)
			direction=-direction;
	}
	
	
	public static Chicken[][] getChickensMat() {
		return chickensMat;
	}
	
	static chickenColor [][][]levels={
			{{chickenColor.red,chickenColor.blue, chickenColor.yellow, chickenColor.red, chickenColor.red, chickenColor.yellow, chickenColor.blue, chickenColor.red},
				{chickenColor.yellow, chickenColor.red, chickenColor.blue,chickenColor.blue,chickenColor.blue,chickenColor.blue,chickenColor.red, chickenColor.yellow},
				{chickenColor.blue, chickenColor.yellow, chickenColor.red, chickenColor.yellow, chickenColor.yellow, chickenColor.red, chickenColor.yellow, chickenColor.blue},
				{chickenColor.red, chickenColor.blue, chickenColor.yellow, chickenColor.orange, chickenColor.orange, chickenColor.yellow, chickenColor.blue, chickenColor.red},
				
			},
			{{chickenColor.purple, chickenColor.purple, chickenColor.purple, chickenColor.green, chickenColor.green, chickenColor.orange, chickenColor.orange, chickenColor.orange},
				{chickenColor.yellow, chickenColor.circle, chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.circle, chickenColor.yellow},
				{chickenColor.yellow, chickenColor.red, chickenColor.blue, chickenColor.blue, chickenColor.blue, chickenColor.blue, chickenColor.red, chickenColor.yellow },
				{chickenColor.green, chickenColor.purple, chickenColor.orange, chickenColor.yellow, chickenColor.yellow, chickenColor.orange, chickenColor.purple, chickenColor.green},
			
			
			},
			{{chickenColor.purple, chickenColor.purple, chickenColor.purple, chickenColor.yellow, chickenColor.yellow, chickenColor.orange, chickenColor.orange, chickenColor.orange},
				{chickenColor.purple, chickenColor.plus, chickenColor.purple, chickenColor.blue, chickenColor.blue, chickenColor.green, chickenColor.green, chickenColor.green},
				{chickenColor.purple, chickenColor.purple, chickenColor.purple, chickenColor.red, chickenColor.red, chickenColor.green, chickenColor.plus, chickenColor.green},
				{chickenColor.orange, chickenColor.orange, chickenColor.orange, chickenColor.plus, chickenColor.orange,  chickenColor.green,  chickenColor.green,  chickenColor.green},
				
				
			},
			{{chickenColor.purple, chickenColor.purple, chickenColor.orange, chickenColor.orange, chickenColor.purple, chickenColor.purple, chickenColor.orange, chickenColor.orange},
				{chickenColor.green, chickenColor.x, chickenColor.green, chickenColor.x,chickenColor.green,chickenColor.x,chickenColor.green, chickenColor.x},
				{chickenColor.orange, chickenColor.yellow, chickenColor.purple, chickenColor.blue, chickenColor.orange, chickenColor.yellow, chickenColor.purple, chickenColor.blue},
				{chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.red, chickenColor.red},
				
				
			}
			
			
			
	};
	
	public static void load_level(int level){
		chickenColor [][]levelMat=levels[level-1];
		
	}
	
	public void levelMat() {
		int [][] r = new int [4][8] ;
		for (int i=0;i<4;i++){
			for (int j=0;j<8;j++){
				
			}
		}
		
	}
	@Override
	public void accept(Visitor m) {
		// TODO Auto-generated method stub
		
	}
	
}
