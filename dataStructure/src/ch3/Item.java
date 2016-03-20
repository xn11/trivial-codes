package ch3;

//数据条目类

public class Item {
	double coef;
	int exp;
	int no;

	public Item() {
	}

	public Item(double coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}
	
	public Item(int no){
		this.no=no;
	}
	
	public String show(){
		if(no!=0){
			return no+"";
		}
		return null;
	}
}
