import java.util.ArrayList;

public class Node
{
	public ArrayList<Node> children;
	public int data;
	boolean visited;
	
	public Node(int data)
	{
		this.data = data;
		this.children = new ArrayList<>();
		visited = false;
	}
}

