package ch3;

//Ã¶¾ÙÆ÷Àà

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
