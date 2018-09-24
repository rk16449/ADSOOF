package problems.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class HourGlassSum {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		
		// So it works with negatives as well
		int highestSum = Integer.MIN_VALUE;
		
		// Subset placeholder values
		int[][] subset = new int[][]{
				{0,  0,  0},
				{0,  0,   0},
				{0,  0,  0}
		};
		
		// Loop the hour glasses; requires 3x width, 3x height,
		for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
            	
            	
            	// Check that we have enough columns and rows from here
            	if( ((row + 2) < arr.length) && ((col + 2) < arr.length)){
            		// Manual subset:
            		subset[0][0] = arr[row][col];
            		subset[0][1] = arr[row][col+1];
            		subset[0][2] = arr[row][col+2];
            		subset[1][1] = arr[row+1][col+1];
            		subset[2][0] = arr[row+2][col];
            		subset[2][1] = arr[row+2][col+1];
            		subset[2][2] = arr[row+2][col+2];
            		
            		// Pass this subset into a method
            		if(calcSum(subset) > highestSum) {
            			highestSum = calcSum(subset);
            		}
            	}
            }
        }
	
		return highestSum;
	}
	
	static int calcSum(int[][] arr) {
		
		int sum = 0;
		for(int row = 0; row < arr.length; row ++) {
			for(int col = 0; col < arr[row].length; col++) {
				sum += arr[row][col];
			}
		}
		
		return sum;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		int[][] arr = new int[6][6];
		
		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		
		int result = hourglassSum(arr);
		
		System.out.println("Highest hourglass sum is: " + result);

		scanner.close();
	}
}
