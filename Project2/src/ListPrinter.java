import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class ListPrinter reads a file and prints the students from the list.
 * 
 * @author Thomas Steinke, Elliot Fiske
 *
 */

public class ListPrinter {

	public static void main(String[] args) {
		/** This scanner reads the file that the student data is stored in. */
		Scanner scanin = new Scanner(System.in);
		/** This heap stores all the student information. */
		BinHeap<Student> studentHeap = new BinHeap<Student>();

		//This regex pattern recognizes a student ID number followed by a name.
		Pattern recordPattern = Pattern.compile("([1-9][0-9]*) +([A-z]+)");
		Matcher recordMatcher = null;
		
		//Prompt the user
		System.out.print("WHERE ARE THE FILES STORED? (type your answer) ");

		/** This scanner takes in the file input to be processed. */
		Scanner fileScanner;
		while(true) {
			try {
				fileScanner = new Scanner(new File(scanin.nextLine()));
				break;
			} catch (FileNotFoundException e) {
				System.out.println("The file was not there! Try again!");
				System.out.print("WHERE ARE THE FILES STORED? (type your answer) ");
			}
		}

		while(fileScanner.hasNext()) {
			//Examine each line in the file using our regular expression
			recordMatcher = recordPattern.matcher(fileScanner.nextLine());
			
			if(recordMatcher.matches()) {
				//There are two backreferences from the regular expression;
				//The first is the student ID
				long id = Long.parseLong(recordMatcher.group(1));
				//And the second is the student's last name.
				String name = recordMatcher.group(2);
				studentHeap.insert(new Student(id, name));
			}
		}
		
		System.out.println("Student List:");
		
		//Print out each of the students from least to greatest by popping them each from the heap.
		while(!studentHeap.isEmpty()) {
			System.out.println(studentHeap.deleteMin());
		}
		
		//Ensure there's no memory leaks
		scanin.close();
	}
}
