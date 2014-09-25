import java.util.Scanner;


public class LQueueDriver {
	public static void main(String[] args) {
		LQueue<Integer> myQueue = new LQueue<Integer>();
		
		Scanner scanman = new Scanner(System.in);

		System.out.println("Choose one of the following operations:");
		System.out.println("- Enqueue/add (enter the letter a)");
		System.out.println("- Dequeue/delete (enter the letter d)");
		System.out.println("- Check if the list is empty (enter the letter e)");
		System.out.println("- Quit (enter the letter q)");
		
		String input;
		do {
			input = scanman.nextLine();
			char i = input.charAt(0);
			
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
				catch(LQueue.MyException e) {
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
