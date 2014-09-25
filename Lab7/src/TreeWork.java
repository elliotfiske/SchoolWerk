
public class TreeWork {
	
	public static <T extends Comparable<? super T>> boolean isHeap(T[] arr, int n) {
		int i = 0;

		while(i*2 + 1 <= n - 1) {
			//Check the LEFT child
			if(arr[i*2 + 1].compareTo(arr[i]) < 0) {
				return false;
			}
			
			//Check the RIGHT child. Note that it first checks that the right child doesn't
			//exceed the boundaries of the array.
			if(i*2 + 2 < n - 1 && arr[i*2 + 2].compareTo(arr[i]) < 0) {
				return false;
			}
			
			i++;
		}
		
		return true;
	}
	
	public static <T> void printTree(T[] arr, int n) {
		//Line counter starts at 1, then multiplies by 2 each time a new line is
		//needed. For instance, the first line will have 1 element, then second will
		//have 2 elements, the third will have 4 elements, etc.
		int nextLine = 1;
		int lineCounter = 1;
		
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
			
			if(nextLine == lineCounter) {
				System.out.println();
				lineCounter *= 2;
				nextLine = 0;
			}
			nextLine++;
		}
	}
}
