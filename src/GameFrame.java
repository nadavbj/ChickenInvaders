import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;





public class GameFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameFrame frame = new GameFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public GameFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MovingCIObject.board=this;
		Spaceship spaceship=new Spaceship();
		contentPane.add(spaceship);
		Chicken chicken=new Chicken(2, 2, Chicken.chickenColor.red);
		contentPane.add(chicken);
		chicken.setLocation(200,200);
		chicken.setSize(112, 88);
		addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {}

			@Override
			public void keyReleased(KeyEvent e) {

				Shot s=null;

				switch (e.getKeyCode()) {
				case KeyEvent.VK_1:
				case KeyEvent.VK_NUMPAD1:
					s=new Shot(Shot.shotColor.black);
					break;
				case KeyEvent.VK_2:
				case KeyEvent.VK_NUMPAD2:
					s=new Shot(Shot.shotColor.red);
					break;case KeyEvent.VK_3:
					case KeyEvent.VK_NUMPAD3:
						s=new Shot(Shot.shotColor.blue);
						break;case KeyEvent.VK_4:
						case KeyEvent.VK_NUMPAD4:
							s=new Shot(Shot.shotColor.yellow);
							break;
						default:
							return;
				}
				contentPane.add(s);
				s.setLocation(spaceship.getX()+spaceship.getWidth()/2-10,spaceship.getY());
			}

			@Override
			public void keyPressed(KeyEvent e) {}
		});
	}

}
