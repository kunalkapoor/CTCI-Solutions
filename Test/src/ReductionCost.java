import java.util.Comparator;
import java.util.PriorityQueue;

public class ReductionCost {
	static int reductionCost(int[] num) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return -1;
				else if (o1 > o2)
					return 1;
				return 0;
			}
		};

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(num.length, comparator);

		for (int i = 0; i < num.length; i++) {
			queue.add(num[i]);
		}

		int sum = 0;

		while (queue.size() > 1) {
			int localSum = queue.poll() + queue.poll();
			queue.add(localSum);
			sum += localSum;
		}

		return sum;
	}

	public static void main(String[] args) {
		System.out.println(reductionCost(new int[] { 1, 7, 5 }));
	}
}
