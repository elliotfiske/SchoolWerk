import java.util.Scanner;


public class BSTWork {

	public static void main(String[] args) {

		MyList myList = new MyList();

		Scanner scanman = new Scanner(System.in);

		System.out.println("Available operations:");
		System.out.println("- Add (enter the letter a)");
		System.out.println("- Find (enter the letter f)");
		System.out.println("- Print the array (enter the letter p)");
		System.out.println("- Sum (enter the letter s)");
		
		System.out.println("- Quit (enter the letter q)");

		String input;
		do {
			System.out.print("\nPlease enter a command: ");
			input = scanman.nextLine();
			char i = input.charAt(0);

			if(input.length() != 1) { 
				System.out.println("Invalid character selection");
				continue;
			}

			// Interpret the input
			switch(i) {
			case 'a':
				System.out.print("What Integer should I add? ");
				if(scanman.hasNextInt()) {
					Integer myInt = scanman.nextInt();
					myList.add(myInt);
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'f':
				System.out.print("What Integer should I find? ");
				if(scanman.hasNextInt()) {
					Integer myInt = scanman.nextInt();
					System.out.println(myInt + " was " + (myList.find(myInt) ? "" : "NOT ") + "found in the list.");
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'q':
				System.out.println("Quitting");
				break;
			case 'p':
				myList.print();
				break;
			case 's':
				System.out.println("The sum of all the elements in the array is: " + myList.sum());
				break;
			default:
				System.out.println("Invalid character. ");
				break;
			}
		} while(!input.equals("q"));
		System.out.println("Done!");
	}
}
