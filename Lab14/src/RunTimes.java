
public class RunTimes {

	public static void main(String[] args) {
		long beforeTime, afterTime;
		
		Algorithms.logarithmicAlgTime(0);
		
		System.out.println("Logarithmic algorithm's running times:");
		
		for(long N = 10000; N <= 100000000; N *= 2) {
			beforeTime = System.nanoTime() / 1000000;
			Algorithms.logarithmicAlgTime(N);
			afterTime = System.nanoTime() / 1000000;
			
			System.out.println("T(" + N + ") = " + (afterTime - beforeTime));
		}
		
		System.out.println("\nLinear algorithm's running times: ");

		for(long N = 10000; N <= 100000000; N *= 2) {
			beforeTime = System.nanoTime() / 1000000;
			Algorithms.linearAlgTime(N);
			afterTime = System.nanoTime() / 1000000;
			
			System.out.println("T(" + N + ") = " + (afterTime - beforeTime));
		}

		
		System.out.println("\nNLogN algorithm's running times: ");

		for(long N = 10000; N <= 100000000; N *= 2) {
			beforeTime = System.nanoTime() / 1000000;
			Algorithms.NlogNAlgTime(N);
			afterTime = System.nanoTime() / 1000000;
			
			System.out.println("T(" + N + ") = " + (afterTime - beforeTime));
		}

		
		System.out.println("\nQuadratic algorithm's running times: ");

		for(long N = 10000; N <= 400000; N *= 2) {
			beforeTime = System.nanoTime() / 1000000;
			Algorithms.quadraticAlgTime(N);
			afterTime = System.nanoTime() / 1000000;
			
			System.out.println("T(" + N + ") = " + (afterTime - beforeTime));
		}
	}

}
