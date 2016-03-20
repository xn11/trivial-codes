package xiang;

import java.util.ArrayList;
import java.util.Scanner;

public class SendMsg {
	public static boolean isEnd(char c){
		String s = ".?!";
		return s.contains(""+c);
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();		
		scan.nextLine();
		int length = 0;
		int res = 0;
		ArrayList<Integer> list = new ArrayList<>();
		while(scan.hasNext()){
			String s = scan.nextLine();
			if(s.equals("end")) break;
			length += s.length() + 1;
//			System.out.println(s.charAt(s.length()-1));
			if(isEnd(s.charAt(s.length()-1))){
				if(length <= n){
					list.add(length);
				}				
				length = 0;
			}			
		}
		
		for(int i = 0; i<list.size();i++){
			if(i == list.size()-1){
				res++;break;
			}
			if(list.get(i)+list.get(i+1)>n){
				res++;
			}
		}
		
		System.out.println(res);

	}

}
