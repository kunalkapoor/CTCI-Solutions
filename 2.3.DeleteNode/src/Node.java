public class Node
{
	public Node next;
	public int data;
	
	public Node(int data)
	{
		this.data = data;
		this.next = null;
	}
	
	public void addToLast(int newData)
	{
		Node n = this;
		while(n.next != null)
			n = n.next;
		n.next = new Node(newData);
	}
	
	public void printData()
	{
		Node n = this;
		while(n != null)
		{
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}
}
