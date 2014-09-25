import java.util.Iterator;

/****
 * 
 * Class BST implements a Binary Search Tree data structure with a linked list.
 * It provides methods to add, delete, find, and iterate through elements.
 * 
 * @author Thomas Steinke, Elliot Fiske
 *
 * @param <T> The type of element
 */

public class BST <T extends Comparable<? super T>>
{
	/** The root of the entire tree */
	BSTNode root;
	
	/** Class BSTNode contains an element and a pointer to its left child and right child.*/
	private class BSTNode {
		/** The element contained by this node. */
		public T element;
		/** The left and right child of the current node. */
		public BSTNode left, right;
	}
	
	/** Class PreIter provides methods to traverse the tree in preorder. */
	private class PreIter<T> implements Iterator<T> {
		
		/** Returns true if there is an element not yet covered by the iterator,
		 *  false otherwise. */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		
		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}


	/** Class InIter provides methods to traverse the tree in inorder. */
	private class InIter<T> implements Iterator<T> {
		
		/** Returns true if there is an element not yet covered by the iterator,
		 *  false otherwise. */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

	/** Class LevelIter provides methods to traverse the tree in levelorder. */
	private class LevelIter<T> implements Iterator<T> {
		
		/** Returns true if there is an element not yet covered by the iterator,
		 *  false otherwise. */
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	/** 
	 * The insert method puts a new element of type T into the binary search tree.
	 * @param element The new element to be added
	 * @pre element is not null
	 */
	public void insert(T element) {
		if(root == null) {
			root = new BSTNode();
			root.element = element;
		} else {
			insertUnder(element, root);
		}
	}

	/**
	 * Recursive helper method for the insert method.
	 * @param element The current element that is being added
	 * @param node The next node to check against.
	 */
	private void insertUnder(T element, BSTNode node) {
		//If the element is GREATER than the current node we're examining,
		//go to the LEFT side of the tree.
		if(element.compareTo(node.element) > 0) {
			if(node.left == null) {
				node.left = new BSTNode();
				node.left.element = element;
			} else {
				insertUnder(element, node.left);
			}
		//If the element is LESS than the current node we're examining,
		//go to the RIGHT side of the tree.
		} else {
			if(node.right == null) {
				node.right = new BSTNode();
				node.right.element = element;
			} else {
				insertUnder(element, node.right);
			}
		}
	}
	
	/** 
	 * Searches the tree for the specified item then deletes that item.
	 * @param item The element to delete from the tree.
	 */
	public void delete(T item) {
		delete(item, root, true);
	}
	
	private boolean delete(T item, BSTNode node, boolean wentLeft) {
		if(node == null) return false;
		
		if(node.element.equals(item)) {
			
		}
	}
	
	/**
	 * @return True if the tree contains no elements, false if it does contain elements.
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/** Reinitalizes the binary tree by setting the current root to null. */
	public void makeEmpty() {
		root = null;
	}
	
	/** Returns the current number of elements stored in the tree. */
	public int size() {
		return size(root);
	}
	
	/** A private recursive helper method to calculate the size of the tree. */
	private int size(BSTNode node) {
		if(node == null) return 0;
		return 1 + size(node.left) + size(node.right);
	}
}
