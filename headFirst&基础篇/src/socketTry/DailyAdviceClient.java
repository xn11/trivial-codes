package socketTry;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class DailyAdviceClient {

	/**
	 * @param args
	 */
	
	public void go(){
		try {
			Socket s=new Socket("127.0.0.1",4242);
			InputStreamReader sr=new InputStreamReader(s.getInputStream());
			BufferedReader br=new BufferedReader(sr);
			String advice=br.readLine();
			System.out.println("Today: "+advice);
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DailyAdviceClient dc=new DailyAdviceClient();
		dc.go();
	}

}
