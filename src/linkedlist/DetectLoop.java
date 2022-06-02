package linkedlist;
import java.util.HashSet;

public class DetectLoop {
	
	public static void traverse(Node head) {
		System.out.print("Linked List now : ");
		while(head != null) {
			System.out.print(head.value + " ");
			head  = head.next;
		}
		System.out.println();
	}
	
	/*approach 1 - requires modification in the structure of linked list. 
	 * Need to add a new attribute - boolean visited
	 * Time - O(n)
	 * */
	
	/*approach 2 - modifies the linked list references....We can't get the original LL back.
	 * Time - O(n), Space - O(1)
	 * we take a dummy node 'temp'. After visiting each node, we change it's next pointer to 'temp'.
	 * Now if there is a cycle, then we will find a node which has it's next pointer already pointing to 'temp'
	 * Then we can say that there is a cycle in the LL. Else we don't
	 * */
	
	/*
	 * Approach 3 - use hashing
	 * Time - O(n), Space - O(n)
	 * we can store the addresses of the node we visit in a hashset, and check if the current node is already 
	 * present in hashset. If it is present, then return true, else add the address of the current node to the hashset
	 * */
	
	
	/*
	 * Approach 4 - change the value of the visited node. The value NEEDS TO BE OUTSIDE THE RANGE OF THE LL.
	 * Time - O(n), Space - O(1)
	 * on visiting a node change its value to 'k'. Before changing the node's value, check if value == k
	 * If true, then LL contains loop. Else no loops.
	 * */
	
	public static boolean approach2(Node head) {
		if(head == null)
			return false;
		
		Node curr, next;
		Node temp = new Node(0);
		curr =  head;
		next = null;
		
		while(curr != null) {
			
			if(curr.next == temp)
				return true;
			if(curr.next == null)
				return false;
				
			next = curr.next;
			curr.next = temp;
			curr = next;
		}
		
		return false;
	}
	
	public static boolean approach3(Node head) {
		if(head == null)
			return false;
		HashSet<Node> hs = new HashSet<>();
		while(head != null) {
			if(hs.contains(head))
				return true;
			hs.add(head);
			head = head.next;
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

		System.out.println("Does the LL contain a loop ?\nAnswer : " +approach3(head));
		
	}

}
