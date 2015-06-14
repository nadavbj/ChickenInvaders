
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame{

	private JPanel contentPane;
	private StatusPanel status; 
	private String playerName= "player";
	private int level=1;
	private File file = new File("top10.txt");
	private int[] scoreArray = new int[10];
	private String[] playerScoreArray = new String[10];

	private int total=0;

	public GameFrame(int level) {

		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		setResizable(false);
		this.setSize(1010, 700);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	    contentPane.setLayout(null);
		setContentPane(contentPane);
		MovingCIObject.board=this;
		final Spaceship spaceship=new Spaceship();
		contentPane.add(spaceship);
		//spaceship.setLocation((getWidth()-spaceship.getWidth())/2, getHeight()-2*spaceship.getHeight());
	
		spaceship.setLocation(470,470);
	//	tool.setBounds(0, 550, 973, 87);
		
		status= new StatusPanel();
	
		JToolBar tool  = new JToolBar();			
		tool.setBounds(0, 550, 973, 87);
		
		
		tool.add(status.shots);
	    tool.add(status.stopper);
		tool.setFloatable(false);
		
     	contentPane.add(tool);
   
		this.level = level;
		setGameLevel(3);
		//JOptionPane.showMessageDialog(null, "Press DOUBLE ENTER to start game");
		//contentPane.add(status, BorderLayout.LINE_END);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
				//pressing enter starts the game
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					if(!status.isRunning){
						status.startTime= System.currentTimeMillis();
						status.isRunning= true;
						status.updater= new Thread();
						status.updater.start();
					}
			    }
				if(status.isRunning){
				switch (e.getKeyCode()) {
				case KeyEvent.VK_1:
				case KeyEvent.VK_NUMPAD1:
					lastKey=1;
					break;
				case KeyEvent.VK_2:
				case KeyEvent.VK_NUMPAD2:
					lastKey=2;
					break;
				case KeyEvent.VK_3:
				case KeyEvent.VK_NUMPAD3:
					lastKey=3;
					break;
				case KeyEvent.VK_4:
				case KeyEvent.VK_NUMPAD4:
					lastKey=4;
					break;
				case KeyEvent.VK_SPACE:
					Shot s=null;
					switch (lastKey) {
					case 1:
						s=new BlackShot();
						//increase shots count
						status.level_Shots++;
						//update shots counter in the status
						status.getShots().setText("Shots Count: "+status.level_Shots +"     ");
						
						break;
					case 2:
						s=new RedShot();
						//increase shots count
						status.level_Shots++;
						//update shots counter in the status
						status.getShots().setText("Shots Count: "+status.level_Shots +"     ");
						
						break;
					case 3:
						s=new BlueShot();
						//increase shots count
						status.level_Shots++;
						//update shots counter in the status
						status.getShots().setText("Shots Count: "+status.level_Shots +"     ");
					
						break;
					case 4:
						s=new YellowShot();
						//increase shots count
						status.level_Shots++;
						//update shots counter in the status
						status.getShots().setText("Shots Count: "+status.level_Shots +"     ");
						
						break;
					}
					contentPane.add(s);
					s.setVisible(true);
					s.setLocation(spaceship.getX()+spaceship.getWidth()/2-10,spaceship.getY());
					break;
				case  KeyEvent.VK_RIGHT:
					if(spaceship.getX()+33<getWidth())
					spaceship.setLocation(spaceship.getX()+33,spaceship.getY());
					break;
				case  KeyEvent.VK_LEFT:
					if(spaceship.getX()-33>0)
					spaceship.setLocation(spaceship.getX()-33,spaceship.getY());
					break;
				default:
					break;
				}
				
			}
		}
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		
	
	}
	int lastKey=1;
	

	private boolean gameOver(){
		boolean result = true;
		for(int i = 0;i<4;i++){
			for (int j=0; j<8; j++){
				Chicken c = Chicken.chickensMat[i][j];
				if(c!=null){
					result = false;
				}
			}
		}
		return result;
	}
	
	
	public void addBackg(){

	JLabel backGround = new JLabel("");
	backGround.setIcon(new ImageIcon(GameFrame.class.getResource("/Chicken_Invaders_resources/back3.jpg")));
	backGround.setBounds(126, 0, 1000, 600);
	contentPane.add(backGround);
	}

	public void setGameLevel (int level){
	Chicken.load_level(level);
	}

	
		public void finishLevel()
		{
						//check if gameOver
						if(gameOver()){
							//reset timer
							if(status.isRunning()){
								long elapsed= System.currentTimeMillis() - status.getStartTime();
								status.setRunning(false);
						        try{
						        	status.getUpdater().join();
						            // Wait for updater to finish
						        }
						        catch(InterruptedException ie) {}
						        
						        status.displayElapsedTime(elapsed);
							}
							
							//calculate game score
							status.setLevel_Score(Math.max(0, 600 - status.getLevel_Shots()*10 - status.getLevel_Time()));
							
							//insert into total level scores vector
							status.getTotalLevelScores().add(status.getLevel_Score());

							//calculate sum of level scores
							int sum = 0;
							for(int q=0;q<status.getTotalLevelScores().size();q++){
								sum = sum + status.getTotalLevelScores().elementAt(q);
							}
							
							//show game results
							JOptionPane.showMessageDialog(null, 
									"Level Shots: "+status.getLevel_Shots()+ "\n" +
									"Level Time: "+status.getLevel_Time() +" \n" + 
									"Current Level Score: " + status.getLevel_Score() +"\n"+
									"Total Level Scores: " + sum);								
							total = total+sum;							
							//reset status values
							status.setLevel_Shots(0);
							status.setLevel_Score(0);
							status.setStartTime(0);
							status.getShots().setText("Shots Count: 0     ");
							status.getStopper().setText("00:00");
							
							//increase level by 1
							level++;
							
							//load next game
							if(level<5){
								Chicken.load_level(level);
								JOptionPane.showMessageDialog(null, "Press ENTER to start game");
							}
							else{
								//NO MORE LEVELS TO PLAY
								EntryWindow entry = new EntryWindow();
								entry.setVisible(true);
								dispose();
							}
							
						}
	
				
		}

	
	public void WriteToFile(String player) throws IOException {

		if (!file.exists()) {
			file.createNewFile();
		}
		ReadFromFile();

		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);

		int index = -1;

		// Finding where the new score should be entered
		
		for (int i = 0; i < this.scoreArray.length; i++) {
			if (total > this.scoreArray[i]) {
				index = i;
				break;
			}
		}
		
		if (index > -1) {
			for (int i = this.scoreArray.length - 1; i > index; i--) {
				this.scoreArray[i] = this.scoreArray[i - 1];
				this.playerScoreArray[i] = this.playerScoreArray[i - 1];
			}
			this.scoreArray[index] = total;
			this.playerScoreArray[index] = player;
		}
		this.scoreArray[index] = total;
		this.playerScoreArray[index] = player;
		String output = "";
		for (int j = 0; j < 10; j++) {
			output = playerScoreArray[j] + ";" + scoreArray[j];
			bw.write(output);
			bw.newLine();
			output = "";
		}
		bw.close();
	}

	public String ReadFromFile() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("top10.txt"));

		String result = "<html> ";
		for (int j = 0; j < 10; j++) {

			String s = br.readLine();
			if (s == null) {
				s = " ;0";
			}
			String[] parts = s.split(";");
			playerScoreArray[j] = parts[0];
			scoreArray[j] = Integer.parseInt(parts[1]);
			result = result + (j + 1) + " " + playerScoreArray[j] + " : "
					+ scoreArray[j] + "<br>";
		}
		br.close();

		return result;

	}
	public String getName (){
		return this.playerName;
	}
	
	public void setName (String name){
		this.playerName = name;
	}
	
	
	
	public static void main(String[] args) {
		new GameFrame(1).setVisible(true);
	}	
}