package ch3;

import java.util.Scanner;

public class Josephus {

	/**
	 * 解约瑟夫问题
	 */
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		System.out.print("Please input n and m(like:5 1): ");
		LinkedList.printList(new Josephus().go(scan.nextInt(), scan.nextInt()));
	}

	public LinkedList go(int n,int m){
		LinkedList l1=new LinkedList();
		LinkedList l2=new LinkedList();
		//initial
		LinkedListItr p1=l1.zeroth();
		LinkedListItr p2=l2.zeroth();
		for(int i=1;i<=n;i++){
			p1.current.next=new ListNode(new Item(i),null);
			p1.advance();
		}
		p1.current.next=l1.first().current;
		//
		p1=l1.zeroth();
		for( int i = 1; i<= n-1; i++){  
			for (int j =1; j<=m-1; j++)  
				p1.advance();		
			p2.current.next=p1.current.next;	
			p1.current.next= p1.current.next.next;			
			p2.advance(); 
          }
		p1.current.next=null;
		p2.current.next=p1.current;
		l2.end();
		return l2;
	}
}
