
public class InsertionSort {
	void insertionSort(int[] a) {
		int i, j, n, key;
		n = a.length;

		for (i = 1; i < n; i++) {
			key = a[i];
			for (j = i - 1; j >= 0 && a[j] > key; j--)
				a[j + 1] = a[j];
			a[j + 1] = key;
		}
	}
}
