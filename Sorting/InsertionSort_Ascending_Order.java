import java.util.*;

public class InsertionSort_Ascending_Order {

	// No need to return anything, since Insertion sort
	// sorts the array in-place.
	public static void insertionSort(List<Integer> unsortedArray) {

		// Verify if the list is empty or contains only one element,
		// no need to sort in that case
		if(unsortedArray.size() < 2) {
			return;
		}

		// Start from the second index, we assume that the first index is already sorted
		for(int j = 1; j<unsortedArray.size(); j++) {
			// Key to be placed or inserted at A[0..j-1]
			int key = unsortedArray.get(j);
			int i = j - 1;
			while(i >= 0 && unsortedArray.get(i) > key) {
				// Move the elements right side
				unsortedArray.set(i+1, unsortedArray.get(i));
				i = i - 1;
			}
			// Now place the key at the right position
			unsortedArray.set(i+1, key);
		}
	}

	public static void main(String[] args) {
		Integer[] arr1 = new Integer[]{46, 12, 9, 01, 11};
		List<Integer> arr = Arrays.asList(arr1);
		// Sort the array in ascending form
		insertionSort(arr);
		// Post sorting the array should be {01, 9, 11, 12, 46}
		System.out.println(arr);
	}
}