import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class GameFrame extends JFrame {

	private JPanel contentPane;



	public static void main(String[] args) {
		new GameFrame().setVisible(true);
	}

	public GameFrame() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 600);
		setResizable(false);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		setContentPane(contentPane);
		MovingCIObject.board=this;
		final Spaceship spaceship=new Spaceship();
		contentPane.add(spaceship);
		spaceship.setLocation((getWidth()-spaceship.getWidth())/2, getHeight()-2*spaceship.getHeight());
		
		Chicken.load_level(2);


		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {
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
						break;
					case 2:
						s=new RedShot();
						break;
					case 3:
						s=new BlueShot();
						break;
					case 4:
						s=new YellowShot();
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

			@Override
			public void keyPressed(KeyEvent e) {}
		});

		/*
		backGround = new JLabel("");
		backGround.setIcon(new ImageIcon(GameFrame.class.getResource("/Chicken_Invaders_resources/back3.jpg")));
		backGround.setBounds(126, 0, 1000, 600);
		contentPane.add(backGround);
		 */
	}
	int lastKey=1;

}