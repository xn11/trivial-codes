package headFirstP192;

public class A {
	int ivar=7;
	public A(){
	System.out.println("an A.");
	}
	public A(int i){
		System.out.println("As"+i);
	}
	void m1(){
		System.out.println("A m1, ");
		mm();
	}
	void m2(){
		System.out.println("A m2, ");
	}
	void m3(){
		System.out.println("A m3, ");
	}
	
	private void mm(){
		System.out.println("mmA, ");
	}

}
