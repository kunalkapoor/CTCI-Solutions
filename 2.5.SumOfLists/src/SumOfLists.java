
public class SumOfLists 
{
	Node addReverse(Node h1, Node h2)
	{
		int sum, carry;
		Node n1, n2, h0, n0;
		
		if(h1 == null) return h2;
		if(h2 == null) return h1;

		n1 = h1;
		n2 = h2;
		sum = n1.data + n2.data;
		carry = sum/10;
		
		h0 = new Node(sum%10);
		h0.next = null;
		n0 = h0;
		
		n1 = n1.next;
		n2 = n2.next;
		
		while(n1 != null && n2 != null)
		{
			sum = n1.data + n2.data + carry;
			n0.next = new Node(sum%10);
			n0 = n0.next;
			carry = sum/10;
			
			n1 = n1.next;
			n2 = n2.next;
		}
		while(n1 != null)
		{
			n0.next = new Node(n1.data + carry);
			n0 = n0.next;
			n1 = n1.next;
			carry = 0;
		}
		while(n2 != null)
		{
			n0.next = new Node(n2.data + carry);
			n0 = n0.next;
			n2 = n2.next;
			carry = 0;
		}
		n0.next = null;
		return h0;
	}
	
	Node addReverseRecursive(Node n1, Node n2, int carry)
	{
		int sum;
		Node temp;
		
		if(n1 == null && n2 == null) return null;
		
		if(n1 == null) sum = n2.data;
		else if(n2 == null) sum = n1.data;
		else sum = n1.data + n2.data;
		sum += carry;
		
		temp = new Node(sum%10);
		if(n1 == null) temp.next = addReverseRecursive(n1, n2.next, sum/10);
		else if(n2 == null) temp.next = addReverseRecursive(n1.next, n2, sum/10);
		else temp.next = addReverseRecursive(n1.next, n2.next, sum/10);
		
		return temp;
		
	}
	
	Node addForwardRecursive(Node n1, Node n2, Node out)
	{
		int sum, carry;
		Node temp;
		
		if(n1 == null && n2 == null) return null;
		
		temp = new Node(0);
		temp.next = addForwardRecursive(n1.next, n2.next, temp);
		
		sum = n1.data + n2.data;
		carry = temp.data;
		sum += carry;
		temp.data = sum%10;
		
		carry = sum/10;
		if(out != null) out.data = carry;
		return temp;
	}
	
	Node addForward(Node h1, Node h2)
	{
		int l1, l2;
		l1 = length(h1);
		l2 = length(h2);
		
		Node n1, n2;
		n1 = addPadding(h1, l2-l1);
		n2 = addPadding(h2, l1-l2);
		
		return addForwardRecursive(n1, n2, null);
	}
	
	Node addPadding(Node head, int diff)
	{
		if(diff <= 0) return head;
		
		Node n = head;
		for(int i=0; i<diff; i++)
		{
			Node temp = new Node(0);
			temp.next = n;
			n = temp;
		}
		
		return n;
	}
	
	int length(Node head)
	{
		int i;
		Node n;
		for(i=0, n = head; n!=null; i++, n = n.next);
		
		return i;
	}
	
	public static void main(String args[])
	{
		Node rev1 = new Node(1);
		rev1.addToLast(2);
		
		Node rev2 = new Node(9);
		rev2.addToLast(0);
		rev2.addToLast(9);
		
		Node rev3 = new Node(7);
		rev3.addToLast(1);
		rev3.addToLast(6);
		
		Node rev4 = new Node(5);
		rev4.addToLast(9);
		rev4.addToLast(2);
		
		SumOfLists ob = new SumOfLists();
		Node out;
		
		out = ob.addReverse(rev1, rev2);
		out.printData();
		out = ob.addReverseRecursive(rev1, rev2, 0);
		out.printData();
		
		out = ob.addReverse(rev3, rev4);
		out.printData();
		out = ob.addReverseRecursive(rev3, rev4, 0);
		out.printData();
		
		out = ob.addReverse(rev1, null);
		out.printData();
		out = ob.addReverseRecursive(rev1, null, 0);
		out.printData();
		
		out = ob.addReverse(null, rev2);
		out.printData();
		out = ob.addReverseRecursive(null, rev2, 0);
		out.printData();

		System.out.println();
		
		Node for1 = new Node(2);
		for1.addToLast(1);
		
		Node for2 = new Node(9);
		for2.addToLast(0);
		for2.addToLast(9);
		
		Node for3 = new Node(6);
		for3.addToLast(1);
		for3.addToLast(7);
		
		Node for4 = new Node(2);
		for4.addToLast(9);
		for4.addToLast(5);
		
		out = ob.addForward(for1, for2);
		out.printData();
		out = ob.addForward(for3, for4);
		out.printData();
		out = ob.addForward(for1, null);
		out.printData();
		out = ob.addForward(null, for2);
		out.printData();
	}
}
