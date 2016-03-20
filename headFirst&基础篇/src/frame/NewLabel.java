package frame;

import java.awt.Graphics;

import javax.swing.JLabel;

public class NewLabel extends JLabel{
		public NewLabel(String s){
			super(s);
		}
		
		protected void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawLine(0, 0, 50, 50);
		}
		
	}


