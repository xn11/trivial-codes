package frame;

import java.awt.BorderLayout;
import javax.swing.*;

public class ShowBorderLayout extends JFrame {

	/**
	 * @param args
	 */
	public ShowBorderLayout(){
		setLayout(new BorderLayout(5,10));
		
		add(new JButton("East"),BorderLayout.EAST);
		add(new JButton("West"),BorderLayout.WEST);
		add(new JButton("South"),BorderLayout.SOUTH);
		add(new JButton("North"),BorderLayout.NORTH);
		add(new JButton("Center"),BorderLayout.CENTER);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowBorderLayout frame=new ShowBorderLayout();
		frame.setTitle("ShowBorderLayout");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,300);
		frame.setVisible(true);
	}

}
