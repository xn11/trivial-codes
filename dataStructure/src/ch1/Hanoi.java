package ch1;

import java.util.Scanner;

public class Hanoi {

	/**
	 * 汉诺塔，从A移至B
	 */
	
	static int step=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("请输入盘子个数： ");
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		new Hanoi().move(num, 'A', 'B', 'C');
		System.out.println("共计"+step+"步");
	}

	void move(int num,char from,char to,char left){
		step++;
		if(num==1){
			System.out.println("盘子"+num+"从"+from+"移至"+to);
		}else{
			move(num-1,from,left,to);
			System.out.println("盘子"+num+"从"+from+"移至"+to);
			move(num-1,left,to,from);
		}
	}
}
