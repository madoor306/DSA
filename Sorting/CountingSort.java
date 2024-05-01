import java.util.*;

public class CountingSort {

	public static void countSort(List<Integer> arr, int k) {
		int[] freq = new int[k+1];
		// Calculate the frequency of each of the elements in array
		for(int i = 0; i < arr.size(); i++) {
			freq[arr.get(i)]++;
		}
		int index = 0;
		for(int i = 0; i < freq.length; i++) {
			int val = freq[i];
			while(val > 0) {
				arr.set(index++, i);
				val--;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[]{4, 1, 3, 2, 16, 9, 10, 14, 0, 8, 7};
		List<Integer> arr = new ArrayList<>(Arrays.asList(a));
		countSort(arr, 16);
		System.out.println(arr);
	}
}