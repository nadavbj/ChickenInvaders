
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
import java.util.Date;

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
	private String playerName= "Chicken Player";
	private int level=1;
	private String name;
	
	private int total=0;

	public GameFrame(int level, String name) {

		
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
		this.name = name;
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
		
		Chicken.load_level(level);
		JOptionPane.showMessageDialog(null, "Press ENTER to start game");
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
						status.updater= new Thread(status);
						status.updater.start();
					}
			    }
				if(status.isRunning){
				switch (e.getKeyCode()) {
				
				case  KeyEvent.VK_RIGHT:
				
					spaceship.setDirection(0);
					break;
				case  KeyEvent.VK_LEFT:
					spaceship.setDirection(0);
					break;
				default:
					break;
				}
				
			}
		}
			@Override
			public void keyPressed(KeyEvent e) {
				//pressing enter starts the game
				if (e.getKeyCode() == KeyEvent.VK_ENTER){
					if(!status.isRunning){
						status.startTime= System.currentTimeMillis();
						status.isRunning= true;
						status.updater= new Thread(status);
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
				
					spaceship.setDirection(16);
					break;
				case  KeyEvent.VK_LEFT:
					spaceship.setDirection(-16);
					break;
				
				default:
					break;
				}
				
			}
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

	
	
	
	
		public void finishLevel()
		{	
			//check if the level is over
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
							
							
							//calculate level score
							status.setLevel_Score(Math.max(0, 600 - status.getLevel_Shots()*10 - status.getLevel_Time()));
							
							//insert into total level scores vector
							status.getTotalLevelScores().add(status.getLevel_Score());

							//calculate sum of levels scores
							int sum = 0;
							for(int q=0;q<status.getTotalLevelScores().size();q++){
								sum = sum + status.getTotalLevelScores().elementAt(q);
							}
							
							//show game results
							JOptionPane.showMessageDialog(null, 
									"Hi"+ "\n" +" Level Shots: "+status.getLevel_Shots()+ "\n" +
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

												
							if (level <6){
								Chicken.load_level(level);
								JOptionPane.showMessageDialog(null, "Press ENTER to start game");	
								Chicken.load_level(level);	
							}
							
							else{
								
								
							new SaveGame().addWinner(new Winner(total, name,new Date()));
								WinnersTable win = new WinnersTable();
								win.setVisible(true);
								dispose();
								
											}
							
						}
	
				
		}

	
	
	
	
}