package ch1;

import java.util.Scanner;

public class Hanoi {

	/**
	 * ��ŵ������A����B
	 */
	
	static int step=0;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print("���������Ӹ����� ");
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		int num=scan.nextInt();
		new Hanoi().move(num, 'A', 'B', 'C');
		System.out.println("����"+step+"��");
	}

	void move(int num,char from,char to,char left){
		step++;
		if(num==1){
			System.out.println("����"+num+"��"+from+"����"+to);
		}else{
			move(num-1,from,left,to);
			System.out.println("����"+num+"��"+from+"����"+to);
			move(num-1,left,to,from);
		}
	}
}
