import java.util.*;

public class RadixSort {

	public static int findMax(List<Integer> arr) {
		int max = arr.get(0);
		for(int i = 1; i < arr.size(); i++) {
			max = Math.max(max, arr.get(i));
		}
		return max;
	}

	public static void sort(List<Integer> arr, int exp) {
		int[] count = new int[10];
		int[] output = new int[arr.size()];

		// Store the count of occurences
		for(int i = 0; i < arr.size(); i++) {
			count[(arr.get(i) / exp) % 10]++;
		}

		// Actual position in the output array
		for(int i = 1; i < 10; i++) {
			count[i] += count[i-1];
		}

		// Build the output array
		for(int i = arr.size()-1; i >= 0; i--) {
			output[count[(arr.get(i)/exp) % 10] - 1] = arr.get(i);
			count[(arr.get(i) / exp) % 10]--;
		}

		for(int i = 0; i < output.length; i++) {
			arr.set(i, output[i]);
		}

	}

	public static void radixSort(List<Integer> arr) {
		int max = findMax(arr);
		for(int exp = 1; (max / exp) > 0; exp *= 10) {
			sort(arr, exp);
		}
	}

	public static void main(String[] args) {
		Integer[] a = new Integer[]{123, 765, 345, 342, 964};
		List<Integer> arr = new ArrayList<>(Arrays.asList(a));
		radixSort(arr);
		System.out.println(arr);
	}
}