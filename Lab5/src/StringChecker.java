import java.util.Scanner;


public class StringChecker {

	public static boolean isBalanced(String input) {
		AStack<Character> charStack = new AStack<Character>(input.length());

		//Check each symbol!
		for(Character c : input.toCharArray()) {
			switch(c) {
			case ')':
				if(charStack.isEmpty() || charStack.pop() != '(') return false;
				break;
			case ']':
				if(charStack.isEmpty() || charStack.pop() != '[') return false;
				break;
			case '}':
				if(charStack.isEmpty() || charStack.pop() != '{') return false;
				break;
			case '(':
			case '[':
			case '{':
				charStack.push(c);
				break;
			}
		}

		return charStack.isEmpty();

	}

	public static void main(String[] args) {
		Scanner scannerIn = new Scanner(System.in);
		String input = "";
		while(scannerIn.hasNextLine()) {
			System.out.print("Enter the string to be processed: ");
			input = scannerIn.nextLine();
			System.out.print(input);
			System.out.println("\nThe string is " + (isBalanced(input) ? "" : "NOT ") + "balanced!");
		}
		System.out.println("\nDone!");
	}
}
