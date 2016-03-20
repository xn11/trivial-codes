package ch3;

//ö������

public class LinkedListItr {
	ListNode current;

	LinkedListItr(ListNode theNode) {
		current = theNode;
	}

	public boolean isPastEnd() {
		return current == null;
	}

	public Item retrieve() {
		return isPastEnd() ? null : current.data;
	}

	public void advance() {
		if (!isPastEnd())
			current = current.next;
	}
}
