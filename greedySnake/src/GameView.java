import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;

public class GameView implements KeyListener {

	JFrame frame=new JFrame();
	private GameMap map;
	JPanel mainPanel = new JPanel();
	MyPanel drawPanel = new MyPanel();
	boolean isOver=false;
	int speed=1;

	public GameView(int size,int speed) {
		this.speed=(speed<=0?1:speed);
		if(size<30||size>90){
			size=40;
		}
		map = new GameMap(size);
		
		drawPanel.setBounds(0, 0, 7*size, 7*size);
		frame.add(drawPanel);
		frame.addKeyListener(this);
		frame.setTitle("Ã∞≥‘…ﬂ–°”Œœ∑");
		int x=7*size+10;
		int y=7*size+36;
		frame.setSize( x, y );
//		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		Thread thread = new Thread(new MyRunnable()); 
		thread.start(); 
		if(isOver){
			thread.stop();
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("press " +e.getKeyCode());
		map.changeDire(e.getKeyCode());
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void keyTyped(KeyEvent e) {
//		System.out.println(e.getKeyCode());
//		map.move(e.getKeyCode());
	}

	class MyRunnable implements Runnable {

		@Override
		public void run() {
			while (true) {
				isOver=map.move();
				if(!isOver){
					JOptionPane.showMessageDialog(null, "Game Over !");
					frame.dispose();
					new View();
					return;					
				}
				frame.repaint();
				try {
					Thread.sleep(1000/speed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}

	class MyPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public void paint(Graphics g) {
			int[][] mapArray = map.getValMap();

			for (int i = 0; i < map.getN(); i++) {
				for (int j = 0; j < map.getN(); j++) {
					switch (mapArray[i][j]) {
					case 0:
						g.setColor(Color.WHITE);
						break;
					case 1:
						g.setColor(Color.BLACK);
						break;
					case 2:
						g.setColor(Color.RED);
						break;
					default:
						break;
					}
					g.fillRect(7 * i, 7 * j, 7, 7);
				}
			}
			
			frame.setTitle("Ã∞≥‘…ﬂ  µ√∑÷£∫"+map.getScore());
		}

	}
	
	public static void main(String[] args) {
		new GameView(30,10);
	}

}