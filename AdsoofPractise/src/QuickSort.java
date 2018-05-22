import java.util.Scanner;

// Time Complexity 
// Best:    O(n log(n))
// Average: O(n log(n))
// Worst: O(n^2)

// Space Complexity
// Worst: O(log(n))


public class QuickSort {

	
	
	public static void main(String[] args) {
		System.out.println("Quick Sort algorithm");
		
		
		System.out.println("Enter an array of numbers e.g: [3, 4, 5, 6]: ");
		
		Scanner scan = new Scanner(System.in);
		String values = scan.nextLine();
		values = values.trim();
		
		System.out.println("You entered: " + values);
		
		// Remove square brackets, and break up the commas
		
		
		System.out.println();
		
		scan.close();
		
		// Recursive Algorithm
		
		// Quick sort = pivot
		
		// 1. Correct position in final array
		
		// 2. Items to the left are smaller
		
		// 3. Items to the right are larger
	}
}
