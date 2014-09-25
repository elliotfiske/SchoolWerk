import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;


public class MyHashTable<T> {
	private LinkedList<T>[] lists;
	
	public MyHashTable(int size) {
		lists = (LinkedList<T>[]) new LinkedList[size];
		for(int i = 0; i < size; i++) {
			lists[i] = new LinkedList<T>();
		}
	}
	
	private int hash(T object) {
		return object.hashCode() % lists.length;
	}
	
	public void insert(T object) {
		lists[hash(object)].add(0, object);
	}
	
	public void delete(T object) {
		lists[hash(object)].remove(object);
	}
	
	public boolean find(T object) {
		return lists[hash(object)].contains(object);
	}
	
	public boolean isEmpty() {
		for(LinkedList<T> list : lists) {
			if(!(list.size() == 0)) return false;
		}
		
		return true;
	}
	
	public void print() {
		for(int i = 0; i < lists.length; i++) {
			System.out.print(i + ": ");
			for(T item : lists[i]) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}
	
	public void makeEmpty() {
		for(LinkedList<T> list : lists) {
			list.clear();
		}
	}
	
	public int size() {
		int result = 0;
		for(LinkedList<T> list : lists) {
			result += list.size();
		}
		return result;
	}
	
	private class Iter implements Iterator<T> {

		private int i, j;
		
		public Iter() {
			j = 0;
			for(i = 0; i <= lists.length; i++) {
				if(i == lists.length || lists[i].size() > 0) break;
			}
		}
		
		@Override
		public boolean hasNext() {
			return i < lists.length;
		}

		@Override
		public T next() {
			if(!hasNext()) throw new NoSuchElementException();
			T temp = lists[i].get(j);
			if(j == lists[i].size() - 1) {
				j = 0;
				for(i++; i <= lists.length; i++) {
					if(i == lists.length || lists[i].size() > 0) break;
				}
			} else {
				j++;
			}
			return temp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	public Iterator<T> iterator() {
		return new Iter();
	}
	
}
