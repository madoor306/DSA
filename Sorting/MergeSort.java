import java.util.*;

public class MergeSort {

	List<Integer> ans = new ArrayList<>();

	// This is the Divide step in Merge Sort
	public static void mergeSort(List<Integer> unsortedArray, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2;
			// Divide the problem recursively
			mergeSort(unsortedArray, start, mid);
			mergeSort(unsortedArray, mid + 1, end);
			merge(unsortedArray, start, mid, end);
		}
	}

	// This is the Combine step where the sorted arrays are merged in-place
	// Two sorted arrays are: 
	// Array 1 -> from start to mid
	// Array 2 -> from mid + 1 to end
	public static void merge(List<Integer> arr, int start, int mid, int end) {
		int start2 = mid + 1;
 
        // If the direct merge is already sorted
        if (arr.get(mid) <= arr.get(start2)) {
            return;
        }
 
        // Two pointers to maintain start
        // of both arrays to merge
        while (start <= mid && start2 <= end) {
 
            // If element 1 is in right place
            if (arr.get(start) <= arr.get(start2)) {
                start++;
            }
            else {
                int value = arr.get(start2);
                int index = start2;
 
                // Shift all the elements between element 1
                // element 2, right by 1.
                while (index != start) {
                    arr.set(index, arr.get(index - 1));
                    index--;
                }
                arr.set(start, value);
 
                // Update all the pointers
                start++;
                mid++;
                start2++;
            }
        }
	}

	public static void main(String[] args) {
		Integer[] arr1 = new Integer[]{46, 12, 9, 02, 11};
		List<Integer> arr = Arrays.asList(arr1);
		// Sort the array in ascending form
		mergeSort(arr, 0, arr.size()-1);
		// Post sorting the array should be {02, 9, 11, 12, 46}
		System.out.println(arr);
	}

}