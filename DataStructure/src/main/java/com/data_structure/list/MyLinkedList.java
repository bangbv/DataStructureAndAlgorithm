package com.data_structure.list;

import java.util.HashSet;

public class MyLinkedList {

	Node insert(Node head, int data) {
		Node headNode = head;
		Node newNode = new Node();
		newNode.next = null;
		newNode.data = data;
		if (head == null) {
			head = newNode;
			headNode = head;
		} else if (head.next == null) {
			head.next = newNode;
			head = head.next;
		} else {
			while (head.next != null) {
				// System.out.println(head.data);
				head = head.next;
			}
			head.next = newNode;
			head = head.next;
		}
		return headNode;
	}

	Node InsertNth(Node head, int data, int position) {
		int c_p = 1;
		Node newNode = new Node();
		newNode.data = data;
		newNode.next = null;
		Node newHead = new Node();
		newHead = head;
		if (position == 0) {
			newNode.next = head;
			newHead = newNode;
			return newHead;
		}
		while (head != null) {
			if (c_p == position) {
				Node temp = new Node();
				temp = head.next;
				head.next = newNode;
				newNode.next = temp;
				return newHead;
			}
			head = head.next;
			c_p++;
		}
		return newHead;
	}

	Node Delete(Node head, int position) {
		// Complete this method
		int i = 0;
		Node previous_node = new Node();
		Node current_node = new Node();
		current_node = head;
		while (current_node != null) {
			if (position == 0) {
				current_node.next = current_node.next;
				return head;
			}
			if (i == position) {
				previous_node.next = current_node.next;
				return head;
			}
			previous_node = current_node;
			current_node = current_node.next;
			i++;
		}
		return head;
	}

	void ReversePrint(Node head) {
		Node temp = null;
		Node newHead = null;
		while (head != null) {
			if (newHead == null) {
				newHead = head;
				newHead.next = null;
			} else {
				temp = head;
				temp.next = newHead;
				newHead.next = temp;
			}
			head = head.next;
		}
		while (newHead != null) {
			System.out.println(newHead.data);
			newHead = newHead.next;
		}

	}

	Node mergeLists(Node headA, Node headB) {
		// This is a "method-only" submission.
		// You only need to complete this method
		Node newHead = null;
		Node newNode = null;
		while (headA != null && headB != null) {
			while ((headA != null && headB != null) && (headA.data < headB.data)) {
				if (newHead == null) {
					newNode = new Node();
					newNode.data = headA.data;
					newHead = newNode;
				} else {
					while (newNode.next != null) {
						newNode = newNode.next;
					}
					newNode.next = new Node();
					newNode = newNode.next;
					newNode.data = headA.data;
				}
				headA = headA.next;
			}
			while ((headA != null && headB != null) && (headA.data > headB.data)) {
				if (newHead == null) {
					newNode = new Node();
					newNode.data = headB.data;
					newHead = newNode;
				} else {
					while (newNode.next != null) {
						newNode = newNode.next;
					}
					newNode.next = new Node();
					newNode = newNode.next;
					newNode.data = headB.data;
				}
				headB = headB.next;
			}
		}
		while (headA != null) {
			if (newHead == null) {
				newNode = new Node();
				newNode.data = headA.data;
				newHead = newNode;
			} else {
				newNode.next = new Node();
				newNode = newNode.next;
				newNode.data = headA.data;
			}
			headA = headA.next;
		}
		while (headB != null) {
			if (newHead == null) {
				newNode = new Node();
				newNode.data = headB.data;
				newHead = newNode;
			} else {
				newNode.next = new Node();
				newNode = newNode.next;
				newNode.data = headB.data;
			}
			headB = headB.next;
		}
		return newHead;
	}

	int GetNode(Node head, int n) {
		int length = 0;
		Node tempHead = head;
		int i = 1;
		while (tempHead != null) {
			length += 1;
			tempHead = tempHead.next;
		}
		int r_l = length - n;
		tempHead = head;
		while (i < r_l) {
			i++;
			tempHead = tempHead.next;
		}
		System.out.println("head:" + head.data);
		System.out.println("length:" + length);
		System.out.println("revered_length:" + r_l);
		System.out.println("result:" + tempHead.data);
		return tempHead.data;
	}

	Node RemoveDuplicates(Node head) {
		Node tempHead = head;
		Node previous = null;
		while(tempHead != null) {
			while(previous != null && previous.data == tempHead.data) {
				tempHead = tempHead.next;
				if(tempHead == null) {
					previous.next = tempHead;
					return head;
				}else if(previous.data != tempHead.data) {
					previous.next = tempHead;
				}
			}
			previous  = tempHead;
			if(tempHead != null) {
				tempHead = tempHead.next;
			}
		}
		return head;
	}
	
	boolean hasCycle(Node head) {
		Node current = head;
		Node previous  = null;
		Node next  = null;
		while(current != null) {
			previous = current;
			current = current.next;
			if(current != null) {
				next = current.next;
			}
			if(previous == next) {
				return true;
			}
		}
		return false;
	}
	boolean hasCycle2(Node head) {
        Node slow_p = head, fast_p = head;
        while (slow_p != null && fast_p != null && fast_p.next != null) {
            slow_p = slow_p.next;
            fast_p = fast_p.next.next;
            if (slow_p == fast_p) {
                return true;
            }
        }
        return false;
	}
	boolean hasCycle3(Node head) {
        HashSet<Node> s = new HashSet<Node>();
        while (head != null)
        {
            if (s.contains(head))
                return true;
            s.add(head);
            head = head.next;
        }
        return false;
}
	
	int FindMergeNode(Node headA, Node headB) {
	    // Complete this function
	    // Do not write the main method. 
	    while(headA != null){
	        while(headB != null){
	            if(headA == headB){
	                return headA.data;
	            }
	            headB = headB.next;
	        }
	        headA = headA.next;
	    }
	    return -1;
	}
	
	Node SortedInsert(Node head,int data) {
	    Node temp = head;
	    Node newNode = new Node();
	    newNode.data = data;
	    if(head == null) {
	    		head = newNode;
	    		return head;
	    }
	    if(head.data > data) {
	    		newNode.next = head;
	    		head = newNode;
	    		return head;
	    }
	    while(temp.next != null && temp.next.data < data){
	        temp = temp.next;
	    }
	    if(temp.next != null){
	        newNode.next = temp.next;
	        temp.next = newNode;
	    }else{
	        temp.next = newNode;
	    }
	    
	    return head;
	}
}
