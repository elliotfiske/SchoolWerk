import java.util.Scanner;


public class TreeTest {

	public static void main(String[] args) {
		Integer[] array = new Integer[20];
		int currIndex = 0;
		
		Scanner scanin = new Scanner(System.in);
		
		System.out.println("Enter a binary tree: ");
		
		while(currIndex < 20 && scanin.hasNext()) {
			array[currIndex++] = scanin.nextInt();
		}
		
		if(currIndex == 0) {
			System.out.println("The tree was empty.");
		} else {
			System.out.println("The tree is " + (TreeWork.isHeap(array, currIndex) ? "" : "NOT " ) + "a heap.");
			TreeWork.printTree(array, currIndex);
			System.out.println();
		}
	}
}
