import java.util.Iterator;
import java.util.Scanner;


public class SeparateAndMerge {

	public static void main(String[] args) {
		LList<Integer> listInt = new LList<Integer>();
		LList<Float> listFloat = new LList<Float>();
		
		Scanner systemIn = new Scanner(System.in);
		System.out.print("Input some values: ");
		
		while(systemIn.hasNext()) {
			if(systemIn.hasNextInt()) {
				listInt.add(systemIn.nextInt());
			} else if (systemIn.hasNextFloat()) {
				listFloat.add(systemIn.nextFloat());
			} else {
				systemIn.next();
			}
		}
		
		Iterator<Integer> iterInt = listInt.iterator();
		Iterator<Float> iterFloat = listFloat.iterator();
		
		System.out.print("Inputted values: ");
		while(iterInt.hasNext() || iterFloat.hasNext()) {
			if(iterInt.hasNext()) {
				System.out.print(iterInt.next() + " ");
			}
			if(iterFloat.hasNext()) {
				System.out.print(iterFloat.next() + " ");
			}
		}
		System.out.println();
	}

}
