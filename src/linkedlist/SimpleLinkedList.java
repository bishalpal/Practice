package linkedlist;

class Node {
	 int value;
	public Node next;
	
	Node(int a) {
		this.value = a;
	}

}

public class SimpleLinkedList {
	// TRAVERSE
	public static void traverse(Node head) {
		// Time - O(n)
		// Space - O(1)
		System.out.print("The elements of the linked list are : ");
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	
	public static void recursiveTraversal(Node head) {	
		// Time - O(n)
		// Space - O(n)...due to function call stack
		if(head == null)
			return;
		System.out.print(head.value + " ");
		recursiveTraversal(head.next);
	}
	
	
	// SEARCH            Time - O(n)
	public static int searchIterative(Node head, int key) {
		// Space - O(1)
		int pos = 1;
		while(head != null) {
			if(head.value == key)
				return pos;
			else {
				head = head.next;
				pos++;
			}
		}
		return -1;		// did not find the element.
	}
	
	public static int searchRecursive(Node head, int key) {
		// Space - O(n)....we will have n+1 function calls in the function call stack 
		if(head == null)
			return -1;
		if(head.value == key)
			return 1;
		// now we check if the key is present in the remaining linked list or not
		else {
			int result = searchRecursive(head.next, key);
			if(result == -1) 
				return -1;
			else 
				return result+1;
		}
		
	}

	
	
	// INSERT AT BEGINNING OF LINKED LIST			Time - O(1)
	public static Node insertAtBegin(Node head, int key) {
		Node temp = new Node(key);
		temp.next = head;
		return temp;
	}
		
	// INSERT AT END OF LINKED LIST
	public static Node insertAtEnd(Node head, int key) {
		Node trav = head;
		Node temp = new Node(key);
		if(head == null)
			return temp;
		
		while(trav.next != null) {
			trav = trav.next;
		}
		trav.next = temp;
		
		return head;
	}
	
	
	
	// DELETE FIRST NODE			TIME - O(1)
	// we don't need to worry about memory deallocation
	public static Node deleteHead(Node head) {
		if(head == null) {
			System.out.println("No linkedlist present");
			return head;
		}
		
		
		return head.next;
	}
	
	// DELETE LAST NODE				TIME - Theta(n)
	public static Node deleteLastNode(Node head) {
		if(head == null)
			return head;
		if(head.next == null)
			return null;
		
		Node curr = head;
		while(curr.next.next != null) {
			curr = curr.next;
		}
		curr.next = null;
		
		return head;
	}
	
	
	// INSERT AT GIVEN POSTION		TIME - Theta(n)
	public static Node insertAtGivenPosition(Node head, int n, int key) {
		Node temp = new Node(key);
		if(head == null)
			return null;
		
		// if position is 1, then
		if(n == 1) {
			temp.next = head;
			return temp;
		}
		
		// check list size and then insert the element if possible.
		int listSize = 1;
		Node curr = head;
		
		while(curr != null) {
			listSize++;
			curr = curr.next;
		}
		
		if(n > listSize + 1) {
			System.out.println("Can't insert at position " + n + " because of insufficient elements in list");
			return head;
		}
		else {
			int i = 0; 
			curr = head;
			for(i = 0; i<n-2; i++) {
				curr = curr.next;
			}
			temp.next = curr.next;
			curr.next = temp;
		}
		
		return head;
	}
	
	
	public static Node sortedInsert(Node head, int key) {
		Node temp = new Node(key);
		
		// case 1 : the given linked list is empty
		if(head == null)
			return temp;
		
		// case 2 : if the value to be inserted is smaller than the smallest element in the linked list
		if(head.value > key) {
			temp.next = head;
			return temp;
		}
		
		// case 3 : insert the element at correct position
		Node curr = head;
		while(curr.next !=null && key > curr.next.value) {
			curr = curr.next;
		}
		temp.next = curr.next;
		curr.next = temp;
			
		
		return head;
	}
	
	
	// PRINT MIDDLE ELEMENT OF LINKED LIST
	public static void printMiddleElement(Node head) {
		if(head == null) {
			System.out.println(" ");
			return;
		}
		int length = 0;
		Node curr = head;
		while(curr != null) {
			length++;
			curr = curr.next;
		}
		curr = head;

		for(int i = 0; i<length/2; i++) {
			curr = curr.next;
		}
		System.out.println();
		System.out.print("Middle element value : ");
		System.out.println(curr.value);		
	}
	
	// we can print the middle element in 1 traversal only - using slow & fast references
	public static void printMiddleEfficient(Node head) {
		Node slow, fast;
		if(head == null) {
			System.out.println("No middle element");
			return;
		}
		
		// both the references start from the first element of the linked list.
		// slow moves 1 elment at a time, whle fast moves 2 elements at a time.
		// in case of even element, fast points to null and slow points to the middle element
		// in case of odd element, fast points to last element and slow points to middle element
		
		slow = fast = head;
		while(fast != null && fast.next!=null ) {
			slow = slow.next;
			fast = fast.next.next;
		}
		System.out.println("Middle element is : "+ slow.value);
		
	}
	
	
	// N'th NODE FROM END OF LINKED LIST 
	// can be done in 2 ways -
	// method 1 - find the length of the linked list
	// method 2 - two pointer approach	
	public static void printNth(Node head, int n) {		// 2 pointer approach
		/*			ALGO
		 * take 2 references of Node type - first and second.
		 * step 1 - start the first at n positions from start of LL.
		 * step 2 - start the second from start of LL.
		 * step 3 - now move both the references 1 position at a time ahead. When first == null, then 
		 * 			second reaches our required element. Print the element pointed by second.
		 * */
		if(head == null)
			return;
		Node first, second;
		first = second = head;
		for(int i = 0; i<n; i++) {
			if(first == null) return;			// in the case when n is more than the number of elements in LL
			first = first.next;
		}
		while(first!=null) {
			second = second.next;
			first = first.next;
		}
		System.out.println();
		System.out.print("The "+ n+"th element from the end of the linked list is " + second.value);
		
	}
	
	
	// REVERSE LL  (iterative method)
	// naive way - traverse the LL, copy the values in arraylist. Now copy the elements of the arraylist to LL in
	// reverse order. 		TIME - O(n), Space - O(n)
	
	// efficient solution - change the links rather than changing the data of the nodes.
	// Time - O(n), Space - O(1)
	public static Node reverseIterative(Node head) {
		
		Node prev, curr, next;
		if(head == null)
			return null;
		if(head.next == null)
			return head;
		
		curr = head;
		prev = null;
		
		while(curr !=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
						
		return prev;
	}
	
	// REVERSE LL (Recursive methods - I, II)	
	
	public static Node reverseRecursiveMethod1(Node head) {
		/*
		 * Assume that from the 2nd node till the last node, the LL is reversed. 
		 * restHead points to the last element of the LL which represents the "head" of the reversed LL
		 * restTail points to the 2nd node of the LL which represents the "tail" of the reversed LL.
		 * 
		 * so to join the 1st node of the LL to the reversed LL, see line number 303
		 * and finally we return the head of the reversed LL i.e. restHead.
		 * */
		if(head == null || head.next == null)
			return head;
		
		Node restHead = reverseRecursiveMethod1(head.next);
		Node restTail = head.next;
		restTail.next = head;
		head.next = null;
		
		return restHead;
	}
	
	public static Node reverseRecursiveMethod2(Node curr, Node prev) {
		/*
		 * we do the reverse of Method I
		 * Here we assume that the LL has been reversed upto (n-1)th node. We need to reverse the nth node.
		 * For this, we need 2 references -> current (the nth node) and previous (the (n-1)th node)
		 * The implementation is similar to the iterative reverse function.
		 * */
		
		if(curr == null)
			return prev;
		Node next = curr.next;
		curr.next = prev;
		return reverseRecursiveMethod2(next, curr);
	}
	
	
	// REMOVE DUPLICATES FROM SORTED LL
	public static Node removeDuplicates(Node head) {
		Node curr = head;
		while(curr != null && curr.next != null) {
			if(curr.value == curr.next.value)
				curr.next = curr.next.next;
			else
				curr = curr.next;
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		Node head = null;
		head = insertAtEnd(head, 1);
		head = insertAtEnd(head, 2);
		head = insertAtEnd(head, 4);
		head = insertAtEnd(head, 5);
		head = insertAtGivenPosition(head, 5, 6);
		head = insertAtEnd(head, 7);
		traverse(head);
		head = sortedInsert(head, 3);
		System.out.println();
		traverse(head);
		//printNth(head, 5);
		//head = reverseIterative(head);
		head = reverseRecursiveMethod2(head, null);
		System.out.println();
		traverse(head);
		
		
		
		
		
	}

}
