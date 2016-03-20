package formatXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * ������stack����
 * @author lenovo
 *
 */
public class formatXML {

	public static void format() throws IOException {
        Reader fr = null;  
        BufferedWriter wr=null;
		try {
//			BufferedReader br = new BufferedReader(new FileReader(new File(
//					"1.txt")));
			fr = new InputStreamReader(new FileInputStream(new File("1.txt")));
			wr = new BufferedWriter(new FileWriter(new File(
					"3.txt")));
			
//			int tempchar;
			char last,c;
			/*
			 * while ((tempchar = reader.read()) != -1) { //
			 * ����windows�£�rn�������ַ���һ��ʱ����ʾһ�����С� // ������������ַ��ֿ���ʾʱ���ỻ�����С� //
			 * ��ˣ����ε�r����������n�����򣬽������ܶ���С� if (((char) tempchar) != 'r') {
			 * System.out.print((char) tempchar); } }
			 */
			last = (char)fr.read();
			String s=""+last;
			int tmp,n=0;
			boolean ifEnd=false;
			while ((tmp = fr.read()) != -1) {
				c=(char)tmp;
				
				if(c=='>'){
					for(int i=0;i<n;i++){
						wr.write("\t");
					}
					wr.write(s+""+c+"\r\n");
					
					s="";
				}else if(c=='<'){
					
					if(!s.isEmpty()){
						n++;
						for(int i=0;i<n;i++){
							wr.write("\t");
						}
						wr.write(s+"\r\n");
					}else if(last=='>'&&!ifEnd){
						n++;
					}
					ifEnd=false;
					s=""+c;
				}else if(c=='/'&&last=='<'){
					ifEnd=true;
					n--;
					s+=c;
				}else if(c=='!'&&last=='<'){
					n--;
					s+=c;
				}else{
					s+=c;
				}
				last =c;
			}
				
			wr.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			wr.close();
			fr.close();
		}
	}

	public static void main(String[] args) {
		try {
			format();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
