package com.ms;

/**
 * 
 * @author Mohan
 * 
1. k should be from 1 - 9
2. adjacent nodes swap
3. k is before middle
4. k is after middle
5. k is first node of linked list


 *
 */

public class SwapKthNode {

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6,7,8,9};
		Node head = null;
		for(int i= arr.length - 1 ; i >= 0; i--) {
			head = new Node(arr[i], head);
		}
		System.out.println("**Before swap");
		printList(head);
		swap(head, 3, arr.length);
		System.out.println("**After swap");
		printList(head);
		
	}
	public static void printList(Node head) {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + " ->");
			ptr = ptr.next;
		}
		System.out.println("");
	}
	
	public static int length(Node head) {
		int count = 1;
		Node n = head;
		while(n.next != null) {
			n = n.next;
			count++;
		}
		return count;
	}
	public static Node swap (Node head, int num, int k) {
		if(num == 1) {
			System.out.println("Only one element. No need to swap.");
		}
		if(k < 1 || k > num) {
			System.out.println("Invalid k: "+k);
			return null;
		}
		
		if(2*k -1 == num) {
			System.out.println("No need to swap. same node from both ends");
		}
		
		//kth node from beginning for list
		Node x = head;
		Node prevX = null;
		for(int i=1;i<k;i++) {
			prevX = x;
			x = x.next;
		}
		
		//kth node from end of list
		
		Node y = head;
		Node prevY = null;
		for(int i=1;i < num-k+1;i++) {
			prevY = y;
			y = y.next;
		}
		
		if(prevX != null) {
			prevX.next = y;
		}
		if(prevY != null) {
			prevY.next = x;
		}
		
		Node temp = x.next;
		x.next = y.next;
		y.next = temp;
		
		if(k == 1) {
			head = y;
		}
		if(k == num) {
			head = x;
		}
		return head;
	}
}
class Node {
	int data;
	Node next;
	
	Node(int data, Node next){
		this.data = data;
		this.next = next;
	}
	
	Node () {}
}
