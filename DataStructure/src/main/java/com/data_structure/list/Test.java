package com.data_structure.list;

public class Test {

	public static void main(String[] args) {
//		MyLinkedList l = new MyLinkedList();
//		Node head = null;
//		head = l.SortedInsert(head, 1);
//		head = l.SortedInsert(head, 5);
//		head = l.SortedInsert(head, 4);
/*		Node temp = new Node();
		temp.data = 3;
		Node tempNode = head;
		while(tempNode != null && tempNode.next != null) {
			tempNode = tempNode.next;
		}
		tempNode.next = temp;
		temp.next = tempNode;*/
		//System.out.println("///////");
		//boolean result  = l.hasCycle2(head);
		//System.out.println(result);
		//print(head);
		DLinkedList l = new DLinkedList();
		DNode head = null;
		head = l.insert(head, 2);
		head = l.insert(head, 4);
		head = l.insert(head, 6);
		head = l.Reverse(head);
		print(head);
	}
	
//	static void print(Node head) {
//		while(head != null) {
//			System.out.println(head.data);
//			head =head.next;
//		}
//	}
	
	static void print(DNode head) {
		while(head != null) {
			System.out.println(head.data);
			head =head.next;
		}
	}
}