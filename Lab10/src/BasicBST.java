
public class BasicBST {
	private class BSTNode {
		public int element;
		public BSTNode left, right;
		public BSTNode(int element) {
			this.element = element;
		}
	}

	private BSTNode root;

	public BasicBST() {
		root = null;
	}

	public void insert(int element) {
		if(root == null) {
			root = new BSTNode(element);
		} else {
			insertUnder(element, root);
		}
	}

	private void insertUnder(int element, BSTNode node) {
		if(element < node.element) {
			if(node.left == null) {
				node.left = new BSTNode(element);
			} else {
				insertUnder(element, node.left);
			}
		} else {
			if(node.right == null) {
				node.right = new BSTNode(element);
			} else {
				insertUnder(element, node.right);
			}
		}
	}
	
	public int countOdds() {
		return countOdds(root);
	}
	
	private int countOdds(BSTNode node) {
		if(node == null) return 0;
		
		int result = node.element % 2;
	
		return result + countOdds(node.left) + countOdds(node.right);
	}
	
	public int height() {
		return height(root) - 1;
	}
	
	private int height(BSTNode node) {
		if(node == null) return 0;
		
		return Math.max(height(node.left), height(node.right)) + 1;
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}
	
	private int countLeaves(BSTNode node) {
		if(node == null) return 0;
		
		if(node.left == null && node.right == null) return 1;
		
		return countLeaves(node.left) + countLeaves(node.right);
	}
	
	public int countOneChildParents() {
		return countOneChildParents(root);
	}
	
	private int countOneChildParents(BSTNode node) {
		if(node == null) return 0;
		
		int result = 0;
		
		if(node.left == null ^ node.right == null) result = 1;
		
		return result + countOneChildParents(node.left) + countOneChildParents(node.right);
	}

	
}