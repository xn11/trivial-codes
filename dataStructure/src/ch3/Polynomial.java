package ch3;

public class Polynomial {

	/**
	 * 多项式相加
	 */
	LinkedList terms; 
	
	public static void main(String[] args) {
		Polynomial a=new Polynomial();
		Polynomial b=new Polynomial();
		LinkedListItr pa=a.terms.zeroth();
		LinkedListItr pb=b.terms.zeroth();
		//a
//		a.terms.insert(new Item(3,3), pa);
//		pa.advance();
//		a.terms.insert(new Item(2,2), pa);
//		pa.advance();
		a.terms.insert(new Item(1,1), pa);
		a.terms.end();
		//b
//		b.terms.insert(new Item(2,2), pb);
//		pb.advance();
		b.terms.insert(new Item(-1,1), pb);
		pb.advance();
//		b.terms.insert(new Item(1,0), pb);
		b.terms.end();
		//show
		a.print();
		b.print();
		a.add(b).print();
	}

	public Polynomial() {
		zeroPolynomial( ); 
	}

//	public void insertTerm(double coef, int exp) {
//		if(terms.isEmpty()){
//			terms.insert(new Item(coef,exp),terms.zeroth() );
//		}else{			
//			for(LinkedListItr p=terms.first();p.isPastEnd();p.advance()){
//				if(p.current.data.exp==exp){
//					p.current.data.coef+=coef;
//					break;
//				}else if(p.current.data.exp<exp){
//					terms.insert(new Item(coef,exp), terms.findPrevious(p.current.data));
//					break;
//				}
//			}
//		}
//	}

	public void zeroPolynomial() {
		terms=new LinkedList();
	}

	public Polynomial add(Polynomial rhs) {
		Polynomial result=new Polynomial();
		LinkedListItr pa=terms.first();
		LinkedListItr pb=rhs.terms.first();
		LinkedListItr pc=result.terms.zeroth();
		while (!pa.isPastEnd()&&!pb.isPastEnd()){
			if (pa.current.data.exp == pb.current.data.exp) {
				pa.current.data.coef += pb.current.data.coef;
				pb.advance();
				if (pa.current.data.coef == 0.0) {
					pa.advance();
				}else{
					pc.current.next=pa.current;
					pc.current=pa.current;
					pa.advance();
				}
			}else if(pa.current.data.exp < pb.current.data.exp){
				pc.current.next=pb.current;
				pc.current=pb.current;
				pb.advance();
			}else{
				pc.current.next=pa.current;
				pc.current=pa.current;
				pa.advance();
			}			
		}
		if(pa.isPastEnd()){
			pc.current.next=pb.current;
		}else{
			pc.current.next=pa.current;
		}
		return result;
	}

//	public Polynomial multiply(Polynomial rhs) {
//		return null;
//	}

	public void print() {
		LinkedListItr p=terms.first();
		if(terms.zeroth().current.next==null){
			System.out.print("0");
		}
		while(!p.isPastEnd()){
			System.out.print(p.current.data.coef+"x^"+p.current.data.exp);
			p.advance();
			if(!p.isPastEnd()){
				System.out.print(" + ");
			}else{
				System.out.println();
				break;
			}
		}
	}

}


