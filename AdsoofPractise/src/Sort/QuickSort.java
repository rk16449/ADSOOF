package Sort;

import java.util.ArrayList;
import java.util.Scanner;

// Time Complexity 
// Best:    O(n log(n))
// Average: O(n log(n))
// Worst: O(n^2)

// Space Complexity
// Worst: O(log(n))


public class QuickSort {

	private static int[] originalArray;
	private static int[] sortedArray;
	
	public static void main(String[] args) {
		System.out.println("Quick Sort algorithm");
		
		// Store our array values
		originalArray = getArrayValues();
		
		// Output the values
		outputArrayValues(originalArray);
		
		// Quick Sort our array values
		sortedArray = quicksort(originalArray);
	}
	
	private static int[] quicksort(int[] inputArray) {
		
		// Quick sort = pivot
		
		// 1. Correct position in final array
		
		// 2. Items to the left are smaller
		
		// 3. Items to the right are larger
		
		return null;
	}
	
	private static int sort(int[] inputArray, int pivot, int left, int right) {
		
		
		
		return 0;
	}
	
	private static void outputArrayValues(int[] array) {
		// Output results
		System.out.println("Output array:");
		for(int i=0; i<array.length; i++) {
			System.out.println(i + "->" + array[i]);
		}
	}

	private static int[] getArrayValues() {
		
		System.out.println("Enter an array of numbers e.g: [3, 4, 5, 6]: ");
		
		// Get the input from user
		Scanner scan = new Scanner(System.in);
		String values = scan.nextLine();
		
		// Remove square brackets and spaces, then trim whitespace
		values = values.replace(",", " ");
		values = values.replace("[", "");
		values = values.replace("]", "");
		values = values.trim();
		
		// Splits up the entered values
		String[] numbers = values.split(" ");
		
		// Store the numbrs into a dynamic arraylist
		ArrayList<Integer> ints = new ArrayList<Integer>();
		try {
			for(int i=0; i<numbers.length; i++) {
				// Make sure we don't convert empty numbers
				if(!numbers[i].equals("")) {
					ints.add(Integer.parseInt(numbers[i]));
				}
			}
		}catch(NumberFormatException e) {
			e.printStackTrace();
		}
		
		// Convert back the dynamic arraylist to a fixed size array
		int[] fixedArray = new int[ints.size()];
		for(int i=0; i<ints.size(); i++) {
			fixedArray[i] = ints.get(i);
		}

		// Finish with scanner
		scan.close();
		
		// Return int[] array of values
		return fixedArray;
	}
}
