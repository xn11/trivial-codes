package online;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class maxNum {
	
	public static int getMax() throws FileNotFoundException{
		Scanner scan = new Scanner(new BufferedReader(new FileReader("1.txt")));
		int max = 0;
		while(scan.hasNext()){
			max = Math.max(max, scan.nextInt());
		}
		scan.close();
		return max;
	}

	public static void main(String[] args) throws FileNotFoundException {
		int sum = 100;
		
		Scanner scan = new Scanner(new BufferedReader(new FileReader("1.txt")));
		int cnt = 0;
		int max = 0;
		int choose = 0;
		while(scan.hasNext()){
			int tmp = scan.nextInt();
			
			cnt++;
			if(cnt == sum || (cnt > sum/Math.E && tmp > max)){
				choose = tmp;
				break;
			}
			max = Math.max(max, tmp);
			System.out.println(tmp);
		}
		scan.close();
		System.out.println("END " + choose);
		System.out.println(getMax());
	}

}
