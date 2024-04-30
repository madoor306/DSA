package Sorting;

import java.util.*; 
import DataStructures.MaxHeap;

public class HeapSort {

	public static void heapSort(List<Integer> arr) {
		MaxHeap maxHeap = new MaxHeap();
		// Build the max heap
		maxHeap.buildMaxHeap(arr);
		int heapSize = arr.size();
		for(int i = arr.size()-1; i >= 1; i--) {
			int temp = arr.get(i);
			arr.set(i, arr.get(0));
			arr.set(0, temp);
			maxHeap.maxHeapify(arr, 0, --heapSize);
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[]{4, 1, 3, 2, 16, 9, 10, 14, 0, 8, 7};
		List<Integer> arr = new ArrayList<>(Arrays.asList(a));
		heapSort(arr);
		System.out.println(arr);
	}
}