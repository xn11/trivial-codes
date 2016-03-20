package online;

import java.io.*;

public class randomNum {
	
	public static int getNum(int n){
		return (int) (Math.random()*n);
	}

	public static void main(String[] args) throws IOException {
	   BufferedWriter bw = new BufferedWriter(new FileWriter("1.txt"));
	   String s = "";
	   for(int i = 0; i<100; i++){
		   s+=getNum(1000)+"\n";
	   }
	   bw.write(s);
	   bw.close();

	}

}
