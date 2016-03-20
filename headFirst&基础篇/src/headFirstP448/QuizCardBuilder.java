package headFirstP448;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class QuizCardBuilder {

	/**
	 * @param args
	 */
	
	private JTextArea question,answer;
	private ArrayList<QuizCard> cardList;
	private JFrame frame;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QuizCardBuilder builder=new QuizCardBuilder();
		builder.go();
		
	}
	
	public void go(){
		frame=new JFrame("Quiz Card Builder");
		JPanel mainPanel=new JPanel();
		Font bigFont=new Font("sanserif",Font.BOLD,24);
		
		question=new JTextArea(6,20);
		question.setLineWrap(true);
		question.setWrapStyleWord(true);
		question.setFont(bigFont);
		
		JScrollPane qScroll=new JScrollPane(question);
		qScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		qScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		answer=new JTextArea(6,20);
		answer=new JTextArea(6,20);
		answer.setLineWrap(true);
		answer.setWrapStyleWord(true);
		answer.setFont(bigFont);
		
		JScrollPane aScroll=new JScrollPane(answer);
		aScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		aScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		
		JButton nextButton=new JButton("Next Card");
		
		setCardList(new ArrayList<QuizCard>());
		
		JLabel qLabel=new JLabel("Question: ");
		JLabel aLabel=new JLabel("Answer: ");
		
		mainPanel.add(qLabel);
		mainPanel.add(qScroll);
		mainPanel.add(aLabel);
		mainPanel.add(aScroll);
		mainPanel.add(nextButton);
		
		nextButton.addActionListener(new NextCardListener());
		
		JMenuBar menuBar=new JMenuBar();
		JMenu menu=new JMenu("file");
		JMenuItem newMenuItem=new JMenuItem("New");
		JMenuItem saveMenuItem=new JMenuItem("Save");
		
		newMenuItem.addActionListener(new NewMenuListener());
		saveMenuItem.addActionListener(new SaveMenuListener());
		
		menu.add(newMenuItem);
		menu.add(saveMenuItem);
		menuBar.add(menu);
		
		frame.setJMenuBar(menuBar);
		frame.add(BorderLayout.CENTER,mainPanel);
		frame.setSize(500,600);
		frame.setVisible(true);
	}
	
	
	

	public ArrayList<QuizCard> getCardList() {
		return cardList;
	}

	public void setCardList(ArrayList<QuizCard> cardList) {
		this.cardList = cardList;
	}




	class NextCardListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
		}
	}
	
	
	class NewMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
		}
	}
	
	class SaveMenuListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			
		}
	}
	
	
	
}
