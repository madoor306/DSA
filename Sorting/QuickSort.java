import java.util.*;

public class QuickSort {

	// Recursively sort the left and right sub arrays
	public static void quickSort(List<Integer> arr, int left, int right) {
		if(left < right) {
			int pivot = partition(arr, left, right);
			quickSort(arr, left, pivot-1);
			quickSort(arr, pivot + 1, right);
		}
	}

	// Partition the array across the pivot
	public static int partition(List<Integer> arr, int left, int right) {

		int val = arr.get(right);
		int index = left - 1;
		for(int j = left; j < right; j++) {
			if(arr.get(j) <= val) {
				index++;
				swap(arr, index, j);
			}
		}
		swap(arr, index + 1, right);
		return index + 1;
	}

	public static void swap(List<Integer> arr, int left, int right) {
		int temp = arr.get(right);
		arr.set(right, arr.get(left));
		arr.set(left, temp);
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[]{4, 1, 3, 2, 16, 9, 10, 14, 0, 8, 7};
		List<Integer> arr = new ArrayList<>(Arrays.asList(a));
		quickSort(arr, 0, arr.size() - 1);
		System.out.println(arr);
	}
}