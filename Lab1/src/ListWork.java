import java.util.InputMismatchException;
import java.util.Scanner;


public class ListWork {
	public static <T> boolean search(T[] arr, T target) {
		//Search the list for "target" and return true if it's found
		for(T t : arr) {
			if(t == target) {
				return true;
			}
		}

		//Couldn't find "target." return false
		return false;
	}

	public static <T> void print(T[] arr) {
		for(T t : arr) {
			System.out.println(t);
		}
	}

	public static void main(String[] args) {
		Integer[] array = new Integer[10];
		Scanner scan = new Scanner(System.in);
		int numInputs = 0;

		System.out.println("Please input 10 integers.");
		while(numInputs < 10) {
			try {
				int input = scan.nextInt();
				array[numInputs] = input;
				numInputs++;
			} catch(InputMismatchException e) {
				//The user input a non-integer. Ignore it and consume the invalid token
				scan.next();
			}
		}

		scan.nextLine();

		while(true) {
			System.out.print("Would you like to search for an element? (y/n) ");
			String input = scan.nextLine();
			if(input.equals("N")||input.equals("n")){
				break;
			}

			System.out.print("What would you like to find? ");
			try {
				int target = scan.nextInt();
				if(search(array, target)) {
					System.out.println(target + " was successfully found.");
				}
				else {
					System.out.println(target + " was not found in the array.");
				}
			} catch(InputMismatchException e) {
				//The user input a non-integer. Ignore it and consume the invalid token
				scan.next();
				System.out.println("please enter an integer");
			}
			scan.nextLine();
		}
		
		print(array);
	}
}
