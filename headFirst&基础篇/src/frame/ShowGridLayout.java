package frame;

import java.awt.GridLayout;
import javax.swing.*;

public class ShowGridLayout extends JFrame{

	/**
	 * @param args
	 */
	public ShowGridLayout(){
		setLayout(new GridLayout(3,2,5,5));
		
		add(new JLabel("1"));
		add(new JTextField(8));
		add(new JLabel("2"));
		add(new JTextField(1));
		add(new JLabel("3"));
		add(new JTextField(8));
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowGridLayout frame=new ShowGridLayout();
		frame.setTitle("ShowGridLayout");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,100);
		frame.setVisible(true);

	}

}
