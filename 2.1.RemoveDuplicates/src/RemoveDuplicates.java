import java.util.HashSet;

public class RemoveDuplicates 
{
	public void removeDuplicates(Node head)
	{
		Node n = head;
		HashSet<Integer> valueSet = new HashSet<Integer>();
		valueSet.add(n.data);
		
		while(n.next != null)
		{
			if(valueSet.contains(n.next.data))
				n.next = n.next.next;
			else
			{
				valueSet.add(n.next.data);
				n = n.next;
			}
		}
	}
	
	public void removeDuplicatesWithoutBuffer(Node head)
	{
		Node n = head;
		while(n != null)
		{
			Node runner = n;
			while(runner.next != null)
			{
				if(runner.next.data == n.data)
					runner.next = runner.next.next;
				else
					runner = runner.next;
			}
			n = n.next;
		}
	}
	
	public static void main(String args[])
	{
		Node head = new Node(1);
		for(int i=2; i<=10; i++)
			head.addToLast(1 + i%3);
		
//		new RemoveDuplicates().removeDuplicates(head);
		new RemoveDuplicates().removeDuplicatesWithoutBuffer(head);
		head.printData();
	}
}