
public class QuickSort {
	void quicksort(int[] a, int min, int max) {
		if (min >= max)
			return;

		int q = partition(a, min, max);
		quicksort(a, min, q);
		quicksort(a, q + 1, max);
	}

	int partition(int[] a, int min, int max) {
		int i, j, pivot, temp;

		pivot = min + (int) (Math.random() * (max - min));
		temp = a[pivot];
		a[pivot] = a[max];
		a[max] = temp;
		pivot = max;

		i = min - 1;
		for (j = min; j < max; j++) {
			if (a[j] <= a[pivot]) {
				i++;
				temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}

		i++;
		temp = a[i];
		a[i] = a[pivot];
		a[pivot] = temp;

		return i;
	}

}
