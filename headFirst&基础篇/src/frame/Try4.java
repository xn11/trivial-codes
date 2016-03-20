package frame;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Try4 {

	/**
	 * @param args
	 */
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="1/2/3";
		String s1="a/b/c";
		String[] ss=s.split("/");
		String[] ss1=s1.split("/");
		String[][] str={ss,ss1};
		//String[][] str={{"1","11","111"},{"2","22","222"},{"3","33","333"}};
		String[] title={"t1","t2","t3"};
		DefaultTableModel md=new DefaultTableModel(str,title);

		
		JFrame frame=new JFrame();

		JTable table=new JTable(str,title);
		table.setModel(md);	
		//frame.add(table);
		
        frame.add(new JScrollPane(table),BorderLayout.CENTER);  

		//frame.setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
	}

}
