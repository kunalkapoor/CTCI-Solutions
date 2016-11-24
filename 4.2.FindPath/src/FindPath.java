import java.util.ArrayList;
import java.util.LinkedList;

public class FindPath {
	boolean doesPathExist(Node n1, Node n2) {
		LinkedList<Node> queue = new LinkedList<Node>(); 
		
		queue.add(n1);
		n1.visited = true;
		while (!queue.isEmpty()) {
			Node n = queue.remove();
			if (n.data == n2.data)
				return true;
			ArrayList<Node> children = n.children;
			for (int i = 0; children != null && i < children.size(); i++) {
				if(!children.get(i).visited) {
					queue.add(children.get(i));
					children.get(i).visited = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		FindPath ob = new FindPath();
		ob.test1();
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

		addChildren(root, n11);
		addChildren(root, n12);

		addChildren(n11, n21);
		addChildren(n11, n22);
		addChildren(n11, n23);
		addChildren(n11, n24);
		addChildren(n11, n12);
		addChildren(n12, n24);
		addChildren(n21, n22);
		
		addChildren(n31, n32);
		addChildren(n32, n33);
		addChildren(n31, n33);
		addChildren(n32, n34);
		addChildren(n33, n35);
		addChildren(n34, n36);
		addChildren(n35, n37);
		addChildren(n35, n38);
		addChildren(n31, n35);
		addChildren(n37, n38);
		
		System.out.println(doesPathExist(root, n24));
		System.out.println(doesPathExist(root, n38));
	}

	void addChildren(Node n1, Node n2) {
		n1.children.add(n2);
		n2.children.add(n1);
	}
}
