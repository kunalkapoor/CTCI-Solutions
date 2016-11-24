import java.util.ArrayList;
import java.util.Stack;

public class SetOfStacks {
	public static final int THRESHOLD = 2;
	ArrayList<Stack<Integer>> stacks;
	int currIndex, currSize;

	public SetOfStacks() {
		stacks = new ArrayList<Stack<Integer>>();
		stacks.add(new Stack<Integer>());
		currIndex = currSize = 0;
	}

	void push(int data) {
		stacks.get(currIndex).push(data);
		currSize++;

		if (currSize >= THRESHOLD) {
			currIndex++;
			stacks.add(new Stack<Integer>());
			currSize = 0;
		}
	}

	int pop() throws Exception {
		if (stacks.get(currIndex).isEmpty()) {
			if (currIndex == 0)
				throw new Exception("Stack is empty");
			stacks.remove(currIndex--);
			currSize = THRESHOLD;
		}

		currSize--;
		return stacks.get(currIndex).pop();
	}

	int peek() throws Exception {
		if (stacks.get(currIndex).isEmpty()) {
			if (currIndex == 0)
				throw new Exception("Stack is empty");
			return stacks.get(currIndex - 1).peek();
		}
		return stacks.get(currIndex).peek();
	}
	
	public static void main(String[] args) throws Exception {
		SetOfStacks stack = new SetOfStacks();
		stack.push(0);
		stack.push(1);
		stack.push(2);
		System.out.println(stack.peek());
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		stack.push(7);
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		
	}
}