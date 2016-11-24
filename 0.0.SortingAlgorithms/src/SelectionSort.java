
public class SelectionSort {
	void selectionSort(int[] a) {
		int i, j, n, min;
		n = a.length;

		for (i = 0; i < n - 1; i++) {
			min = i;
			for (j = i + 1; j < n; j++)
				if (a[j] < a[min])
					min = j;
			if (min != i) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
	}
}
