package frame;

import java.awt.*;

import javax.swing.*;


public class MyDrawPanel extends JPanel{
	/*public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(20, 50, 100, 100);
	}
	*/
	public void paintComponent(Graphics g){
		Image image=new ImageIcon("image/ͼƬ2.jpg").getImage();
		g.drawImage(image, 3, 4,this);		
	}

}
