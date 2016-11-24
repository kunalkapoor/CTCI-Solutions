import java.util.Stack;

public class CheckPalindrome 
{
	boolean isPalindrome(Node head)
	{
		if(head == null || head.next == null) return true;

		Stack<Integer> stack = new Stack<>();
		Node slow = head, fast = head;
		while(fast != null && fast.next != null)
		{
			stack.push(slow.data);
			slow = slow.next;
			fast = fast.next.next;
		}
		
		if(fast != null) slow = slow.next;
		while(slow != null)
		{
			if(stack.pop() != slow.data)
				break;
			slow = slow.next;
		}
		
		if(slow == null)
			return true;
		return false;
	}
	
	Result isPalindromeRecursive(Node left, int len)
	{
		if(left == null || len == 0)
			return null;
		
		if(len == 1)
			return new Result(left.next, true);
		if(len == 2)
		{
			if(left.next.data == left.data)
				return new Result(left.next.next, true);
			return new Result(null, false);
		}
		Result res = isPalindromeRecursive(left.next, len-2);
		if(res.result == false)
			return res;
		Node right = res.node;
		if(left.data == right.data)
			return new Result(right.next, true);
		return new Result(null, false);
	}
	
	public static void main(String args[])
	{
		Node head = new Node(1);
		for(int i=2; i<=10; i++)
			head.addToLast(i);
		
		System.out.println(new CheckPalindrome().isPalindrome(head));
		System.out.println(new CheckPalindrome().isPalindromeRecursive(head, 10).result);

		for(int i=10; i>=1; i--)
			head.addToLast(i);
		
		System.out.println(new CheckPalindrome().isPalindrome(head));
		System.out.println(new CheckPalindrome().isPalindromeRecursive(head, 20).result);
		
		Node h2 = new Node(1);
		for(int i=2; i<=10; i++)
			h2.addToLast(i);
		for(int i=9; i>=1; i--)
			h2.addToLast(i);
		
		System.out.println(new CheckPalindrome().isPalindrome(h2));
		System.out.println(new CheckPalindrome().isPalindromeRecursive(h2, 19).result);

	}
}
