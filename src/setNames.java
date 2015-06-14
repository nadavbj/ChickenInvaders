import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class setNames extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private GameFrame gf;
	private JPanel contentPane;

	static String name="player"; 

	private JTextField setName;

	
	public setNames() {
		super();
		gf = new GameFrame(1);
		setBounds(100, 100, 200, 200);

		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(null);	
		
		
		setName = new JTextField();

		setName.setBounds(48, 66, 102, 30);

		contentPane.add(setName);

		setName.setColumns(10);
		
		JLabel lblEnterYourName = new JLabel("Enter your Name");
		lblEnterYourName.setBounds(48, 6, 111, 50);
		contentPane.add(lblEnterYourName);
		
		JButton btnNewButton = new JButton("submit ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String firstName;
				firstName = setName.getText();
				setVisible(true);
				gf.setName(firstName);
				gf.setVisible(true);	
				JOptionPane.showMessageDialog(null, "Hi Chicken " + firstName + " Press ENTER to start game");
				dispose();
					
					
			}
		});
		btnNewButton.setBounds(42, 123, 117, 29);
		contentPane.add(btnNewButton);
		
		
	}
	
	public static String getFName(){

		return name;

			}
}
