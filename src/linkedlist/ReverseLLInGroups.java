package linkedlist;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ReverseLLInGroups {
	/*
	 * Time complexity - O(n), 		Space complexity - O(1)
	 * Algorithm -
	 * 1. if (k <= n), then, the k'th node of the original linked list will be the head of the reversed LL.
	 * 2. we need to reverse groups of LL of size 'k'.
	 * 3. suppose we have reversed a group earlier, now we need to connect the head of the current reversed group 
	 * 	  of LL with the first node of the previously reversed LL. This will complete the connection.
	 * 
	 * */
	
	public static Node reverseInGroups(Node head, int k) {
		Node curr, prevFirst, prev, next, first;	// prevFirst refers to the first node of the previously reversed LL
		curr = head;
		prevFirst = prev = next = null;				// initially these are null
		int count = 0;
		boolean isFirstPass = true;					
		
		while(curr != null) {
			first = curr;							// first refers to the current pass' first node of the LL
			prev = null;							// each new pass will have the prev referring to null initially
			count = 0;
			while(curr!=null && count < k) {
				next = curr.next;
				curr.next = prev;
				prev = curr;
				curr = next;
				count++;
			}
			
			if(isFirstPass) {						// if it is the first pass, then k'th node's prev reference is the
				head = prev;						// head of the reversed LL.
				isFirstPass = false;				// We don't need to this again so set it to false.
			}
			else {									// if it is not the firstPass, then we need to connect the 
				prevFirst.next = prev;				// head of the current reversed group of the LL with the first
													// node of the previous pass' group of LL.
			}
			
			prevFirst = first;						// we make the prevFirst reference point to first so that 
													// the next traversal gets the correct prevFirst reference. 
		}
				
		return head;
	}
	
	public static void traverse(Node head) {
		System.out.print("Linked List now : ");
		while(head != null) {
			System.out.print(head.value + " ");
			head  = head.next;
		}
		System.out.println();
	}
	public static void main(String[] args) throws IOException {
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
		
		int k = 3;
		
		traverse(head);
		head = reverseInGroups(head, k);
		System.out.println("After group reversal : ");
		traverse(head);
		
	}

}
