
public class MinStack {
	Node top;
	Node minTop;

	void push(int data) {
		Node n = new Node(data);
		n.next = top;
		top = n;

		if (minTop == null || minTop.data > data) {
			Node n2 = new Node(data);
			n2.next = minTop;
			minTop = n2;
		}
	}

	int pop() throws Exception {
		if (top == null)
			throw new Exception("Stack is empty");
		int data = top.data;
		top = top.next;
		if (minTop.data == data)
			minTop = minTop.next;
		return data;
	}

	int min() throws Exception {
		if (minTop == null)
			throw new Exception("Stack is empty");
		return minTop.data;
	}
	
	public static void main(String[] args) throws Exception {
		MinStack stack = new MinStack();
		stack.push(5);
		System.out.println(stack.min());
		stack.push(8);
		System.out.println(stack.min());
		stack.push(4);
		System.out.println(stack.min());
		stack.pop();
		System.out.println(stack.min());
	}
}
