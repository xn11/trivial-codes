package frame;

import java.awt.*;
import javax.swing.*;

public class Try3 extends JFrame{

	/**
	 * @param args
	 */
	
	private NewLabel label=new NewLabel("Banner");
	
	public Try3(){
		add(label);
		System.out.println(label.getGraphics());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Try3 frame=new Try3();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,100);
		frame.setVisible(true);
	}
}

