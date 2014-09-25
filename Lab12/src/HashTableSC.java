import java.util.LinkedList;


public class HashTableSC<T> {
	private LinkedList<T>[] lists;
	
	public HashTableSC(int size) {
		lists = (LinkedList<T>[]) new LinkedList[size];
		for(int i = 0; i < size; i++) {
			lists[i] = new LinkedList<T>();
		}
	}
	
	private int hash(T object) {
		return object.hashCode() % lists.length;
	}
	
	public void insert(T object) {
		lists[hash(object)].add(object);
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
			for(int j = lists[i].size() - 1; j >= 0; j--) {
				System.out.print(lists[i].get(j) + " ");
			}
			System.out.println();
		}
	}
}
