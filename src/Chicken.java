
import javax.swing.Icon;


public abstract class Chicken extends MovingCIObject {
	protected int raw,col;
	protected static Chicken[][]chickensMat=null;
	public Chicken(String iconPath,int col, int raw) {
		super(iconPath);
		if(chickensMat==null)
			chickensMat=new Chicken[8][4];
		chickensMat[col][raw]=this;
		this.raw=raw;
		this.col=col;
	}
}
