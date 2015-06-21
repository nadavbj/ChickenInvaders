
import java.awt.*;
import java.io.Serializable;



 public class Painter implements ForMenu {

public Dimension getPreferredSize(Graphics2D g2d, String text) {
            return g2d.getFontMetrics().getStringBounds(text, g2d).getBounds().getSize();
        }

 
public void paint(Graphics2D g2d, String text,Rectangle bounds, boolean isSelected, boolean isFocused) {
			Font font = new Font("Roboto Condensed", Font.BOLD, 30);
		    g2d.setFont(font);
			FontMetrics fm = g2d.getFontMetrics();
			
			Color backF = new Color(208-32-144);
            
			if (isFocused) {
                paintBackground(g2d, bounds, backF, Color.WHITE);
                
            } else {
                paintBackground(g2d, bounds, backF, Color.PINK);
            }
            int x = bounds.x + ((bounds.width - fm.stringWidth(text)) / 2);
            int y = bounds.y + ((bounds.height - fm.getHeight()) / 2) + fm.getAscent();
            g2d.setColor(isFocused ? Color.WHITE : Color.GRAY);
          
            g2d.drawString(text, x, y);
        }

 protected void paintBackground(Graphics2D g2d, Rectangle bounds, Color background, Color foreground) {
            g2d.setColor(background);
            g2d.fill(bounds);
            g2d.setColor(foreground);
            g2d.draw(bounds);
        }


    


}

