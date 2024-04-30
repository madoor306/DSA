import java.util.*;

// This is an inefficient Sorting algorithmn
// It bubbles the smallest element to the top
public class BubbleSort {
	
	public static void bubbleSort(List<Integer> arr) {
		// No need to sort if the elements are less than 2
		if(arr.size() < 2) {
			return;
		}

		for(int i=0; i < arr.size() - 1; i++) {
			int j = arr.size() - 1;
			while(j > i) {
				// Keep swapping the smallest elements to the right
				if(arr.get(j) < arr.get(j-1)) {
					int temp = arr.get(j);
					arr.set(j, arr.get(j-1));
					arr.set(j-1, temp);
				}
				j--;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] arr1 = new Integer[]{46, 12, 9, 02, 11};
		List<Integer> arr = Arrays.asList(arr1);
		// Sort the array in ascending form
		bubbleSort(arr);
		// Post sorting the array should be {02, 9, 11, 12, 46}
		System.out.println(arr);
	}
}