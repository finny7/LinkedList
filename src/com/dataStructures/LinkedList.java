package com.dataStructures;

public class LinkedList {

	// CREATE CLASS VARIABLES, NODE CLASS, AND CONSTRUCTOR HERE //
	// //
	// //
	// //
	// //
	//////////////////////////////////////////////////////////////

	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		public Node(int value) {
			this.value = value;
		}
	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}
	
	public void printList() {
		Node temp = head;
		while(temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}

	/*public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.println(temp.value);
			temp = temp.next;
		}
	}
*/
	public void getHead() {
		if (head == null) {
			System.out.println("Head: null");
		} else {
			System.out.println("Head: " + head.value);
		}
	}

	public void getTail() {
		if (head == null) {
			System.out.println("Tail: null");
		} else {
			System.out.println("Tail: " + tail.value);
		}
	}

	public void getLength() {
		System.out.println("Length: " + length);
	}

	
	
	public void append(int value) {
		Node node = new Node(value);
		if(length == 0) {
			head = node;
			tail = node;
		}else {
			tail.next = node;
			tail = node;
		}
		length++;
	}
	
	public Node removeLast() {
		
		if(length == 0) {
			return null;
		}
		
		Node temp = head;
		Node pre = head;
		
		while(temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		
		tail = pre;
		tail.next = null;
		length--;
		
		if(length == 0) {
			head = null;
			tail = null;
		}
		
		return temp;		
	}
	
	public void prepend(int value) {
		Node node = new Node(value);
	
		if(length == 0) {
			head = node;
			tail = node;
		}
		else {
			node.next = head;
			head = node;
		}
		
		length++;
	}
	
	public Node removeFirst() {
		
		if(length == 0) {
			
			return null;
		}
		
		Node temp = head;
		
		head = head.next;
		
		temp.next = null;
		 
		length--;
		if(length == 0) {
			tail = null;
		}
		
		return temp;
	}
	
	public Node get(int index) throws Exception {
		
		if(index >= 0 && index <=length) {
			int i = 0;
			Node temp = head;
			while(i < index) {

				temp = temp.next;
				i++;
			}
			return temp;
		}else {
			throw new Exception("index out of bound exception");
			
		}
	}
	
	public boolean set(int index, int value) {
		if(index >= 0 && index <=length) {
			int i = 0;
			Node temp = head;
			while(i < index) {
				if (i == (index -1)){
					temp.value = value;
					return true;
				}
				temp = temp.next;
				i++;
			}
			temp.value = value;
			return true;
		}
		return false;
	}
	
	public boolean insert(int index, int value) throws Exception {
		
		if(index < 0 || index > length) {
			return false;
		}
		
		if( index == 0) {
			prepend(value);
			return true;
		}
		
		if(index == length) {
			append(value);
			return true;
		}
		
		Node newNode = new Node(value);
		Node preNode = get(index - 1);
		
		newNode.next = preNode.next;
		preNode.next = newNode;
		length++;
		return true;
	}
	
	public Node remove(int index) throws Exception {
		
		if(index < 0 || index > length) {
			return null;
		}
		
		if(index == 0) {
			return removeFirst();
		}
		
		if(index == length) {
			return removeLast();
		}
		
		Node node = get(index);
		
		Node preNode = get(index - 1);
		
		preNode.next = node.next;
		length--;
		return node;
	}
	
	
	/*public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		Node before = null;
		Node after = temp.next;
		
		for(int i = 0;i < length; i++) {
			after = temp.next;
			
			temp.next = before;
			before = temp;
			temp = after;
		}
	}*/
	
	public void reverse() {
		Node temp = head;
		head = tail;
		tail = head;
		Node after = temp.next;
		Node before = null;
		for(int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}
	
	public Node findMiddleNode() {
		
		Node middleNode = null;
		Node temp = head;
		
		if(length == 0) {
			return null;
		}
		
		if (length == 1 || length == 2) {
			return head;
		}
		
		for(int i = 0; i < (Math.ceil((double)length/2)); i++) {
			
			middleNode = temp;
			temp = temp.next;
		}
		return middleNode;
	}
}


