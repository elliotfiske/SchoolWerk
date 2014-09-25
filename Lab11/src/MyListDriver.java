import java.util.Scanner;


public class MyListDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MySortedList sortedList = new MySortedList();

		Scanner scanman = new Scanner(System.in);

		System.out.println("Available operations:");
		System.out.println("- Add (enter the letter a)");
		System.out.println("- Delete (enter the letter d)");
		System.out.println("- Find Maximum (enter the letter x)");
		System.out.println("- Find Minimum (enter the letter m)");
		System.out.println("- Print the contents of the list (enter the letter p)");
		System.out.println("- Is the list empty? (enter the letter e)");

		System.out.println("- Quit (enter the letter q)");

		String input;
		do {
			System.out.print("\nPlease enter a command: ");
			input = scanman.nextLine();
			char i = input.charAt(0);
			System.out.println(input);

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
					sortedList.add(myInt);
					System.out.println(myInt);
					System.out.println(myInt + " was added.");
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'd':
				System.out.print("What Integer should I delete? ");
				if(scanman.hasNextInt()) {
					Integer myInt = scanman.nextInt();
					System.out.println(myInt);
					sortedList.delete(myInt);
					System.out.println(myInt + " was deleted.");
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'x':
				if(sortedList.isEmpty()) {
					System.out.println("Error: List is empty!");
				} else {
					System.out.println("List Maximum: " + sortedList.max());
				}
				break;
			case 'm':
				if(sortedList.isEmpty()) {
					System.out.println("Error: List is empty!");
				} else {
					System.out.println("List Minimum: " + sortedList.min());
				}
				break;
			case 'p':
				sortedList.print();
				break;
			case 'e':
				System.out.println("The list is " + (sortedList.isEmpty() ? "" : "NOT ") + "empty.");
				break;
			case 'q':
				System.out.println("Quitting");
				break;
			default:
				System.out.println("Invalid character. ");
				break;
			}
		} while(!input.equals("q"));
		System.out.println("Done!");

	}

}
