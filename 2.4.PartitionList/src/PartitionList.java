
public class PartitionList {
	Node partitionList(Node head, int x)
	{
		Node prev, curr;
		if(head == null) return head;
		prev = head;
		curr = prev.next;
		while(curr != null)
		{
			if(curr.data < x)
			{
				prev.next = curr.next;
				curr.next = head;
				head = curr;
				curr = prev.next;
			}
			else
			{
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String args[])
	{
		Node head = new Node(1);
		for(int i=2; i<=10; i++)
			head.addToLast(i%4);
		
		head = new PartitionList().partitionList(head, 4);
		head.printData();
	}
}
