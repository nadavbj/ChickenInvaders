import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame {

	private JPanel contentPane;
	private Shot.shotColor color=Shot.shotColor.black;
	private JLabel backGround;
	private JPanel boardPanel;
	private BlueChicken b;
	
	public GameFrame() {
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MovingCIObject.board=this;
		final Spaceship spaceship=new Spaceship();
		contentPane.add(spaceship);
	
		boardPanel = new JPanel();
		boardPanel.setLayout(new GridLayout(4, 8));
		contentPane.add(boardPanel, BorderLayout.NORTH);
		

		boardPanel.setSize(600, 600);
		/*
		backGround = new JLabel("");
		backGround.setIcon(new ImageIcon(GameFrame.class.getResource("/Chicken_Invaders_resources/back3.jpg")));
		backGround.setBounds(0, 0, 600, 600);
		contentPane.add(backGround);
		*/
		
		
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {

				Shot s=null;

				switch (e.getKeyCode()) {
				case KeyEvent.VK_1:
				case KeyEvent.VK_NUMPAD1:
					color=Shot.shotColor.black;
					break;
				case KeyEvent.VK_2:
				case KeyEvent.VK_NUMPAD2:
					color=Shot.shotColor.red;
					break;case KeyEvent.VK_3:
					case KeyEvent.VK_NUMPAD3:
						color=Shot.shotColor.blue;
						break;case KeyEvent.VK_4:
						case KeyEvent.VK_NUMPAD4:
							color=Shot.shotColor.yellow;			
						case KeyEvent.VK_SPACE:
							s=new Shot(color);
							contentPane.add(s);
							s.setLocation(spaceship.getX()+spaceship.getWidth()/2-10,spaceship.getY());
							break;

							default:
							return;
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {}
		});
	}
	
	public void addLevel (){
		
		JLabel ch = new JLabel ("");
		JLabel space = new JLabel ("");
		
		for(int i =0;i<4;i++){
			for(int j=0;j<8;j++){
				this.b = new BlueChicken(i, j) ;
				//ch = new JLabel(new ImageIcon("/Users/yarden/git/ChickenInvaders/src/Chicken_Invaders_resources/chicken/chicken_blue.PNG"));
				space = new JLabel(new ImageIcon("/Users/yarden/git/ChickenInvaders/src/Chicken_Invaders_resources/background2.jpeg"));

				b.setSize(134,96);
				space.setSize(50, 50);
				b.setLocation(0,0);
				space.setLocation(0, 0);
				boardPanel.add(ch);
				boardPanel.add(space);

			}
				}
				
		boardPanel.setLocation(0, 0);

	}
	
	

}