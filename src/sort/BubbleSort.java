package sort;

public class BubbleSort<T> {

	/**
	 * Destructively changes the generic array into sorted form
	 * @param arr
	 */
	public static <T extends Comparable<T>> void sort(T[] arr) {

		// helper; to swap array values
		T temp = null;

		// use bubble sort
		for (int i = 0; i < arr.length; i++) {

			// Loop again, check with every other index
			for (int z = 1; z < arr.length - i; z++) {
				// compare the order of the objects here, store temp variable and swap
				if (arr[z - 1].compareTo(arr[z]) > 0) {
					// swap
					temp = arr[z - 1];
					arr[z - 1] = arr[z];
					arr[z] = temp;
				}
			}
		}
	}

}
