package linkedlist;

public class FloydCycleDetection {
	/*
	 * Floyd Cycle detection algo
	 * 1. does not modify the linked list in any way
	 * 2. does not take extra space i.e. Space = O(1)
	 * 3. works in O(n) time
	 * 
	 * Algo - 
	 * */
	public static boolean algo(Node head) {
		if(head == null)
			return false;
		Node slow, fast;
		slow = fast = head;
		
		while(fast != null && fast.next != null) {		// need both the conditions.
														// for eg: LL length is 3, 2nd condition occurs
														// for eg: if there is no loop in LL.
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)					// if this condition was written at line 20, then we would always
				return true;					// get 'true' result because initially slow and fast = head.
		}
		
		return false;
	}
	public static void main(String[] args) {
		Node head = new Node(1);
		Node t1 = new Node(2);
		head.next = t1;
		Node t3 = new Node(3);
		t1.next = t3;
		Node t4 = new Node(4);
		t3.next = t4;
		Node t5 = new Node(5);
		t4.next = t5;
		Node t6 = new Node(6);
		t5.next = t6;
		Node t7 = new Node(7);
		t6.next = t7;
		t7.next = t4;			// loop 7 -> 4
		
		System.out.println("");
	}

}
