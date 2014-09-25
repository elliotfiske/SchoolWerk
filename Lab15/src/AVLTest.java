import java.util.Iterator;
import java.util.Scanner;


public class AVLTest {


	public static void main(String[] args) {

		BasicAVL myAVL = new BasicAVL();

		Scanner scanman = new Scanner(System.in);

		System.out.println("Available operations:");
		System.out.println("- Add (enter the letter a)");
		System.out.println("- Print (enter the letter p)");
		System.out.println("- Quit (enter the letter q)");

		String input;
		do {
			System.out.print("\nPlease enter a command: ");
			input = scanman.nextLine();
			char i = input.charAt(0);
			System.out.println(" " + i);

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
					myAVL.insert(myInt);
					System.out.println(myInt);
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'p':
				myAVL.print();
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
