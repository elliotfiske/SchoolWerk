import java.util.Scanner;


public class AQueueDriver {
	public static void main(String[] args) {
		AQueue<Integer> myQueue = new AQueue<Integer>(5);

		Scanner scanman = new Scanner(System.in);

		System.out.println("Choose one of the following operations:");
		System.out.println("- Enqueue/add (enter the letter a)");
		System.out.println("- Dequeue/delete (enter the letter d)");
		System.out.println("- Check if the list is empty (enter the letter e)");
		System.out.println("- Print the array (enter the letter p)");
		System.out.println("- Quit (enter the letter q)");

		String input;
		do {
			input = scanman.nextLine();
			char i = input.charAt(0);

			if(input.length() != 1) { 
				System.out.println("Invalid character selection");
				continue;
			}

			// Interpret the input
			switch(i) {
			case 'a':
				System.out.println("What Integer should I add?????");
				if(scanman.hasNextInt()) {
					Integer myInt = scanman.nextInt();
					myQueue.enqueue(myInt);
					System.out.println(myInt+ " enqueued");
				}
				else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'd':
				try {
					System.out.println(myQueue.dequeue()+" dequeued");
				}
				catch(AQueue.MyException e) {
					System.out.println("The list was empty! ;_;");
				}
				break;
			case 'e':
				if(myQueue.isEmpty()) {
					System.out.println("The list is empty!");
				}
				else {
					System.out.println("The list is NOT empty!");
				}
				break;
			case 'q':
				System.out.println("Quitting");
				break;
			case 'p':
				myQueue.printArray();
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

		if(myQueue.isEmpty()) return;
		System.out.print("The rest: ");
		while(!myQueue.isEmpty()) System.out.print(myQueue.dequeue() +" ");
		System.out.println();
	}
}
