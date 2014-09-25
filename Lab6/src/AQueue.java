
public class AQueue<T> {
	T[] arr;
	int front, end, count;

	public AQueue(int size) {
		end = -1;
		front = count = 0;
		arr = (T[]) new Object[size];
	}

	public static class MyException extends RuntimeException {
		public MyException() {
			super();
		}

		public MyException(String message) {
			super(message);
		}
	}

	public boolean isEmpty() {
		return count == 0;
	}

	public void enqueue(T newItem) {
		if(count == arr.length) {
			T[] biggerArray = (T[]) new Object[arr.length * 2];

			if(front <= end) {
				for(int i = front; i <= end; i++) {
					biggerArray[i - front] = arr[i];
				}
			} else {
				for(int i = front; i < arr.length; i++) {
					biggerArray[i - front] = arr[i];
				}
				
				for(int i = 0; i <= end; i++) {
					biggerArray[i + arr.length - front] = arr[i];
				}
			}

			arr = biggerArray;
			front = 0;
			end = count - 1;
		}

		end++;
		if(end == arr.length) end -= arr.length;

		arr[end] = newItem;
		count++;
	}

	public T dequeue() {
		if(count == 0) throw new MyException("Empty Array!");

		T temp = arr[front];
		arr[front] = null;

		front++;

		if(front == arr.length) front -= arr.length;

		count--;

		return temp;
	}

	public void printArray() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
}
