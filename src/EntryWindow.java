
import java.awt.*;
import java.awt.List;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;

import javax.swing.*;


public class EntryWindow extends JFrame{


	public EntryWindow()
	{
		super("Chicken Invaders By Yarden and Nadav");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new MenuPanel(this));
		pack();
		setVisible(true);
		

	}

		public static void main (String[] args)
		{

			JFrame frame = new EntryWindow();

		}
	}
