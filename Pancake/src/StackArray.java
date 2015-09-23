
public class StackArray<T>{
	private T[] data;
	private int top;
	
	@SuppressWarnings("unchecked")
	public StackArray(int n){
		this.data = (T[]) new Object[n];
		this.top = 0;
	}

	public void push(T p) {
		// TODO Auto-generated method stub
		if(!isFull()){
			this.data[this.top] = p;
			this.top++;
		}
	}

	public T pop() {
		// TODO Auto-generated method stub
		if(!isEmpty()){
			T returnT = this.data[top - 1];
			this.top--;
			return returnT;
		}else{
			return null;
		}
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public boolean isFull() {
		return top == data.length;
	}
	
}
