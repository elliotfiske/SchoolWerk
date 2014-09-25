import java.util.Scanner;


public class DestTestClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {	
		Scanner scanman = new Scanner(System.in);

		String input;
		boolean done = false;
		do {
			System.out.println("Please enter an integer height or quit (q):");
			
			if (scanman.hasNextInt()) {
				System.out.println("You put" + scanman.nextInt());
			}
			else if (scanman.nextLine().charAt(0) == 'q') {
				done = true;
			}
			else {
				System.out.println("Invalid input");
			}
			
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
			default:
				System.out.println("Invalid character. ");
				break;
			}
		} while(!input.equals("q"));
		System.out.println("Done!");
	}

}

}
