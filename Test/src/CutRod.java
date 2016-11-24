import java.util.Arrays;

public class CutRod {
	static int maxProfit(int cost_per_cut, int metal_price, int[] lengths) {
		Arrays.sort(lengths);

		int i, j, max = 0;
		for (i = 0; i < lengths.length; i++)
			if (max < lengths[i])
				max = lengths[i];

		int maxSum = 0;
		for (i = 1; i <= max; i++) {
			int sum = 0;
			for (j = 0; j < lengths.length; j++) {
				int rodlength = lengths[j];
				if(rodlength >= i) {
					int numRods = rodlength/i;
					int numCuts = (rodlength % i == 0) ? numRods - 1 : numRods;
					sum += (i * metal_price * numRods) - (numCuts*cost_per_cut);
				}
				if(sum < 0) break;
			}
			if(maxSum < sum)
				maxSum = sum;
		}

		return maxSum;
	}
	
	public static void main(String[] args) {
		int[] test = new int[50];
//		for(int i=0; i<50; i++)
//			test[i] = (int) (Math.random() * 10000);
		for(int i=0; i<50; i++)
			test[i] = 10000;
		
		long time = System.currentTimeMillis();
//		System.out.println(maxProfit(100, 10, test));
//		System.out.println(maxProfit(100, 10, new int[] {26, 102, 59}));
		System.out.println(maxProfit(1,1,new int[] {1}));
		System.out.println("Time taken: " + (System.currentTimeMillis() - time));
	}
}
