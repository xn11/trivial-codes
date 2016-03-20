package dotcom;
import java.util.*;
import static java.lang.System.out;

public class DotComBust {
	private GameHelper helper=new GameHelper();
	private ArrayList<DotCom> dotComsList=new ArrayList<DotCom>();
	private int numOfGuesses=0;
	
	public void setUpGame(){
		DotCom one=new DotCom();
		one.setName("Pets.com");
		DotCom two=new DotCom();
		two.setName("eToys.com");
		DotCom three=new DotCom();
		three.setName("Go2.com");
		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		out.println("RULES...");
		
		for(DotCom dotComToSet:dotComsList){
			ArrayList<String> newLocation=helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation); 			
		}
	}
	
	public void startPlaying(){
		while(!dotComsList.isEmpty()){
			String userGuess=helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}
	
	public void checkUserGuess(String userGuess){
		numOfGuesses++;
		String result="miss";
		for(DotCom dotComToTest:dotComsList){
			result=dotComToTest.checkYourself(userGuess);
			if(result.equals("hit")){
				break;
			}
			if(result.equals("kill")){
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		out.println(result);
	}
	
	public void finishGame(){
		out.println("finish..."+numOfGuesses);
	}

}
