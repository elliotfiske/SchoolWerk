
public class AStack <T> {

	private Object[] arr;
	private int top;

	public static class MyException extends RuntimeException {
		public MyException() {
			super();
		}

		public MyException(String message) {
			super(message);
		}
	}

	public AStack(int size) {
		arr = (T[]) new Object[size];
		top = -1;
	}

	public void push(T newValue) {
		if(top == arr.length - 1) {
			T[] biggerArray = (T[]) new Object[arr.length * 2];

			for(int i = 0; i < arr.length; i++) {
				biggerArray[i] = (T) arr[i];
			}

			arr = biggerArray;
		}

		arr[++top] = newValue;
	}

	public T pop() {
		T result = peek();
		top--;
		return result;
	}

	public T peek() {
		if(isEmpty()) {
			throw new MyException("Array was empty!");
		}
		return (T) arr[top];
	}

	public boolean isEmpty() {
		return top == -1;
	}

}
