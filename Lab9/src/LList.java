import java.util.Iterator;
import java.util.NoSuchElementException;


public class LList<T> {
	/** The first element of the list. */
	private Node head;
	
	private class Node {
		public T element;
		public Node next;
		public Node(T element, Node next) {
			super();
			this.element = element;
			this.next = next;
		}
	}
	
	private class Iter implements Iterator<T> {
		private Node cursor;
		
		public Iter() {
			cursor = head;
		}

		@Override
		public boolean hasNext() {
			return cursor != null;// && cursor.next != null;
		}

		@Override
		public T next() {
			if(!hasNext()) {
				throw new NoSuchElementException();
			}
			T temp = cursor.element;
			cursor = cursor.next;
			return temp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public LList() {
		head = null;
	}
	
	public Iterator<T> iterator() {
		return new Iter();
	}
	
	public void add(T element) {
		if(head == null) {
			head = new Node(element, null);
		} else {
			Node cursor = head;
			while(cursor.next != null) {
				cursor = cursor.next;
			}
			cursor.next = new Node(element, null);
		}
	}
}
