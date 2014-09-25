import java.util.Scanner;

/****
 * Class HeapTest provides functionality to test the BinHeap class.
 * 
 * @author Thomas Steinke, Elliot Fiske
 *
 */

public class HeapTest {

	public static void main(String[] args) {
		Scanner scanin = new Scanner(System.in);
		BinHeap<String> myHeap = null;

		System.out.print("What should the initial size of the binary heap be? (type your answer) ");

		while(scanin.hasNext()) {
			if(scanin.hasNextInt()) {
				myHeap = new BinHeap<String>(scanin.nextInt());
				scanin.nextLine();
				break;
			} else {
				System.out.println("That wasn't an Integer! Try again! (type your next try) ");
				//Wipe the non-integer
				scanin.nextLine();
			}
		}

		System.out.println("Available operations:");
		System.out.println("	- add an element (enter the letter a)");
		System.out.println("	- delete the smallest element (enter the letter d)");
		System.out.println("	- is the heap empty (enter the letter e)");
		System.out.println("	- size of the collection (enter the letter s)");
		System.out.println("	- print the collection (enter the letter p)");
		System.out.println("	- Quit (enter the letter q)");

		String input;
		do {
			System.out.print("Please enter a letter: ");
			
			input = scanin.nextLine();

			//Ignore any input that is longer or shorter than 1 character.
			if(input.length() != 1) { 
				System.out.println("Please enter 1 (and only 1) character for your selection.");
				continue;
			}
			
			char i = input.charAt(0);

			// Interpret the input
			switch(i) {
			case 'a':
				System.out.print("Enter something to input to the heap: ");
				input = scanin.nextLine();
				myHeap.insert(input);
				System.out.println(input + " inserted into the heap.");
				break;
			case 'd':
				//This try block verifies that the heap is not empty.
				try {
					System.out.println(myHeap.deleteMin());
				} catch(BinHeap.MyException e) {
					//If the heap is empty, this message will be displayed.
					System.out.println("Invalid operation on an empty heap.");
				}
					break;
			case 'e':
				//This println uses a ternary operator to shorten the code.
				System.out.println("The heap is " + (myHeap.isEmpty() ?  "" : "NOT ") + "empty");
				break;
			case 's':
				System.out.println("The heap has " + myHeap.size() + " elements insiiiiide of it");
				break;
			case 'p':
				System.out.println(myHeap);
				break;
			case 'q':
				System.out.print("QUITTER: ");
				break;
			default:
				System.out.println("Invalid character.");
				break;
			}
			
			//Extra line to make output more readable.
			System.out.println();
	
		} while(!input.equals("q"));

		//Print the remaining contents of the heap.
		while(!myHeap.isEmpty()) System.out.print(myHeap.deleteMin() + " ");
		System.out.println();
		
		//Prevent memory leaks
		scanin.close();
	}
}
