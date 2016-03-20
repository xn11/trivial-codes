package headFirstP192;

public class B extends A{
	//void m1(){
		//super.m1();
		//this.m5();
		//System.out.println("B m1, ");
	//}
	
	void m5(){
		System.out.println("BBB");
	}
	public B(){
		super();
		this.m1();
		super.m1();
		this.m5();
		
	}
	public B(int i){
		System.out.println("OH,B"+i);
	}
	
	public void mm(){
		System.out.println("mmB, ");
	}

}
