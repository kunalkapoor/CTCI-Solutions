public class MergeSort {
	void mergesort(int[] a, int min, int max) {
		if (min >= max)
			return;

		int mid = (min + max) / 2;

		mergesort(a, min, mid);
		mergesort(a, mid + 1, max);
		merge(a, min, mid, max);
	}

	void merge(int[] a, int min, int mid, int max) {
		int index1, index2, finalindex;
		int[] temparray = new int[max+1];

		index1 = min;
		index2 = mid+1;
		finalindex = min;
		while(index1 <= mid && index2 <= max)
			temparray[finalindex++] = (a[index1] < a[index2]) ? a[index1++] : a[index2++];

		while(index1 <= mid)
			temparray[finalindex++] = a[index1++];
		while(index2 <= max)
			temparray[finalindex++] = a[index2++];

		for(index1 = min; index1 <= max; index1++)
			a[index1] = temparray[index1];
	}
}
