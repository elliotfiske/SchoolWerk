import java.util.Iterator;
import java.util.Scanner;


public class MyHashTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner scanman = new Scanner(System.in);
		int size = 0;
		
		System.out.print("What size should the hash table be? ");
		
		while(scanman.hasNext()) {
			if(scanman.hasNextInt()) {
				size = scanman.nextInt();
				System.out.println(size);
				break;
			} else {
				System.out.println("That's no integer...");
				scanman.next();
			}
		}
		
		scanman.nextLine();
		
		MyHashTable<Integer> haaash = new MyHashTable<Integer>(size);

		System.out.println("Available operations:");
		System.out.println("- Add (enter the letter a)");
		System.out.println("- Find (enter the letter f)");
		System.out.println("- Delete (enter the letter d)");
		System.out.println("- Is the hash table empty? (enter the letter e)");
		System.out.println("- Print the contents of the hash (enter the letter p)");
		System.out.println("- Empty the table (enter the letter k)");
		System.out.println("- Get the table size (enter the letter s)");
		System.out.println("- Output the collection (enter the letter o)");
		
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
					haaash.insert(myInt);
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
					haaash.delete(myInt);
					System.out.println(myInt + " was deleted.");
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'f':
				System.out.print("What Integer should I find? ");
				if(scanman.hasNextInt()) {
					Integer myInt = scanman.nextInt();
					System.out.println(myInt);
					System.out.println("The list does " + (haaash.find(myInt) ? "" : "NOT ") + "contain " + myInt);
				} else {
					System.out.println("That's no integer....");
				}
				scanman.nextLine();
				break;
			case 'e':
				System.out.println("The list is " + (haaash.isEmpty() ? "" : "NOT ") + "empty.");
				break;
			case 'p':
				haaash.print();
				break;
			case 'q':
				System.out.println("Quitting");
				break;
			case 'k':
				haaash.makeEmpty();
				break;
			case 's':
				System.out.println("The list has " + haaash.size() + " element" + (haaash.size() == 1 ? "" : "s"));
				break;
			case 'o':
				Iterator<Integer> iterman = haaash.iterator();
				while(iterman.hasNext()) System.out.print(iterman.next() + " ");
				break;
			default:
				System.out.println("Invalid character. ");
				break;
			}
		} while(!input.equals("q"));
		System.out.println("Done!");

	}

}
