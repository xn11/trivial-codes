package ch3;

//������

public class LinkedList {
	private ListNode header;

	public LinkedList() {
		header = new ListNode();
	}
// �ж��Ƿ�Ϊ��
	public boolean isEmpty() {
		return header.next == null;
	}
// �ÿ�
	public void makeEmpty() {
		header.next = null;
	}
// ���ر�ͷ
	public LinkedListItr zeroth() {
		return new LinkedListItr(header);
	}
// ���ص�һ���ڵ�
	public LinkedListItr first() {
		return new LinkedListItr(header.next);
	}
// ����Ŀ��ڵ�
	public LinkedListItr find(Item x) {
		ListNode itr = header.next;
		while (itr != null && !itr.data.equals(x))
			itr = itr.next;
		return new LinkedListItr(itr);
	}
// ɾ���ڵ�
	public void remove(Item x) {
		LinkedListItr p = findPrevious(x);
		if (p.current.next != null)
			p.current.next = p.current.next.next;
//		else
//			p.current.next=null;
	}
// ����Ŀ��ڵ��ǰһ���ڵ�
	public LinkedListItr findPrevious(Item x) {
		ListNode itr = header;
		while (itr.next != null && !itr.next.data.equals(x))
			itr = itr.next;
		return new LinkedListItr(itr);
	}
// ����ڵ�
	public void insert(Item x, LinkedListItr p) {
		if (p != null && p.current != null)
			p.current.next = new ListNode(x, p.current.next);
	}
	
	public void end(){
		LinkedListItr p=this.zeroth();
		while(p.current.next!=null){
			p.advance();
		}
		ListNode n=null;
		p.current.next=n;
	}
	
// ��ʾ����
	public static void printList(LinkedList theList) {
		if (theList.isEmpty())
			System.out.println("Empty list.");
		else {
			LinkedListItr itr = theList.first();
			for (; !itr.isPastEnd(); itr.advance())
				System.out.print(itr.retrieve().show() + "  ");
		}

		System.out.println();
	}
}
