
public class GameManager {
	
	GameFrame board;
	 Chicken[][]chickensMat=null;
	Chicken c;
	
	public GameManager() 
	{
		board=new GameFrame();	
	}
	

	public void ToKill(int row ,int col)
	{
		chickensMat = c.getChickensMat();
		chickensMat[row][col]=null;   		
	}
	

	public void kill2Chickens(Chicken c) 
	{
		int killC=2;
		
		for(int i=0; i<chickensMat.length && killC>0; i++)
		{
			for (int j=0; j<chickensMat[0].length && killC>0; j++)
			{
				if(chickensMat[i][j]==c)
				{
					chickensMat[i][j]=null;
					killC--;
				}
			}
		}
		
	}



	public void xChickKill(int row, int col) 
	{
		int rowT=row;
		int colT=col;
		
		while (row>=0 &&col<chickensMat[row].length)   // kill in X style
		{
			chickensMat[row][col]=null;
			row--;
			col++;
		}
		
		row=rowT+1;
		col=colT+1;
		
		while(row<chickensMat.length && col<chickensMat[row].length)   // kill in X style
		{
			chickensMat[row][col]=null;  	
			row++;
			col++;
		}
		
		row=rowT+1;
		col=colT-1;
		
		while (row<chickensMat.length && col>=0)  
		{
			chickensMat[row][col]=null;  	
			row++;
			col--;
		}
		
		row=rowT-1;
		col=colT-1;
		
		while(col>=0 && row>=0)     
		{
			chickensMat[row][col]=null;  	
			row--;
			col--;
		}
		
		

		
	}



	public void plusChickKill(int row, int col) 
	{
		for(int i=0; i<chickensMat[row].length; i++)   /// killing all the chickens in the same row
		{
			chickensMat[row][i]=null;
		}
		
		for(int i=0; i<chickensMat.length;i++)		/// killing all the chickens in the same col
		{
			chickensMat[i][col]=null;
		}
		
	}



	public void circleChickKill(int row, int col) 
	{
		chickensMat[row][col]=null;     //killing herself
		if(row>0)    //check if the chicken isn't in the corner
		{
			chickensMat[row-1][col]=null;  //killing the chicken in the same column 
		}
		if(row<chickensMat.length)
		{
			chickensMat[row+1][col]=null;   // //killing the chicken in the same column 
		}
		if(col<chickensMat[row].length)
		{
			chickensMat[row][col+1]=null;       ////killing the chicken in the same row
		}
		if(col>0)
		{
			chickensMat[row][col-1]=null;    ///killing the chicken in the same row 
		}
		if(row>0 &&col<chickensMat[row].length)
		{
			chickensMat[row-1][col+1]=null;      //killing the chicken in cross
		}
		if(col>0 && row<chickensMat.length)
		{
			chickensMat[row+1][col-1]=null;		//killing the chicken in cross
		}
		if(row>0 && col >0)
		{
			chickensMat[row-1][col-1]=null;			//killing the chicken in cross
		}
		if(row<chickensMat.length && col<chickensMat[row].length)
		{
			chickensMat[row+1][col+1]=null;		//killing the chicken in cross
		}
		
		
	}
	
	
}
