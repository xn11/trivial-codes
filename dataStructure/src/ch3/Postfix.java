package ch3;

import java.util.Stack;

public class Postfix {

	/**
	 * 后缀表达式  整数表达式计算
	 */
	
	Character[] ch;
	char[] post;
	Stack<Character> s;
	int j=0;
	
	public static void main(String[] args) {
		char[] c="(1+2-3)".toCharArray();
		new Postfix(c).go();
	}
	
	public Postfix(char[] ch){
		this.ch=new Character[ch.length];
		this.post=new char[ch.length];
		for(int i=0;i<ch.length;i++){
			this.ch[i]=ch[i];
		}
	}
	void go(){
		trans();
		print();
	}
	void trans(){
		s=new Stack<Character>();
		s.push('#');
		for(int i=0;i<ch.length;i++){
			if(ch[i]<='9'&&ch[i]>='0'){
				post[j]=ch[i]; j++;
			}else if(ch[i]==')'){
                for (char temp=s.pop();temp!='(';temp=s.pop()){
                	post[j]=temp; j++;
                }
			}else{
				char temp=s.pop();
				for (; isp(temp) > icp(ch[i]); temp=s.pop()){
					post[j]=temp; j++;
				}
                s.push(temp);
                s.push(ch[i]);
			}
		}
		while (!s.isEmpty()){ 
			post[j]=s.pop(); j++;
			}		
	}
	//是否为操作符
	boolean isOp(String s){
		try{
			Double.parseDouble(s);
		}catch(Exception e){
			return true;
		}
		return false;
	}
	//括号内
	int isp(char ch){
		int value=0;
		switch(ch){
			case '+': 
			case '-': value=3; break;
			case '*':
			case '/': value=5; break;
			case '^': value=7; break;
			case '(': value=1; break;
			case ')': value=8; break;
		}
		return value;
	}
	//括号外
	int icp(char ch){
		int value=0;
		if(ch=='(')	  value=8;
		else if(ch==')')  value=1;
		else if(ch=='#')  value=0;
		else value=isp(ch)-1;
		return value;
	}
	//操作
	double operate(double l,char op,double r){
		double result=0.0;
		switch(op){
		case '+': result=l+r; break;
		case '-': result=l-r; break;
		case '*': result=l*r; break;
		case '/': result=l/r; break;
		case '^': result=Math.pow(l, r); break;
		}
		return result;
	}
	//计算	
	double calcu(){
		Stack<Double> sd=new Stack<>();
		double temp=0.0;
		for(int i=0;i<j-1;i++){
			if(isOp(post[i]+"")){
					temp=sd.pop();
					temp=operate(sd.pop(),post[i],temp);
					sd.push(temp);			
			}else{
				sd.push(Double.parseDouble(post[i]+""));
			}
		}
		return temp;
	}
//显示
	void print(){
		for(int i=0;i<j;i++){
			System.out.print(post[i]+" ");
		}
		System.out.print("= "+calcu());
	}

}
