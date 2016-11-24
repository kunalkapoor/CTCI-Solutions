import java.util.Arrays;
import java.util.Comparator;

public class Gears {
	public static class Gear {
		int index;
		int radius;
		int cost;

		public Gear(int index, int radius, int cost) {
			this.index = index;
			this.radius = radius;
			this.cost = cost;
		}
	}

	static int[] Circles(int distance, int[] radius, int[] cost) {
		int i, j;
		Gear[] gears = new Gear[radius.length];
		int[] minIndex = new int[radius.length];
		int[] minCost = new int[radius.length];

		for (i = 0; i < radius.length; i++) {
			gears[i] = new Gears.Gear(i + 1, radius[i], cost[i]);
			minCost[i] = Integer.MAX_VALUE;
		}

		Arrays.sort(gears, new Comparator<Gear>() {
			@Override
			public int compare(Gear o1, Gear o2) {
				return o1.radius - o2.radius;
			}
		});

		for (i = 0; i < radius.length; i++) {
			int index = binarySearch(gears, gears[i].radius, distance, i, radius.length - 1);
			minIndex[i] = index;
		}

		for (i = 0; i < radius.length; i++) {
			boolean flag = false;
			for (j = minIndex[i]; j < radius.length; j++) {
				if (gears[i].radius + gears[j].radius < distance)
					continue;
				flag = true;
				if (minCost[i] > gears[j].cost) {
					minCost[i] = gears[j].cost;
					minIndex[i] = j;
				}
				if (minCost[j] > gears[i].cost) {
					minCost[j] = gears[i].cost;
					minIndex[j] = i;
				}
			}
			if(flag == false)
				minIndex[i] = -1;
		}

		int[] finalIndex = new int[radius.length];
		for (i = 0; i < radius.length; i++) {
			if (minIndex[i] == -1)
				finalIndex[gears[i].index - 1] = 0;
			else
				finalIndex[gears[i].index - 1] = gears[minIndex[i]].index;
		}
		
		return finalIndex;
	}

	static int binarySearch(Gear[] gears, int currDist, int key, int min, int max) {
		if (min > max)
			return min;

		int mid = (min + max) / 2;

		if (gears[mid].radius + currDist == key)
			return mid;
		if (gears[mid].radius + currDist > key)
			return binarySearch(gears, currDist, key, min, mid - 1);
		return binarySearch(gears, currDist, key, mid + 1, max);
	}

	public static void main(String[] args) {
		int[] out = Circles(8, new int[] { 1, 3, 6, 2, 5 }, new int[] { 5, 6, 8, 3, 4 });
		System.out.println(Arrays.toString(out));
	}
}
