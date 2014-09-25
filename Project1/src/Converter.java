
/****
 * Class Converter provides utilities to convert and evaluate both postfix
 * and infix expressions.
 * 
 * @author Thomas Steinke, Elliot Fiske
 */

public class Converter {
	
	public static String infixToPostfix(String expression) {
		/** If there are multiple spaces in a row, this reduces them all to 1 each. */
		expression = expression.replaceAll(" +", " ");
		/** Stores the infix expression to be evaluated in handy stack format. */
		MyStack<Character> operations = new MyStack<Character>();
		
		/** The resultant postfix expression. */
		String postfix = "";
		/** Stores the raw expression split up by spaces. */
		String[] operands = expression.split(" ");
		
		for(String operand : operands) {
			//Addition and subtraction.
			if(operand.equals("+") || operand.equals("-")) {
				while(!operations.isEmpty() && operations.peek() != '(') {
					postfix += operations.pop() + " ";
				}
				operations.push(operand.charAt(0));
			}
			//Multiplication and division.
			else if(operand.equals("*") || operand.equals("/")) {
				if(!operations.isEmpty() && operations.peek() != '(' && (operations.peek() == '*' || operations.peek() == '/')) {
					postfix += operations.pop() + " ";
				}
				operations.push(operand.charAt(0));
			}
			//Handle parentheses.
			else if(operand.equals("(")) {
				operations.push(operand.charAt(0));
			}
			else if(operand.equals(")")) {
				while(operations.peek() != '(') {
					postfix += operations.pop() + " ";
				}
				operations.pop();
			}
			//Handles numbers and other variable expressions.
			else {
				postfix += operand + " ";
			}
		}

		//This handles the possibility that a single number or expression was entered.
		if(operations.isEmpty()) {
			return postfix;
		}
		
		while(!operations.isEmpty()) {
			//The remaining operations should be added to the end of the postfix string.
			postfix += operations.pop() + " ";
		}
		return postfix;
	}
	
	public static double postfixValue(String expression) {
		if(expression.equals("")) {
			System.out.println("Empty expression entered.");
			return 0;
		}
		
		/** Stores the doubles to evaluated as part of the postfix expression. */
		MyStack<Double> doubleStack = new MyStack<Double>();
		/** Stores the postfix values divided by spaces. */
		String[] operands = expression.split(" ");
		for(String operand : operands) {
			//To evaluate each operand, pop the last two numeric values and perform
			//the correct operation on them.  Then push the result back to the stack.
			if(operand.charAt(0) == '+') {
				Double sum = doubleStack.pop() + doubleStack.pop();
				doubleStack.push(sum);
			}
			else if(operand.charAt(0) == '-') {
				Double num1 = doubleStack.pop();
				Double num2 = doubleStack.pop();
				Double difference = num2 - num1;
				doubleStack.push(difference);
			}
			else if(operand.charAt(0) == '*') {
				Double product = doubleStack.pop() * doubleStack.pop();
				doubleStack.push(product);
			}
			else if(operand.charAt(0) == '/') {
				Double num1 = doubleStack.pop();
				Double num2 = doubleStack.pop();
				Double quotient = num2 / num1;
				doubleStack.push(quotient);
			}
			else {
				//Must be a number. Push it to the stack.
				doubleStack.push(Double.parseDouble(operand));
			}
		}
		
		if(doubleStack.isEmpty()) {
			System.out.println("Empty expression entered.");
			return 0;
		}
		
		return doubleStack.pop();
	}
}
