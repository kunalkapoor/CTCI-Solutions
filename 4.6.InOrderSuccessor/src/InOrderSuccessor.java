
public class InOrderSuccessor {
	public Node inOrderSuccessor(Node node) {
		if(node == null)
			return null;

		if(node.right != null)
			return node.right;
		
		return recurse(node);
	}
	
	private Node recurse(Node node) {
		if(node == null)
			return null;
		if(node.parent == null)
			return null;
		if(node.parent.left == node)
			return node.parent;
		return recurse(node.parent);
	}
	
	public static void main(String[] args) {
		InOrderSuccessor ob = new InOrderSuccessor();
		ob.test1();
		ob.test2();
	}
	
	void test1() {
		Node root = new Node(1);
		Node n11 = new Node(2);
		Node n12 = new Node(3);
		Node n21 = new Node(4);
		Node n22 = new Node(5);
		Node n23 = new Node(6);
		Node n24 = new Node(7);
		Node n31 = new Node(8);
		Node n32 = new Node(9);
		Node n33 = new Node(10);
		Node n34 = new Node(11);
		Node n35 = new Node(12);
		Node n36 = new Node(13);
		Node n37 = new Node(14);
		Node n38 = new Node(15);

		root.left = n11;
		root.right = n12;
		n11.parent = n12.parent = root;

		n11.left = n21;
		n11.right = n22;
		n21.parent = n22.parent = n11;
		n12.left = n23;
		n12.right = n24;
		n23.parent = n24.parent = n12;

		n21.left = n31;
		n21.right = n32;
		n31.parent = n32.parent = n21;
		n22.left = n33;
		n22.right = n34;
		n33.parent = n34.parent = n22;
		n23.left = n35;
		n23.right = n36;
		n35.parent = n36.parent = n23;
		n24.left = n37;
		n24.right = n38;
		n37.parent = n38.parent = n24;
		
		BTreePrinter.printNode(root);
		System.out.println(root.data + " " + inOrderSuccessor(root).data);
		System.out.println(n21.data + " " + inOrderSuccessor(n21).data);
		System.out.println(n33.data + " " + inOrderSuccessor(n33).data);
		System.out.println(n34.data + " " + inOrderSuccessor(n34).data);
		System.out.println(n38.data + " " + inOrderSuccessor(n38));
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
		
//		BTreePrinter.printNode(root);
//		System.out.println(isTreeBalanced(root));
	}
}
