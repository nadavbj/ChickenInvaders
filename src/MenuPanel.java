
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;


public class MenuPanel extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * the main menu panel includes all the menu buttons and 
	 * control the passes between the next frames
	 */
	private	ArrayList<String> subs;
	private	String selectMenuItem;
	private	String focusedItem;
	private	ForMenu painter;
	private	Map<String,Rectangle> menuBounds = null;    
	private Image background;
	private	JFrame fFrame;
	private GameFrame gf;
	
    
	
	public MenuPanel(final JFrame frame)
	{
		painter=new Painter();
		subs=new ArrayList<String>(25);
		 try {                
			 background = ImageIO.read(new File("pink2.jpg"));
	       } catch (IOException ex) {
	           
	       }
		 fFrame=frame;
		 gf = new GameFrame();
		subs.add("Play");
		subs.add("Set Level");
		subs.add("Hall Of Fame");
		subs.add("Exit");
		selectMenuItem=subs.get(0);
		
		MouseAdapter ma = new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				String newItem = null;
				for (String text : subs)
				{
					Rectangle bounds = menuBounds.get(text);
					if (bounds.contains((e.getPoint())))
							{
								newItem=text;
								break;
							}
				}
				if(newItem!=null && !newItem.equals(selectMenuItem))
				{
					selectMenuItem=newItem;
					repaint();
				}

				Rectangle bounds = menuBounds.get("Exit");
				if (bounds.contains(e.getPoint()))
				{
					fFrame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));	
				}
				
				bounds = menuBounds.get("Play");
				if (bounds.contains(e.getPoint()))
				{
				
						gf.setVisible(true);
					    fFrame.dispose();
				}
				bounds = menuBounds.get("Hall Of Fame");
				if (bounds.contains(e.getPoint()))
				{
				
					gf.setFocusable(false);
/*
					try {
						JOptionPane.showMessageDialog(this, this.ReadFromFile(),
								"Top 10", JOptionPane.PLAIN_MESSAGE);
					} catch (HeadlessException | IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					this.requestFocus();
				}
				}
			*/	
				
			}}
			
			public void mouseMoved(MouseEvent e)
			{
				focusedItem=null;
				for (String text : subs)
				{
					Rectangle bounds = menuBounds.get(text);
					if (bounds.contains(e.getPoint()))
					{
						focusedItem=text;
						repaint();
						break;
					}
				}
			}
		
		};
		
		addMouseListener(ma);
		addMouseMotionListener(ma);
	
		

	}

	public void invalidate()
	{
		menuBounds=null;
		super.invalidate();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(500,500);
	}
	
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
		Graphics2D g2d = (Graphics2D) g.create();
		if (menuBounds == null)
		{
			menuBounds = new HashMap(subs.size());
			int width=0;
			int height = 0 ;
			for (String text : subs)
			{
				Dimension dim = painter.getPreferredSize(g2d, text);
				width=Math.max(width, dim.width);
				height=Math.max(height, dim.height);
			}
			int x = (getWidth() - (width+150))/2;
			
			int totalHeight = (height+10)*subs.size();
			totalHeight+=5*(subs.size()-1);
			int y = (getHeight()-totalHeight)/2;
			
			for (String text : subs)
			{
				menuBounds.put(text, new Rectangle(x,y,width+180,height+20));
				y+=height+20+30;
			}
		}
		
		for (String text : subs)
		{
			Rectangle bounds = menuBounds.get(text);
			boolean isSelected = text.equals(selectMenuItem);
			boolean isFocused = text.equals(focusedItem);
			painter.paint(g2d, text, bounds, isSelected, isFocused);
		}
		g2d.dispose();
		
	}

		
	public class MenuAction extends AbstractAction{

		private final int Delta;
		
		public MenuAction(int del)
		{
			this.Delta=del;
		}
		
		public void actionPerformed(ActionEvent e)
		{
			int index = subs.indexOf(selectMenuItem);
			if (index < 0)
			{
				selectMenuItem=subs.get(0);
			}
			index+=Delta;
			if (index<0)
			{
				selectMenuItem=subs.get(subs.size()-1);			
			}
		    else if (index >= subs.size())
		    {
				selectMenuItem=subs.get(0);
			}
		    else 
		    	selectMenuItem=subs.get(index);
			
			repaint();
		}
	}




public JFrame getCurrFrme()
{
	return fFrame;
}

@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
		
}	




