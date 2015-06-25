import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class WinnersTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private EntryWindow ent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WinnersTable frame = new WinnersTable();
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
	public WinnersTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//ent = new EntryWindow();
		
		SaveGame savedGame=new SaveGame();
		Object[][]data=new Object[6][3];
		int i=0;
		for (Winner winner : savedGame.winners) {
			System.out.println(winner.getName());
			data[i++]=(new Object[]{winner.getName(),winner.getScore(),winner.getDate()});
		}
		
		table = new JTable(data,new Object[]{"Name", "Score", "date"}); 
		table.setBounds(6, 59, 411, 188);
		contentPane.add(table);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(18, 30, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblScore = new JLabel("Score");
		lblScore.setBounds(120, 31, 61, 16);
		contentPane.add(lblScore);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(215, 30, 61, 16);
		contentPane.add(lblDate);
		
		JButton btnGoBack = new JButton("Go Back");
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			ent = new EntryWindow();
				ent.setVisible(true);
				dispose();
			}
		});
		btnGoBack.setBounds(350, 6, 94, 38);
		contentPane.add(btnGoBack);
		
	}
}
