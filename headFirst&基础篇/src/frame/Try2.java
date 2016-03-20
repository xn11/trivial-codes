package frame;

import java.awt.*;

import javax.swing.*;

public class Try2 extends JFrame{

	/**
	 * @param args
	 */
	public Try2(){
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(4,3));
		
		ImageIcon icon=new ImageIcon("image/ͼƬ1.jpg");
		
		for(int i=1;i<=9;i++){
			p1.add(new JButton(""+i));
		}
		
		p1.add(new JButton(""+0));
		p1.add(new JButton("Start"));
		p1.add(new JButton("Stop"));
		
		JPanel p2=new JPanel(new BorderLayout());
		p2.add(new JTextField("Time"),BorderLayout.NORTH);
		p2.add(p1,BorderLayout.CENTER);
		
		add(p2,BorderLayout.EAST);
		add(new JButton(icon),BorderLayout.CENTER);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Try2 frame=new Try2();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400,250);
		frame.setVisible(true);

	}

}
