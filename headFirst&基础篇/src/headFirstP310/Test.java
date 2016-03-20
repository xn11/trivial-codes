package headFirstP310;
import static java.lang.System.out;

public class Test extends StaticSuper {

	/**
	 * @param args
	 */
	static int rand;
	static{
		rand=(int)(Math.random()*6);
		out.println("C"+rand);
	}
	Test(){
		out.println("D");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out.println("E");
		new Test();

	}

}
