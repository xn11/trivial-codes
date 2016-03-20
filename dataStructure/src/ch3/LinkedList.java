package ch3;

//链表类

public class LinkedList {
	private ListNode header;

	public LinkedList() {
		header = new ListNode();
	}
// 判断是否为空
	public boolean isEmpty() {
		return header.next == null;
	}
// 置空
	public void makeEmpty() {
		header.next = null;
	}
// 返回表头
	public LinkedListItr zeroth() {
		return new LinkedListItr(header);
	}
// 返回第一个节点
	public LinkedListItr first() {
		return new LinkedListItr(header.next);
	}
// 返回目标节点
	public LinkedListItr find(Item x) {
		ListNode itr = header.next;
		while (itr != null && !itr.data.equals(x))
			itr = itr.next;
		return new LinkedListItr(itr);
	}
// 删除节点
	public void remove(Item x) {
		LinkedListItr p = findPrevious(x);
		if (p.current.next != null)
			p.current.next = p.current.next.next;
//		else
//			p.current.next=null;
	}
// 返回目标节点的前一个节点
	public LinkedListItr findPrevious(Item x) {
		ListNode itr = header;
		while (itr.next != null && !itr.next.data.equals(x))
			itr = itr.next;
		return new LinkedListItr(itr);
	}
// 插入节点
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
	
// 显示链表
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
