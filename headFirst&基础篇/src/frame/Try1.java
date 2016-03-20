package frame;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Try1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame=new JFrame("colour");
		JTable table=new JTable();
		
		ArrayList one=new ArrayList();
		one.add("1");
		one.add("2");
		
		table.setFont(new Font("宋体",Font.PLAIN,13));
		String[][] data=new String[one.size()][5];
		String[] title=new String[]{"A","S","D","X","Z"};
		DefaultTableModel tableModel=new DefaultTableModel(data,title);
		table.setModel(tableModel);		
		frame.add(table);
		/*
		JButton button=new JButton("Click me, guy!");
		JTextField text=new JTextField("Typing");
		button.setBackground(new Color(199,200,99));
		button.setForeground(new Color(2,33,7));
		
		button.setBounds(0, 0, 1, 2);
		
		button.setToolTipText("Nothing will happen...");
		button.setFont(new Font("SansSerif",Font.ITALIC,15));
		frame.setLayout(new GridLayout(2,1,5,5));
				frame.add(text);frame.add(button);

		*/
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200,300);
		frame.setVisible(true);
		
		
		
		//打印出所有字体名称；
		/*GraphicsEnvironment e=GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[]fontnames=e.getAvailableFontFamilyNames();
		for(int i=0;i<fontnames.length;i++){
			System.out.println(fontnames[i]);
		}*/

	}

}
