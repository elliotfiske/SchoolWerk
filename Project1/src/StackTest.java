import java.util.EmptyStackException;
import java.util.Scanner;
  
/****
 * Class StackTest provides a user-interface to the MyStack ADT.
 * 
 * @author Thomas Steinke, Elliot Fiske
 */

public class StackTest {
  
    public static void main(String[] args) {
    	/** The stack to store strings entered by the user. */
        MyStack<String> myStack = new MyStack<String>();
        /** The scanner that grabs user input. */
        Scanner inputScanner = new Scanner(System.in);
          
        System.out.println("Choose one of the following operations:");
        System.out.println("- Add/push (enter the letter a)");
        System.out.println("- Delete/pop (enter the letter d)");
        System.out.println("- Peek (enter the letter p)");
        System.out.println("- Check if the list is empty (enter the letter e)");
        System.out.println("- Quit (enter the letter q)");
        
        /** Holds the last command entered by the user. */
        char i;
        do {
        	System.out.print("Enter an operation character: ");
        	
            i = inputScanner.nextLine().charAt(0);
   
            //Interpret the input.
            switch(i) {
            case 'a':
                System.out.println("What should I add?");
                String newString = inputScanner.next();
                myStack.push(newString);
                System.out.println(newString + " added to stack");
                //Flush the input buffer
                inputScanner.nextLine();
                break;
            case 'd':
                try {
                    System.out.println(myStack.pop() + " popped");
                }
                catch(EmptyStackException e) {
                    System.out.println("The list was empty! ;_;");
                }
                break;
            case 'p':
                try {
                    System.out.println("Value at top: " + myStack.peek());
                }
                catch(EmptyStackException e) {
                    System.out.println("The list was empty! ;_;");
                }
                break;
            case 'e':
                if(myStack.isEmpty()) {
                    System.out.println("The list is empty!");
                }
                else {
                    System.out.println("The list is NOT empty!");
                }
                break;
            case 'q':
                System.out.println("Quitting");
                //If 'q' is the last thing entered, the while loop will return false.
                break;
            default:
                System.out.println("Invalid character. ");
                break;
            }
        } while(i != 'q');
   
        if(myStack.isEmpty()) {
        	//Prevent memory leaks.
        	inputScanner.close();
        	return;
        }
        
        System.out.print("The rest: ");
        while(!myStack.isEmpty()) System.out.print(myStack.pop() +" ");
        System.out.println();
        
        inputScanner.close();
    }
} 