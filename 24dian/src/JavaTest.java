
import java.util.ArrayList;

public class JavaTest {
	/**
	 * ʹ��4���Ƽ����24�㣬ֻʹ�üӼ��˳����������
	 * @param cards : �����4����
	 * @return ����24�����ʽ
	 */
	public static String res=null;
	
	public String make24Points(String cards) {
		if(cards==null||cards.contains("joker")||cards.contains("JOKER")){
			return "ERROR";
		}
		String[] c=cards.split(" ");
		if(c.length!=4){
			return "ERROR";
		}
		ArrayList<Double> d=new ArrayList<Double>();
		ArrayList<String> s=new ArrayList<String>();
		
		for(int i=0;i<4;i++){
			double td=toD(c[i]);
			if(td==-1){
				return "ERROR";
			}
			d.add(td);
			s.add(c[i]);
		}
		res=null;		//�������
		recursion(d,s);
		if(res==null){
			return "NONE";
		}
		return res;
	}
	
	//�ݹ飬������ȡ����������������Ż�����
	private void recursion(ArrayList<Double> d,ArrayList<String> s){
		int n=d.size();
		if(n==1){
			if(Math.abs(d.get(0)-24.0)<=0.000000001){	//��ֹ�з������������
				res=s.get(0);		//������ֻ��һ��������Ϊ24������ʽ�ַ�����ֵ���ྲ̬����
//				System.out.println(res);
			}
			return;
		}
		
		for(int i=0;i<n;i++){
			for(int j=i+1;j<n;j++){
				ArrayList<Double> dd=new ArrayList<Double>();//���ڵݹ��������
				ArrayList<String> ss=new ArrayList<String>();//���ڴ����ʽ��������
				//����ȡ���������Ĳ�ͬ������
				for(int r=0;r<n;r++){
					if(r!=i&&r!=j){
						dd.add(d.get(r));
						ss.add(s.get(r));
					}
				}
				dd.add(d.get(i)+d.get(j));//����ȡ�������������� a+b
				ss.add("("+s.get(i)+"+"+s.get(j)+")");//��¼�����������ʽ				
				recursion(dd, ss);//�ݹ�
				if(res!=null){	//����̬��������ֵ���򷵻�
					return;
				}
				
				dd.remove(dd.size()-1);//�Ƴ��ϴ���ӵ�����������
				ss.remove(ss.size()-1);
				dd.add(d.get(i)-d.get(j));//a-b
				ss.add("("+s.get(i)+"-"+s.get(j)+")");				
				recursion(dd, ss);
				if(res!=null){
					return;
				}
				
				dd.remove(dd.size()-1);
				ss.remove(ss.size()-1);
				dd.add(d.get(i)*d.get(j));//a*b
				ss.add(s.get(i)+"*"+s.get(j));				
				recursion(dd, ss);
				if(res!=null){
					return;
				}
				
				dd.remove(dd.size()-1);
				ss.remove(ss.size()-1);
				dd.add(d.get(i)/d.get(j));//a/b
				ss.add(s.get(i)+"/"+s.get(j));				
				recursion(dd, ss);
				if(res!=null){
					return;
				}
				
				dd.remove(dd.size()-1);
				ss.remove(ss.size()-1);
				dd.add(d.get(j)-d.get(i));//b-a
				ss.add("("+s.get(j)+"-"+s.get(i)+")");				
				recursion(dd, ss);
				if(res!=null){
					return;
				}
				
				dd.remove(dd.size()-1);
				ss.remove(ss.size()-1);
				dd.add(d.get(j)/d.get(i));//b/a
				ss.add(s.get(j)+"/"+s.get(i));				
				recursion(dd, ss);	
				if(res!=null){
					return;
				}
			}
		}
		
		
	}
	//ת����Ϊ����
	private double toD(String s){
		if(s.equals("A")){
			return 1;
		}
		if(s.equals("J")){
			return 11;
		}
		if(s.equals("Q")){
			return 12;
		}
		if(s.equals("K")){
			return 13;
		}
		int n=Integer.parseInt(s);
		if(n<2||n>10){
			return -1;
		}
		return n;
	}
	

	public static void main(String[] args) {
		JavaTest c = new JavaTest();
		String cards = "3 3 7 7";
//		String cards = "5 5 5 A";
		System.out.println("The method to make 24 points is: " + c.make24Points(cards));
	}
}