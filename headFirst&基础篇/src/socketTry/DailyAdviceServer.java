package socketTry;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceServer {

	/**
	 * @param args
	 */
	
	String[] adviceList={"a","b","c"};
	
	public void go(){
		try {
			ServerSocket ss=new ServerSocket(4242);
			while(true){
				Socket sock=ss.accept();
				PrintWriter pr=new PrintWriter(sock.getOutputStream());
				pr.println("a");
				pr.close();
				System.out.println("a");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DailyAdviceServer ds=new DailyAdviceServer();
		ds.go();
	}

}
