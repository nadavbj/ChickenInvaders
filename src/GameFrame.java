import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;





public class GameFrame extends JFrame {

	private JPanel contentPane;
	private Shot.shotColor color=Shot.shotColor.black;
	private Chicken c;
	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */

	public GameFrame() {
		Chicken[][]chickensMat= c.firstLevel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();		 
		setSize(maxBounds.width, maxBounds.height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MovingCIObject.board=this;
		final Spaceship spaceship=new Spaceship();
		contentPane.add(spaceship);
		Chicken chicken=new Chicken(2, 2, Chicken.chickenColor.red);
		contentPane.add(chicken);
		contentPane.add(chickensMat);
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

}
