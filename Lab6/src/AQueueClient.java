import java.util.Scanner;


public class AQueueClient {
	public static void main(String[] args) {
		Scanner scanin = new Scanner(System.in);
		
		AQueue<Float> myQueue = new AQueue<Float>(5);
		
		while(scanin.hasNext()) {
			if(scanin.hasNextFloat()) {
				myQueue.enqueue(scanin.nextFloat());
			} else {
				//Ignore non-ints
				scanin.next();
			}
		}
		
		while(!myQueue.isEmpty()) System.out.print(myQueue.dequeue() +" ");
	}
}
