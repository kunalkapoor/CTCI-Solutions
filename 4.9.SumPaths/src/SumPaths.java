
public class SumPaths {
	public void printPaths(Node root, int sum) {
		if(root == null)
			return;
		String path = "";
		printPaths(root, sum, 0, path);
		printPaths(root.left, sum);
		printPaths(root.right, sum);
	}

	private void printPaths(Node root, int sum, int sumUntilNow, String path) {
		if(root == null)
			return;
		
		String currentPath = path + root.data + " ";

		int currentSum = sumUntilNow;
		currentSum += root.data;

		if (currentSum == sum)
			System.out.println(currentPath);
		printPaths(root.left, sum, currentSum, currentPath);
		printPaths(root.right, sum, currentSum, currentPath);
	}

	public static void main(String[] args) {
		SumPaths ob = new SumPaths();
		ob.test1();
		ob.test2();
	}

	void test1() {
		Node root = new Node(2);
		Node n11 = new Node(7);
		Node n12 = new Node(5);
		Node n21 = new Node(2);
		Node n22 = new Node(6);
		Node n23 = new Node(4);
		Node n24 = new Node(6);
		Node n31 = new Node(5);
		Node n32 = new Node(8);
		Node n33 = new Node(4);
		Node n34 = new Node(5);
		Node n35 = new Node(8);
		Node n36 = new Node(4);
		Node n37 = new Node(5);
		Node n38 = new Node(8);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;
		n12.left = n23;
		n12.right = n24;

		n21.left = n31;
		n21.right = n32;
		n22.left = n33;
		n22.right = n34;
		n23.left = n35;
		n23.right = n36;
		n24.left = n37;
		n24.right = n38;

		BTreePrinter.printNode(root);
		printPaths(root, 9);
		printPaths(root, 10);
	}

	void test2() {
		Node root = new Node(2);
		Node n11 = new Node(7);
		Node n12 = new Node(5);
		Node n21 = new Node(2);
		Node n22 = new Node(7);
		Node n23 = new Node(9);
		Node n31 = new Node(-14);
		Node n32 = new Node(0);
		Node n33 = new Node(-14);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;

		n12.right = n23;
		n22.left = n31;
		n22.right = n32;

		n23.left = n33;

		BTreePrinter.printNode(root);
		printPaths(root, 16);
		printPaths(root, 2);
	}
}
