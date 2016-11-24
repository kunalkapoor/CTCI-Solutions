public class Node
{
	public Node left, right;
	public int data;
	
	public Node(int data)
	{
		this.data = data;
		this.left = this.right = null;
	}
	
	public static void printInorder(Node root) {
		if(root == null)
			return;
		
		printInorder(root.left);
		System.out.print(root.data + " ");
		printInorder(root.right);
	}
	
	public static void printPreorder(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data + " ");
		printInorder(root.left);
		printInorder(root.right);
	}
	
	public static void printPostorder(Node root) {
		if(root == null)
			return;
		
		printInorder(root.left);
		printInorder(root.right);
		System.out.print(root.data + " ");
	}
}

