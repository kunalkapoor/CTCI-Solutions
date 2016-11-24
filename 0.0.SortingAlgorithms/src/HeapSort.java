public class HeapSort {
	void heapsort(int[] a) {
		int i, heapsize;

		heapsize = a.length - 1;
		buildMaxHeap(a, heapsize);

		for (i = heapsize; i >= 1; i--) {
			int temp = a[i];
			a[i] = a[0];
			a[0] = temp;

			heapsize--;
			maxHeapify(a, 0, heapsize);
		}
	}

	void buildMaxHeap(int[] a, int heapsize) {
		int i;
		for (i = (heapsize - 1) / 2; i >= 0; i--) {
			maxHeapify(a, i, heapsize);
		}
	}

	void maxHeapify(int[] a, int i, int heapsize) {
		int left, right, max;

		left = leftnode(i);
		right = rightnode(i);
		max = i;

		if (left <= heapsize && a[left] > a[max])
			max = left;
		if (right <= heapsize && a[right] > a[max])
			max = right;

		if (i != max) {
			int temp = a[max];
			a[max] = a[i];
			a[i] = temp;

			maxHeapify(a, max, heapsize);
		}
	}

	int leftnode(int i) {
		return i*2 + 1;
	}

	int rightnode(int i) {
		return i*2 + 2;
	}
}
