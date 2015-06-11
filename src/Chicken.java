
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


public abstract class Chicken extends PassiveCIObject implements Visitor  {
	protected int raw,col;
	private static Chicken[][]chickensMat=null;
	enum chickenColor{red, blue, green, orange, purple, yellow, circle, plus, x};
	chickenColor color;
	private static int direction=3;
	public Chicken(String iconPath, int col, int raw) {
		super(iconPath);
		if(chickensMat==null)
			chickensMat=new Chicken[4][8];
		chickensMat[col][raw]=this;
		this.raw=raw;
		this.col=col;


	}

	public void actionPerformed(ActionEvent e) {
		setSize(112, 88);
		if(Math.random()<0.001)
		{
			Egg egg=new Egg(Chicken.this.getLocation());
			board.getContentPane().add(egg);
		}
/*
		setLocation(getX()+direction, getY());
		if(getX()==10||getX()==board.getWidth()-getWidth()-10)
			direction=-direction;*/
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
		
		for (int i = 0; i < levelMat.length; i++) {
			for (int j = 0; j < levelMat[0].length; j++) {
				if(chickensMat!=null&&chickensMat[i][j]!=null)
					chickensMat[i][j].delete();
				Chicken c=null;
				switch (levelMat[i][j]) {
				case red:
					c=new RedChicken(i, j);
					break;
				case blue:
					c=new BlueChicken(i, j);
					break;
				case orange:
					c=new OrangeChicken(i, j);
					break;
				case purple:
					c=new PurpleChicken(i, j);
					break;
				case x:
					c=new X_Chicken(i, j);
					break;
				case plus:
					c=new PlusChicken(i, j);
					break;
				case circle:
					c=new CircleChicken(i, j);
					break;
				default:
					c=new YellowChicken(i, j);
					break;
				}
				
				board.getContentPane().add(c);
				
				c.setSize(114, 80);
				c.setLocation(j*(c.getWidth()+10), i*(c.getHeight()+10));
				
			}
		}
	}


	@Override
	public void delete() {
		super.delete();
		chickensMat[col][raw]=null;
	}

	@Override
	public void visit(RedShot red) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BlueShot blue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(YellowShot yellow) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visit(BlackShot black) {
		// TODO Auto-generated method stub
		
	}
	


}