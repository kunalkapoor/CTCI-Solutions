
public class CreateBST {
	public Node createBST(int[] sortedArray) {
		return createBST(sortedArray, 0, sortedArray.length-1);
	}

	private Node createBST(int[] sortedArray, int min, int max) {
		if (min > max)
			return null;

		int mid = (min + max) / 2;
		Node left = createBST(sortedArray, min, mid - 1);
		Node right = createBST(sortedArray, mid + 1, max);
		
		Node root = new Node(sortedArray[mid]);
		root.left = left;
		root.right = right;
		return root;
	}
	
	public static void main(String[] args) {
		int a1[] = {1, 2, 3, 4, 5, 6, 7, 8};
		int a2[] = {1, 2, 3, 4, 5, 6, 7};
		CreateBST ob = new CreateBST();
		Node n1 = ob.createBST(a1);
		Node n2 = ob.createBST(a2);
		BTreePrinter.printNode(n1);
		BTreePrinter.printNode(n2);
	}
}
