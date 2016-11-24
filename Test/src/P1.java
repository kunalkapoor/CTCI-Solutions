import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;

public class P1 {

	private static class Node {
		Node left, right;
		int data;

		Node(int newData) {
			left = right = null;
			data = newData;
		}
	}

	private static Node insert(Node node, int data) {
		if (node == null) {
			node = new Node(data);
		} else {
			if (data <= node.data) {
				node.left = insert(node.left, data);
			} else {
				node.right = insert(node.right, data);
			}
		}
		return (node);
	}

	private static int isPresent(Node root, int val) {
		if (root == null)
			return 0;

		if (root.data == val)
			return 1;
		else if (val < root.data)
			return isPresent(root.left, val);
		return isPresent(root.right, val);
	}

	static int jumps(int k, int j) {
		return k / j + k % j;
	}

	static String compute(String s) {
		char lastAlpha = 'A';
		int posOfSub = 0;
		for (int i = 0; i < s.length(); i++) {
			char currChar = s.charAt(i);
			if (currChar > lastAlpha) {
				lastAlpha = currChar;
				posOfSub = i;
			}
		}

		return s.substring(posOfSub);
	}

	static int verifyItems(String[] origItems, float[] origPrices, String[] items, float[] prices) {
		HashMap<String, Float> priceMap = new HashMap<>();
		int count = 0;
		for (int i = 0; i < origItems.length; i++) {
			if (priceMap.get(origItems[i]) != null && priceMap.get(origItems[i]) != origPrices[i])
				count++;
			priceMap.put(origItems[i], origPrices[i]);
			if (i < items.length) {
				if (priceMap.get(items[i]) != null && priceMap.get(items[i]) != prices[i])
					count++;
				priceMap.put(items[i], prices[i]);
			}
		}
		return count;
	}

	static char move(char ch, int op) {
		int ret = ch + op;
		if (ret < 'a')
			ret = 'z' - ('a' - ret) + 1;
		if (ret > 'z')
			ret = 'a' + (ret - 'z') - 1;
		return (char) ret;
	}

	static String rollingString(String s, String[] operations) {
		int start, end, op;
		char[] str = s.toCharArray();
		for (int i = 0; i < operations.length; i++) {
			String[] splitInput = operations[i].split(" ");
			start = Integer.parseInt(splitInput[0]);
			end = Integer.parseInt(splitInput[1]);
			op = (splitInput[2].charAt(0) == 'L') ? -1 : 1;
			for (int j = start; j <= end; j++)
				str[j] = move(str[j], op);
		}

		return String.valueOf(str);
	}

	static String electionWinner(String[] votes) {
		HashMap<String, Integer> ballot = new HashMap<>();
		int i;
		for (i = 0; i < votes.length; i++) {
			if (ballot.get(votes[i]) == null)
				ballot.put(votes[i], 1);
			else
				ballot.put(votes[i], ballot.get(votes[i]) + 1);
		}

		Comparator comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -o1.compareTo(o2);
			}
		};
		Queue<String> people = new PriorityQueue<>(comparator);
		Iterator<Entry<String, Integer>> it = ballot.entrySet().iterator();
		int max = 0;
		while (it.hasNext()) {
			Entry<String, Integer> entry = it.next();
			if (entry.getValue() > max) {
				max = entry.getValue();
				people = new PriorityQueue<>(comparator);
				people.offer(entry.getKey());
			} else if (entry.getValue() == max)
				people.offer(entry.getKey());
		}

		return people.peek();
	}

	public static void main(String[] args) {
		// System.out.println(jumps(1000000000,6));

		// System.out.println(compute("ABC"));
		System.out.println(electionWinner(new String[] { "Alex", "Michael", "Harry", "Dave", "Michael", "Victor",
				"Harry", "Alex", "Mary", "Mary" }));
		
		System.out.println(electionWinner(new String[] { 
				"Victor", "Veronica", "Ryan", "Dave", "Maria", "Maria",
				"Farah", "Farah", "Ryan", "Veronica" }));

		// System.out.println(verifyItems(
		// new String[] {"rice", "sugar", "wheat"},
		// new float[] {15.00f, 300.90f, 23.44f},
		// new String[] {"wheat", "rice", "sugar"},
		// new float[] {23.44f, 15.1f, 300.90f}));

		// System.out.println(rollingString("aby", new String[] {
		// "0 0 L", "0 2 L", "2 2 R", "1 2 R", "0 2 R"
		// }));
	}
}
