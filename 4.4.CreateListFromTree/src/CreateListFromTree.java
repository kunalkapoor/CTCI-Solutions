import java.util.ArrayList;
import java.util.LinkedList;

public class CreateListFromTree {
	public ArrayList<LinkedList<Integer>> createList(Node root) {
		ArrayList<LinkedList<Integer>> lists = new ArrayList<>();
		createList(root, lists, 0);
		return lists;
	}
	
	public void createList(Node root, ArrayList<LinkedList<Integer>> lists, int height) {
		if(root == null)
			return;
		
		LinkedList<Integer> list = null;
		if(lists.size() <= height) {
			list = new LinkedList<>();
			lists.add(list);
		}
		else
			list = lists.get(height);
		
		list.add(root.data);
		
		createList(root.left, lists, height + 1);
		createList(root.right, lists, height + 1);
	}
	
	public static void main(String[] args) {
		CreateListFromTree ob = new CreateListFromTree();
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
		ArrayList<LinkedList<Integer>> list = createList(root);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i).toString());
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
		ArrayList<LinkedList<Integer>> list = createList(root);
		for(int i=0; i<list.size(); i++)
			System.out.println(list.get(i).toString());
	}

}
