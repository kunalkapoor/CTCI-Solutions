import java.util.Arrays;

public class SortingAlgorithms {
	static int[] array = {6, 7, 4, 8, 11, 3, 9, 5, 1, 2, 10};
			
	public static void main(String[] args) {
		int[] temp;
		System.out.println("Unsorted array: " + Arrays.toString(array));
		
		temp = Arrays.copyOf(array, array.length);
		Arrays.sort(temp);
		System.out.println("Arrays.sort() = " + Arrays.toString(temp));
		
		temp = Arrays.copyOf(array, array.length);
		new BubbleSort().bubbleSort(temp);
		System.out.println("Bubble sort = " + Arrays.toString(temp));
		
		temp = Arrays.copyOf(array, array.length);
		new SelectionSort().selectionSort(temp);
		System.out.println("Selection Sort = " + Arrays.toString(temp));
		
		temp = Arrays.copyOf(array, array.length);
		new InsertionSort().insertionSort(temp);
		System.out.println("Insertion Sort = " + Arrays.toString(temp));
		
		temp = Arrays.copyOf(array, array.length);
		new MergeSort().mergesort(temp, 0, temp.length-1);
		System.out.println("Merge Sort = " + Arrays.toString(temp));
		
		temp = Arrays.copyOf(array, array.length);
		new QuickSort().quicksort(temp, 0, temp.length-1);
		System.out.println("Quick Sort = " + Arrays.toString(temp));
		
		temp = Arrays.copyOf(array, array.length);
		new HeapSort().heapsort(temp);
		System.out.println("Heap Sort = " + Arrays.toString(temp));
	}
}
