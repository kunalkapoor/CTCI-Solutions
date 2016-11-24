public class CheckBST {
	public boolean isBinarySearchTree(Node root) {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBinarySearchTree(Node root, Integer min, Integer max) {
		if(root == null)
			return true;
		
		if(root.data <= min || root.data > max)
			return false;
		
		int minval, maxval;
		minval = (min > root.data)? min : root.data;
		maxval = (max < root.data)? max : root.data;
		
		if(!isBinarySearchTree(root.left, min, maxval))
			return false;
		if(!isBinarySearchTree(root.right, minval, max))
			return false;
		
		return true;
	}

	public static void main(String[] args) {
		CheckBST ob = new CheckBST();
		ob.test1();
		ob.test2();
		ob.test3();
		ob.test4();
	}

	void test1() {
		Node root = new Node(2);
		Node n11 = new Node(7);
		Node n12 = new Node(5);
		Node n21 = new Node(2);
		Node n22 = new Node(6);
		Node n23 = new Node(3);
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
		System.out.println(isBinarySearchTree(root));
	}

	void test2() {
		Node root = new Node(2);
		Node n11 = new Node(7);
		Node n12 = new Node(5);
		Node n21 = new Node(2);
		Node n22 = new Node(6);
		Node n23 = new Node(9);
		Node n31 = new Node(5);
		Node n32 = new Node(8);
		Node n33 = new Node(4);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;

		n12.right = n23;
		n22.left = n31;
		n22.right = n32;

		n23.left = n33;

		BTreePrinter.printNode(root);
		System.out.println(isBinarySearchTree(root));
	}

	void test3() {
		Node root = new Node(5);
		Node n11 = new Node(3);
		Node n12 = new Node(7);
		Node n21 = new Node(1);
		Node n22 = new Node(4);
		Node n23 = new Node(9);
		Node n31 = new Node(3);
		Node n32 = new Node(8);
		Node n33 = new Node(6);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;

		n12.right = n23;
		n22.left = n31;
		n22.right = n32;

		n23.left = n33;

		BTreePrinter.printNode(root);
		System.out.println(isBinarySearchTree(root));
	}
	
	void test4() {
		Node root = new Node(7);
		Node n11 = new Node(3);
		Node n12 = new Node(8);
		Node n21 = new Node(1);
		Node n22 = new Node(5);
		Node n23 = new Node(10);
		Node n31 = new Node(4);
		Node n32 = new Node(6);
		Node n33 = new Node(9);

		root.left = n11;
		root.right = n12;

		n11.left = n21;
		n11.right = n22;

		n12.right = n23;
		n22.left = n31;
		n22.right = n32;

		n23.left = n33;

		BTreePrinter.printNode(root);
		System.out.println(isBinarySearchTree(root));
	}
}
