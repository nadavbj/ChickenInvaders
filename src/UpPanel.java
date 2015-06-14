
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;

public class UpPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lblScore;
	private int score = 0;
	private int shots = 0;
	private JButton restart;
	private JButton goBack;
	private JLabel lblName;
	private JLabel lblMoves;
	private JLabel lblTime;
	private JLabel lblShots;
	

	public UpPanel() {
		Font font = new Font("Roboto Condensed", Font.BOLD, 18);
		lblName = new JLabel("Status Bar");
		goBack = new JButton("Go Back");
		restart = new JButton("Restart");
		lblMoves = new JLabel();
		this.lblScore = new JLabel("score: " + this.score);
		this.lblTime = new JLabel("Time: " + this.score);
		this.lblShots = new JLabel("Shots: " + this.shots);
		this.lblScore.setFont(font);
		this.lblName.setFont(font);
		this.lblMoves.setFont(font);
		this.restart.setFont(font);
		this.restart.setForeground(Color.red);
		this.restart.setBorderPainted(false);
		this.restart.setContentAreaFilled(false);
		this.goBack.setBorderPainted(false);
		this.goBack.setContentAreaFilled(false);
		this.goBack.setFont(font);
		this.lblScore.setForeground(Color.red);

		this.add(lblName);
		this.add(restart);
		this.add(lblMoves);
		this.add(lblScore);
		this.add(goBack);

		this.setVisible(true);

	}

	public JButton getRestart() {
		return restart;
	}

	public void setRestart(JButton restart) {
		this.restart = restart;
	}

	public JButton getTop10() {
		return goBack;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
		this.lblScore.setText("score: " + this.score);
	}

	public void setMovesLeft(int movesLeft) {
		this.lblMoves.setText(movesLeft + " moves left	");
	}

}
