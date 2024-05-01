import java.util.*;

public class BucketSort {

	// Insertion Sort Algorithmn
	public static void insertionSort(List<Float> bucket) {
		for(int i=1; i<bucket.size(); i++) {
			float key = bucket.get(i);
			int j = i-1;
			while(j >= 0 && bucket.get(j) > key) {
				bucket.set(j+1, bucket.get(j));
				j--;
			}
			bucket.set(j+1, key);
		}
	}

	public static void bucketSort(List<Float> arr) {
		int n = arr.size();

		// Prepare an buckek of array lists
		List<Float>[] bucket = new ArrayList[n];
		for(int i=0; i<n ; i++) {
			bucket[i] = new ArrayList<Float>();
		}

		// Put array elements into the buckets
		for(int i=0; i<n; i++) {
			int num = (int) (n * arr.get(i));
			bucket[num].add(arr.get(i));
		}

		// Sort individual buckets
		for(int i=0; i<n; i++) {
			insertionSort(bucket[i]);
		}

		// Concatenate all the buckets into an array
		int index = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<bucket[i].size(); j++) {
				arr.set(index++, bucket[i].get(j));
			}
		}
	}

	public static void main(String[] args) {
		Float[] a = new Float[]{0.123f, 0.765f, 0.345f, 0.342f, 0.964f};
		List<Float> arr = new ArrayList<>(Arrays.asList(a));
		bucketSort(arr);
		System.out.println(arr);
	}
}