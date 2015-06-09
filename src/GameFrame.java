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
	private JLabel backGround;
	private JPanel boardPanel;
	private BlueChicken b;

	public static void main(String[] args) {
		new GameFrame().setVisible(true);
	}

	public GameFrame() {


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 600);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MovingCIObject.board=this;
		final Spaceship spaceship=new Spaceship();
		contentPane.add(spaceship);

		Chicken.load_level(1);

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

					default:
						break;
					}
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
	int lastKey=1;

}