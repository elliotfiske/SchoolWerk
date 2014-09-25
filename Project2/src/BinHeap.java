
/****
 * Class BinHeap provides an implementation of a binary heap.
 * 
 * @author Thomas Steinke, Elliot Fiske
 *
 * @param <T> The type of data that will be stored in this heap.
 */

public class BinHeap <T extends Comparable<? super T>> {
	/****
	 * MyException is thrown if the dequeue method is called when
	 * the heap is empty.
	 */
	public static class MyException extends RuntimeException {
		public MyException() {
			super();
		}
		
		public MyException(String message) {
			super(message);
		}
	}

	/** How many elements the heap has in it */
	private int size;
	/** The elements of the heap */
	private T[] array;
	
	/** Initialize a binary heap with a default size of 100
	 * @pre None
	 * @post None
	 */
	public BinHeap() {
		this(100);
	}
	
	/** Initialize a binary heap with the specified intial size.
	 * @pre Size should be greater than zero
	 * @post None */
	public BinHeap(int size) {
		array = (T[]) new Comparable[size];
		size = 0;
	}
	
	/**
	 * Inserts a new element into the heap.
	 * @param element The new element to go into the heap.
	 * @pre None
	 * @post None
	 */
	public void insert(T element) {
		//If the array is full, double its size and copy the old elements to the new,
		//bigger array
		if(size == array.length) {
			/** A new array, double the length of our old one. */
			T[] biggerArray = (T[]) new Comparable[array.length * 2];

			for(int i = 0; i < array.length; i++) {
				biggerArray[i] = (T) array[i];
			}

			//Set the class member to the new, bigger array.
			array = biggerArray;
		}
		
		int hole = size;
		array[size++] = element;
		
		//While the hole is not at the root and the parent node is smaller than the
		//hole's associated element
		while(hole >= 0 && array[(hole - 1) / 2].compareTo(array[hole]) > 0) {
			//Switch the element at hole with its parent
			T temp = array[(hole - 1) / 2];
			array[(hole - 1) / 2] = array[hole];
			array[hole] = temp;
			
			//Move the hole up
			hole = (hole - 1) / 2;
		}
	}
	
	/**
	 * Pops the top element of the heap and returns it
	 * @return The former top element of the heap
	 * @pre The heap is not empty
	 * @post None
	 */
	public T deleteMin() {
		if(size == 0) throw new MyException("The heap was empty!");
		
		//Store the root to return it later
		T result = array[0];
		
		int hole = 0;
		
		T lastElement = array[size - 1];
		
		size--;
		
		int newHole = newHole(hole, lastElement);
		
		while(newHole >= 0) {
			array[hole] = array[newHole];
			hole = newHole;
			newHole = newHole(hole, lastElement);
		}
		
		array[hole] = lastElement;
		
		return result;
	}
	
	/**
	 * This is a helper method that determines where the "hole" should go after removing an element.
	 * @param hole The location of the "hole" in the heap.
	 * @param item The current last element of the heap that needs a new home.
	 * @return The next iteration of where the hole should be.
	 */
	private int newHole(int hole, T item) {
		/** This variable stores the result - the new hole that will continue down the heap. */
		int newHole = -1;

		if(size > hole * 2) {
			if(size < hole * 2 + 2) {
				//The node has no RIGHT child. Check just the left child.
				if(array[hole * 2 + 1].compareTo(item) < 0) {
					newHole = hole * 2 + 1;
				}
			} else {
				//The node has both children. Choose the one that's fewer.
				int favoriteChild = hole * 2 + 1;
				if(array[hole * 2 + 1].compareTo(array[hole * 2 + 2]) > 0) {
					favoriteChild++;
				}
				
				if(array[favoriteChild].compareTo(item) < 0) {
					newHole = favoriteChild;
				}
			}
		}
	
		return newHole;
	}
	
	/**
	 * Determines whether the heap is empty or not.
	 * @return True if the heap is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return size == 0;
	}
	
	/**
	 * Returns how large the heap is.
	 * @return How many elements are in the heap.
	 */
	public int size() {
		return size;
	}

	/**
	 * Turns the heap into a printable string, with a space separating each element.
	 */
	@Override
	public String toString() {
		/** Stores the result of the toString method */
		String result = "";
		for(int i = 0; i < size; i++) {
			result += array[i] + " ";
		}
		
		return result;
	}
}
