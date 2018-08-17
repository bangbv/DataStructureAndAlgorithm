package com.data_structure.list;

public class DLinkedList {
	
	void print(DNode head) {
		
	}
	
	DNode insert(DNode head, int data) {
		DNode temp = head;
		DNode newNode = new DNode();
		newNode.data = data;
		if(temp == null) {
			head = newNode;
		}else {
			while(temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			newNode.prev = temp;
		}
		return head;
	}
	
	DNode Reverse(DNode head) {
	    DNode temp = head;
	    DNode newHead = null;
	    if(temp == null){
	        return head;
	    }
	    while(temp.next != null){
	        temp = temp.next;
	    }
	    newHead = temp;
	    DNode tempNode = null;
	    DNode tempNext = null;
	    DNode tempPrev = null;
	    while(temp != null){
	        tempNode = temp;
	        temp  = temp.prev;
	        tempNext = tempNode.next;
	        tempPrev = tempNode.prev;
	        tempNode.next = tempPrev;
	        tempNode.prev = tempNext;
	    }
	    return newHead;
	}
}
