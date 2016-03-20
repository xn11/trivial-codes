package xiang;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Defines {
	Map<String,String> map = new HashMap<String, String>();
	
	public String getPar(String s){
		return map.containsKey(s)?getPar(map.get(s)):s;
	}
	
	public void define(String a,String b){
		if(!map.containsKey(a)&& getPar(b)!=a){
			map.put(a, b);
		}
	}
	
	public boolean isOp(char c){
		return "+-*/%^".contains(c+"");
	}
	
	public int calc(String exp){
		if(exp.isEmpty()){
			return 0;
		}
		int st = 0;
		for(int i = exp.length()-1;i>0;i--){
			char c = exp.charAt(i);
			if(c == ')') st++;
			if(c == '(') st--;
			if(st == 0 && c == '+' && !isOp(exp.charAt(i-1))){
				return calc(exp.substring(0,i)) + calc(exp.substring(i+1));
			}
			if(st == 0 && c == '-' && !isOp(exp.charAt(i-1))){
				return calc(exp.substring(0,i)) - calc(exp.substring(i+1));
			}
		}
		st = 0;
		for(int i = exp.length()-1;i>0;i--){
			char c = exp.charAt(i);
			if(c == ')') st++;
			if(c == '(') st--;
			if(st == 0 && c == '*'){
				return calc(exp.substring(0,i)) * calc(exp.substring(i+1));
			}
			if(st == 0 && c == '/'){
				return calc(exp.substring(0,i)) / calc(exp.substring(i+1));
			}
		}
		st = 0;
		for(int i = exp.length()-1;i>0;i--){
			char c = exp.charAt(i);
			if(c == ')') st++;
			if(c == '(') st--;
			if(st == 0 && c == '^'){
				return (int) Math.pow(calc(exp.substring(0,i)),calc(exp.substring(i+1)));
			}
		}
		if(exp.charAt(0)=='-'){
			return -calc(exp.substring(1));
		}
		if(exp.charAt(0)=='('&&exp.charAt(exp.length()-1)==')'){
			return -calc(exp.substring(1,exp.length()-1));
		}
		String par = this.getPar(exp);
		int p = Integer.parseInt(par);
		return p;
	}

	public static void main(String[] args) {
		Defines test = new Defines();
		Scanner scan = new Scanner(System.in);
		while(scan.hasNext()){
			String op = scan.next();
			if(op.equals("define")){
				test.define(scan.next(),scan.next());
			}else{
				int res = test.calc(scan.next());
				System.out.println(res);
			}
		}
	}

}
