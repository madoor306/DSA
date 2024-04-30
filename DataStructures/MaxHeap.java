package DataStructures;

import java.util.*;

public class MaxHeap {

	public static void maxHeapify(List<Integer> arr, int index, int heapSize) {
		// The left and right indices in Binary tree is given by:
		// Parent = i / 2
		// Left = 2i
		// Right = 2i + 1
		int left = 2 * index + 1;
		int right = (2 * index) + 2;
		int largest = index;
		// Verify if any of the children is largest
		if(left < heapSize && arr.get(left) > arr.get(largest)) {
			largest = left;
		}
		if(right < heapSize && arr.get(right) > arr.get(largest)) {
			largest = right;
		}
		// Exchange the index element with the largest child
		if(largest != index) {
			int temp = arr.get(index);
			arr.set(index, arr.get(largest));
			arr.set(largest, temp);
			// Recursively call maxHeapify for the largest index
			maxHeapify(arr, largest, heapSize);
		}
	}

	public static void buildMaxHeap(List<Integer> arr) {
		if(arr.size() < 2) {
			return;
		}

		// Call maxHeapify for n / 2 elements in the array
		for(int i = (arr.size()/2); i >= 0; i--) {
			maxHeapify(arr, i, arr.size());
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[]{4, 1, 3, 2, 16, 9, 10, 14, 0, 8, 7};
		List<Integer> arr = new ArrayList<>(Arrays.asList(a));
		buildMaxHeap(arr);
		System.out.println(arr);
	}
}