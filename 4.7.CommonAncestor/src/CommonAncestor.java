
public class CommonAncestor {
	private class Ret {
		Node ancestor;
		int flag;
	}
	
	public Node commonAncestorRoot(Node root, Node n1, Node n2) {
		Ret ret = commonAncestor(root, n1, n2);
		if(ret == null || ret.flag < 2)
			return null;
		return ret.ancestor;
	}
	
	private Ret commonAncestor(Node root, Node n1, Node n2) {
		Ret ret = new Ret();
		ret.ancestor = root;
		ret.flag = 0;
		
		if(root == null)
			return null;
		if(root == n1) {
			Ret left = commonAncestor(root.left, n1, n2);
			if(left != null && left.ancestor == n2) {
				ret.flag = 2;
				return ret;
			}
			Ret right = commonAncestor(root.right, n1, n2);
			if(right != null && right.ancestor == n2) {
				ret.flag = 2;
				return ret;
			}
			ret.flag = 1;
			return ret;
		}
		else if(root == n2) {
			Ret left = commonAncestor(root.left, n1, n2);
			if(left != null && left.ancestor == n1) {
				ret.flag = 2;
				return ret;
			}
			Ret right = commonAncestor(root.right, n1, n2);
			if(right != null && right.ancestor == n1) {
				ret.flag = 2;
				return ret;
			}
			ret.flag = 1;
			return ret;
		}

		Ret left = commonAncestor(root.left, n1, n2);
		if(left != null && left.flag == 2)
			return left;
		
		Ret right = commonAncestor(root.right, n1, n2);
		if(right != null && right.flag == 2)
			return right;
		
		if(left != null && right != null) {
			left.ancestor = root;
			left.flag = 2;
			return left;
		}
		if(left != null)
			return left;
		if(right != null)
			return right;
		
		return null;
	}
	
	public static void main(String[] args) {
		CommonAncestor ob = new CommonAncestor();
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
		
		BTreePrinter.printNode(root);
		System.out.println(n24.data + " " + n31.data + " " + commonAncestorRoot(root, n24, n31).data);
		System.out.println(n24.data + " " + n36.data + " " + commonAncestorRoot(root, n24, n36).data);
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
		System.out.println(n23.data + " " + n33.data + " " + commonAncestorRoot(root, n23, n33).data);
		System.out.println(n12.data + " " + "51 " + commonAncestorRoot(root, n12, new Node(51)));
	}
}
