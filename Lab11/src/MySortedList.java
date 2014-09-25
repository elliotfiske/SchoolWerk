
public class MySortedList {
	private class Node {
		public Node(int item) {
			element = item;
		}
		public int element;
		public Node next;
	}
	
	private Node head;
	
	public MySortedList() {
		head = null;
	}
	
	public void add(int item) {
		Node newNode = new Node(item);
		
		if(head == null) {
			head = newNode;
			return;
		}
		
		if(head.element > item) {
			newNode.next = head;
			head = newNode;
			return;
		}
		
		Node cursor = head;
		while(cursor.next != null && cursor.next.element < item) {
			cursor = cursor.next;
		}
		
		if(cursor.next != null) {
			newNode.next = cursor.next;
		}
		
		cursor.next = newNode;
	}
	
	public void delete(int item) {
		if(head == null) {
			return;
		}
		
		if(head.element == item) {
			head = head.next;
			return;
		}
		
		Node cursor = head;
		
		while(cursor.next != null && cursor.next.element < item) {
			cursor = cursor.next;
		}
		
		if(cursor.next != null && cursor.next.element == item) {
			cursor.next = cursor.next.next;
		}
	}
	
	public int max() {
		Node cursor = head;
		
		while(cursor.next != null) {
			cursor = cursor.next;
		}
		
		return cursor.element;
	}
	
	public int min() {
		return head.element;
	}
	
	public void print() {

		Node cursor = head;
		
		while(cursor != null) {
			System.out.print(cursor.element + " ");
			cursor = cursor.next;
		}
		System.out.println();
	}
	
	public boolean isEmpty() {
		return head == null;	
	}
}
