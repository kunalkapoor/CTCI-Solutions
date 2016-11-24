import java.util.Stack;

public class TowerOfHanoi {
	Stack<Integer> s1, s2, s3;
	int N;

	public TowerOfHanoi(int N) {
		s1 = new Stack<Integer>();
		s2 = new Stack<Integer>();
		s3 = new Stack<Integer>();
		this.N = N;
		for(int i = N; i>0; i--)
			s1.push(i);
	}

	public void move(int source, int dest) throws Exception {
		Stack<Integer> srcStack, destStack, tempStack;
		
		if(source == dest)
			return;

		if(source == 1)
			srcStack = s1;
		else if(source == 2)
			srcStack = s2;
		else
			srcStack = s3;

		if(dest == 1)
			destStack = s1;
		else if(dest == 2)
			destStack = s2;
		else
			destStack = s3;

		if(source + dest == 3)
			tempStack = s3;
		else if(source + dest == 4)
			tempStack = s2;
		else
			tempStack = s1;

		if(srcStack.size() < N)
			throw new Exception("Source stack does not have enough elements to move");

		move(srcStack, destStack, tempStack, N);
	}

	private void move(Stack<Integer> srcStack, Stack<Integer> destStack, Stack<Integer> tempStack, int N) {
		if(N == 1) {
			int data = srcStack.pop();
			destStack.push(data);
			return;
		}

		move(srcStack, tempStack, destStack, N-1);
		move(srcStack, destStack, tempStack, 1);
		move(tempStack, destStack, srcStack, N-1);
	}
	
	public static void main(String[] args) throws Exception {
		TowerOfHanoi toh = new TowerOfHanoi(3);
		System.out.println(toh.s1.toString());
		toh.move(1, 3);
		System.out.println(toh.s1.toString());
		System.out.println(toh.s3.toString());
		toh.move(3, 2);
		System.out.println(toh.s2.toString());
	}
}