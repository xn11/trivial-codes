package frame;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.*;

public class ShowFlowLayout extends JFrame{

	/**
	 * @param args
	 */
	public ShowFlowLayout(){
		setLayout(new FlowLayout(FlowLayout.LEFT,10,20));
		
		add(new JLabel("1"));
		add(new JTextField(8));
		add(new JLabel("2"));
		add(new JTextField(1));
		add(new JLabel("3"));
		add(new JTextField(8));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowFlowLayout frame=new ShowFlowLayout();
		frame.setTitle("ShowFlowLayout");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,200);
		frame.setVisible(true);

	}

}
