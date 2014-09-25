
public class MyList {
	private Node head;
	
	private class Node {
		public int element;
		public Node next;
		
		public Node(int element, Node next) {
			super();
			this.element = element;
			this.next = next;
		}
	}
	
	public MyList() {
		//New list!
	}
	
	public void add(int newElement) {
		Node newNode = new Node(newElement, null);
		newNode.next = head;
		head = newNode;
	}
	
	public boolean find(int target) {
		return find(target, head);
	}
	
	private boolean find(int target, Node head) {
		if(head == null) return false;
		
		if(head.element == target) return true;
		else return find(target, head.next);
	}
	
	public void print() {
		print(head);
		System.out.println();
	}
	
	private void print(Node head) {
		if(head == null) return;
		
		print(head.next);
		
		System.out.print(head.element + " ");
	}
	
	public int sum() {
		return sum(head);
	}
	
	private int sum(Node head) {
		if(head == null) return 0;
		
		return head.element + sum(head.next);
	}
}
