

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;


public class SaveGame {

	ArrayList<Winner> winners;
	public SaveGame() {
		  try {
	        	FileInputStream fin	= new FileInputStream("Winners.bin");
	            ObjectInputStream in = new ObjectInputStream(fin);
	            winners =(ArrayList<Winner>)  in.readObject();

	            in.close();
    
	        } catch (Exception ex) {
	        	winners = new ArrayList<Winner>();  
	        }
		
	}
	public void addWinner(Winner winner) {
		winners.add(0, winner);
		while(winners.size()>5)
			winners.remove(5);
		try {

			FileOutputStream fout = new FileOutputStream("Winners.bin");
			ObjectOutputStream out = new ObjectOutputStream(fout);

			out.writeObject(winners);
			out.close();
			return;
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Connot save game.");
		}
		
	}
}
