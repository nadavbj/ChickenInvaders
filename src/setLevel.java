
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.Font;


public class setLevel extends JDialog {
	private JPanel contentPane;
	private JPanel contentPane_1;
	static Integer level;
	private GameFrame gf;
	
	public setLevel() {
		super();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		
		setBounds(100, 100, 200, 200);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane_1);
		contentPane_1.setLayout(null);
		
		final JSpinner levelSetter = new JSpinner(new SpinnerNumberModel(6,1,6,1));
		levelSetter.setBounds(77, 64, 47, 28);
		contentPane_1.add(levelSetter);
				
		// get values
		JLabel lblLevel = new JLabel("Set game level");
		lblLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		lblLevel.setForeground(SystemColor.activeCaption);
		lblLevel.setBounds(42, 24, 136, 28);
		contentPane_1.add(lblLevel);
		
		
		
				JButton btnSubmitAndStart = new JButton("Submit And Start!");
				btnSubmitAndStart.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						level = (Integer)levelSetter.getValue();
						 gf = new GameFrame(level);
						JOptionPane.showMessageDialog ( 
								null, "You choose to start to play in level: " + level, "Set Level ", 
								JOptionPane.PLAIN_MESSAGE);
						
						//build the new frame with the new input
						gf.setVisible(true);
					   dispose();
						
					}
				});
				btnSubmitAndStart.setBounds(29, 118, 137, 29);
				contentPane_1.add(btnSubmitAndStart);
		
				JLabel lblBackGround = new JLabel("");
				lblBackGround.setIcon(new ImageIcon("/ChickenInvaders/src/Chicken_Invaders_resources/back3.jpg"));
				lblBackGround.setBounds(0, 0, 200, 172);
				contentPane_1.add(lblBackGround);
				
				
		
		
		}
	}


