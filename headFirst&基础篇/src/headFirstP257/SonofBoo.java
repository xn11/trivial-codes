package headFirstP257;

public class SonofBoo extends Boo {
	public SonofBoo(){
		super("boo");		
	}
	
	public SonofBoo(int i){
		super("Fred");
	}
	
	public SonofBoo(String s){
		super(42);
	}
	
	public SonofBoo(int i,String s){
		
	}
	
	public SonofBoo(String a,String b,String c){
		super(a);
	}
	
	public SonofBoo(int i,int j){
		super("man",j);
	}
	
	public SonofBoo(int i,int x,int y){
		super("star",i);
	}
}
