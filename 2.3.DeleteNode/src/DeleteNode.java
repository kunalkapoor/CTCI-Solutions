
public class DeleteNode {

	void deleteNode(Node node)
	{
		if(node != null && node.next != null)
		{
			node.data = node.next.data;
			node.next = node.next.next;
		}
	}
	
	public static void main(String args[])
	{
		Node head = new Node(1);
		for(int i=2; i<=10; i++)
			head.addToLast(i);
		
		new DeleteNode().deleteNode(head.next.next);
		head.printData();
	}
}
