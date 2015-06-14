
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Rectangle;


public interface ForMenu {
	/*
	 * interface of menu painter that responsible the components  paint in main menu
	 */
	 public void paint(Graphics2D g2d, String text, Rectangle bounds, boolean isSelected, boolean isFocused);

     public Dimension getPreferredSize(Graphics2D g2d, String text);

}
