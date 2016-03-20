package ch1;

import java.util.Scanner;

public class Combination {
	/**
	 *组合 n中选r个
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan=new Scanner(System.in);
		System.out.print("Please input n and r(like:5 1): ");
		int n,r;
		n=scan.nextInt();
		r=scan.nextInt();
		int[] temp=new int[r];
		new Combination().func(temp,n,r);
	}

	void func(int temp[],int max,int left){
		if(left==0){
			print(temp);
			return;
		}
		for(int i=max;i>=left;i--){
			temp[left-1]=i;
			func(temp,i-1,left-1);
		}
	}
	
	void print(int temp[]){
		for(int i=0;i<temp.length;i++){
			System.out.print(temp[i]+" ");
		}
		System.out.println();
	}
}
