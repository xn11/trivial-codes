import java.awt.event.*;

import javax.swing.*;


public class View implements ActionListener{
	JFrame frame=new JFrame();
	JLabel sizeLabel=new JLabel("大小 ");
	JTextField sizeText=new JTextField(8);
	JLabel speedLabel=new JLabel("速度 ");
	JTextField speedText=new JTextField(8);
	JButton start=new JButton("开始游戏");
	JPanel mainPanel=new JPanel();
	
	public View(){
		frame.add(mainPanel);
		mainPanel.add(sizeLabel);
		mainPanel.add(sizeText);
		mainPanel.add(speedLabel);
		mainPanel.add(speedText);
		sizeText.setText("40");
		speedText.setText("10");
		mainPanel.add(start);
		start.addActionListener(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		try{
    	int size=Integer.parseInt(sizeText.getText().trim());
    	int speed=Integer.parseInt(speedText.getText().trim());
    	frame.dispose();
        new GameView(size, speed);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "请输入数字！");
			
			sizeText.setText("40");
			speedText.setText("10");
		}
           
	}
	
	public static void main(String[] args) {
		new View();
	}


}
