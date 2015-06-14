
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;


public class StatusPanel extends JLabel implements Runnable{
	
			public JLabel stopper, shots;
			public int level_Shots, level_Time, level_Score;
			public Vector<Integer> totalLevelScores = new Vector<Integer>();
			public long startTime;
			public final SimpleDateFormat timerFormat = new SimpleDateFormat("mm:ss");
			public Thread updater;
			public boolean isRunning= false;
			public final Runnable displayUpdater= new Runnable(){
				public void run(){
		            displayElapsedTime(System.currentTimeMillis() - StatusPanel.this.startTime);
		            level_Time = (int)System.currentTimeMillis() - (int)StatusPanel.this.startTime;
		            level_Time = level_Time/1000;
				}
	        };
			
	        public void displayElapsedTime(long elapsedTime){
		        stopper.setText(timerFormat.format(new java.util.Date(elapsedTime)));
		    }
		    public void run(){
		        try{
		            while(isRunning){
		                SwingUtilities.invokeAndWait(displayUpdater);
		                Thread.sleep(50);
		            }
		        }
		        catch(java.lang.reflect.InvocationTargetException ite){
		            ite.printStackTrace(System.err);
		            // This should never happen
		        }
		        catch(InterruptedException ie) {}
		        // return
		    }

	public StatusPanel() {
		
		Font font = new Font("Roboto Condensed", Font.BOLD, 18);
		setLayout(null);
		
		stopper = new JLabel("00:00");
		shots= new JLabel("Shots Count: 0"+"     ");
		stopper.setFont(font);
		shots.setFont(font);
		
		stopper.setForeground(Color.BLACK);
		shots.setForeground(Color.BLACK);
		 
		shots.setBounds(0, 520, 1100, 87);
		
		this.add(shots);
		this.add(stopper);
		
	}
	//getters setters
			public Vector<Integer> getTotalLevelScores() {
				return totalLevelScores;
			}
			public void setTotalLevelScores(Vector<Integer> totalLevelScores) {
				this.totalLevelScores = totalLevelScores;
			}
			public long getStartTime() {
				return startTime;
			}
			public void setStartTime(long startTime) {
				this.startTime = startTime;
			}
			public JLabel getShots() {
				return shots;
			}
			public void setShots(JLabel shots) {
				this.shots = shots;
			}
			public int getLevel_Shots() {
				return level_Shots;
			}
			public void setLevel_Shots(int level_Shots) {
				this.level_Shots = level_Shots;
			}
			public int getLevel_Time() {
				return level_Time;
			}
			public void setLevel_Time(int level_Time) {
				this.level_Time = level_Time;
			}
			public int getLevel_Score() {
				return level_Score;
			}
			public void setLevel_Score(int level_Score) {
				this.level_Score = level_Score;
			}
			public boolean isRunning() {
				return isRunning;
			}
			public void setRunning(boolean isRunning) {
				this.isRunning = isRunning;
			}
			public Runnable getDisplayUpdater() {
				return displayUpdater;
			}
			public JLabel getStopper() {
				return stopper;
			}
			public void setStopper(JLabel stopper) {
				this.stopper = stopper;
			}
			public Thread getUpdater() {
				return updater;
			}
			public void setUpdater(Thread updater) {
				this.updater = updater;
			}
			public SimpleDateFormat getTimerFormat() {
				return timerFormat;
			}
}
