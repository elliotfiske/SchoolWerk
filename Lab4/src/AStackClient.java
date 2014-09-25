import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class AStackClient {
	public static void main(String[] args) {
		
		Scanner inputScan = new Scanner(System.in);
		System.out.print("Please enter a filename: ");
		String filename = inputScan.nextLine();
		
		File file = new File(filename);
		Scanner fileScan = null;
		try {
			fileScan = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		AStack<Integer> intStack = new AStack<Integer>(5);
		AStack<Float> floatStack = new AStack<Float>(5); 
		AStack<String> stringStack = new AStack<String>(5);
		
		while(fileScan.hasNext()) {
			if(fileScan.hasNextInt()) {
				intStack.push(fileScan.nextInt());
			} else if(fileScan.hasNextFloat()) {
				floatStack.push(fileScan.nextFloat());
			} else {
				stringStack.push(fileScan.next());
			}
		}
		
		System.out.print("Strings entered: ");
		while(!stringStack.isEmpty()) System.out.print(stringStack.pop() +" ");
		System.out.println();
		System.out.print("Floats entered: ");
		while(!floatStack.isEmpty()) System.out.print(floatStack.pop() +" ");
		System.out.println();
		System.out.print("Ints entered: ");
		while(!intStack.isEmpty()) System.out.print(intStack.pop() +" ");
		System.out.println();
	}
}
