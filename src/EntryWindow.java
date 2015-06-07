import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EntryWindow extends JFrame {
	private GameFrame gf;
	private JPanel contentPane;
	private static JPanel imagePanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryWindow frame = new EntryWindow();
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
	public EntryWindow() {
		gf = new GameFrame();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Set Level");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(248, 317, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnStart = new JButton("start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gf.setVisible(true);
				dispose();
				
			}
		});
		btnStart.setBounds(248, 275, 117, 29);
		contentPane.add(btnStart);
		
		JLabel lblTitle = new JLabel("");
		lblTitle.setIcon(new ImageIcon(EntryWindow.class.getResource("/Chicken_Invaders_resources/new3937.jpg")));
		
		lblTitle.setBounds(126, 0, 600, 247);
		contentPane.add(lblTitle);
		
		JLabel backGround = new JLabel("");
		backGround.setIcon(new ImageIcon(EntryWindow.class.getResource("/Chicken_Invaders_resources/backGround.jpeg")));
		backGround.setBounds(6, -12, 600, 600);
		contentPane.add(backGround);
	}
	
	
}
