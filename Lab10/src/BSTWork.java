import java.util.Scanner;


public class BSTWork {

	public static void main(String[] args) {

		BasicBST myBST = new BasicBST();

		Scanner scanman = new Scanner(System.in);

		System.out.println("Available operations:");
		System.out.println("- Add (enter the letter a)");
		System.out.println("- Count Odds (enter the letter o)");
		System.out.println("- Height (enter the letter h)");
		System.out.println("- Leaves (enter the letter l)");
		System.out.println("- One-Child nodes (enter the letter c)");
		
		System.out.println("- Quit (enter the letter q)");

		String input;
		do {
			System.out.print("\nPlease enter a command: ");
			input = scanman.nextLine();
			char i = input.charAt(0);
			System.out.print(" " + i);

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
					myBST.insert(myInt);
					System.out.print(" " + myInt);
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'o':
				System.out.println("Number of odds: " + myBST.countOdds());
				break;
			case 'h':
				System.out.println("Height: " + myBST.height());
				break;
			case 'l':
				System.out.println("Number of leaves: " + myBST.countLeaves());
				break;
			case 'c':
				System.out.println("Number of one-child parents: " + myBST.countOneChildParents());
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
