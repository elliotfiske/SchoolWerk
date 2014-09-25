import java.util.Scanner;


public class AStackDriver {
	public static void main(String[] args) {
		AStack<Integer> myStack = new AStack<Integer>(5);

		Scanner scanman = new Scanner(System.in);

		System.out.println("Choose one of the following operations:");
		System.out.println("- Add/push (enter the letter a)");
		System.out.println("- Delete/pop (enter the letter d)");
		System.out.println("- Peek (enter the letter p)");
		System.out.println("- Check if the list is empty (enter the letter e)");
		System.out.println("- Quit (enter the letter q)");

		String input;
		do {
			input = scanman.nextLine();
			char i = input.charAt(0);

			// Interpret the input
			switch(i) {
			case 'a':
				System.out.println("What Integer should I add?");
				if(scanman.hasNextInt()) {
					Integer myInt = scanman.nextInt();
					myStack.push(myInt);
					System.out.println(myInt + " added to stack");
				}
				else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'd':
				try {
					System.out.println(myStack.pop() + " popped");
				}
				catch(AStack.MyException e) {
					System.out.println("The list was empty! ;_;");
				}
				break;
			case 'p':
				try {
					System.out.println("Value at top: " + myStack.peek());
				}
				catch(AStack.MyException e) {
					System.out.println("The list was empty! ;_;");
				}
				break;
			case 'e':
				if(myStack.isEmpty()) {
					System.out.println("The list is empty!");
				}
				else {
					System.out.println("The list is NOT empty!");
				}
				break;
			case 'q':
				System.out.println("Quitting");
				break;
			case 'h':
				System.out.println("Choose one of the following operations:");
				System.out.println("- Enqueue/add (enter the letter a)");
				System.out.println("- Dequeue/delete (enter the letter d)");
				System.out.println("- Check if the list is empty (enter the letter e)");
				System.out.println("- Quit (enter the letter q)");
				break;
			default:
				System.out.println("Invalid character. ");
				break;
			}
		} while(!input.equals("q"));

		if(myStack.isEmpty()) return;
		System.out.print("The rest: ");
		while(!myStack.isEmpty()) System.out.print(myStack.pop() +" ");
		System.out.println();
	}
}
