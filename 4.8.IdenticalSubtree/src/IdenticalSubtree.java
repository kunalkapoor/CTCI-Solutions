
public class IdenticalSubtree {
	private boolean areTreesIdentical(Node n1, Node n2) {
		if(n1 == null && n2 == null)
			return true;
		if(n1 == null || n2 == null)
			return false;

		if(n1.data != n2.data || !areTreesIdentical(n1.left, n2.left) || !areTreesIdentical(n1.right, n2.right))
			return false;
		return true;
	}

	public boolean findIdenticalSubtree(Node n1, Node n2) {
		if(n1 == null || n2 == null)
			return false;

		if(n1.data == n2.data)
			if(areTreesIdentical(n1, n2))
				return true;
		if(findIdenticalSubtree(n1.left, n2) || findIdenticalSubtree(n1.right, n2))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		IdenticalSubtree ob = new IdenticalSubtree();
		ob.test1();
		ob.test2();
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
		
		Node n51 = new Node(3);
		Node n52 = new Node(8);
		Node n53 = new Node(4);
		n51.left = n52;
		n51.right = n53;
		
		BTreePrinter.printNode(root);
		System.out.println(findIdenticalSubtree(root, n51));
		n53.left = new Node(2);
		System.out.println(findIdenticalSubtree(root, n51));
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
		
		Node n51 = new Node(9);
		Node n52 = new Node(4);
		Node n53 = new Node(5);
		n51.left = n52;
		
		BTreePrinter.printNode(root);
		System.out.println(findIdenticalSubtree(root, n51));
		n51.right = n53;
		System.out.println(findIdenticalSubtree(root, n51));
	}
}
