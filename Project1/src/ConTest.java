import java.util.Scanner;

/****
 * Class Connection Test provides a user-interface for the various functions of the
 * Converter class.
 * @author Thomas Steinke, Elliot Fiske
 */

public class ConTest {
	public static void main(String[] args) {
		/** Scanner for user input */
		Scanner in = new Scanner(System.in);
		
		System.out.println("Choose one of the following operations:");
		System.out.println("	- Infix to postfix conversion (enter the letter i)");
		System.out.println("	- Postfix expression evaluation (enter the letter p)");
		System.out.println("	- Arithmetic expression evaluation (enter the letter a)");
		System.out.println("	- Quit the program (enter the letter q)");

		/** Stores the character menu selection */
		String input;
		/** Stores the current mathematical expression to process */
		String expr;
		do {
			System.out.print("Enter command: ");
			input = in.nextLine();
			
			switch(input.charAt(0)) {
			case 'i':
				System.out.print("Enter infix expression: ");
				expr = in.nextLine();
				System.out.println("The postfix expression is: " + Converter.infixToPostfix(expr));
				break;
			case 'p':
				System.out.print("Enter postfix expression: ");
				expr = in.nextLine();
				System.out.println("The value of the postfix expression is: " + Converter.postfixValue(expr));
				break;
			case 'a':
				System.out.print("Enter infix expression: ");
				expr = in.nextLine();
				expr = Converter.infixToPostfix(expr);
				System.out.println("The value of the arithmetic expression is: " + Converter.postfixValue(expr));
				break;
			case 'q':
				//The while loop at the bottom exists if 'q' is the current input
				break;
			default:
				System.out.println("Invalid command");
				break;
			}
		} while(input.charAt(0) != 'q');

		in.close();
		System.out.println("Done!");
	}
}