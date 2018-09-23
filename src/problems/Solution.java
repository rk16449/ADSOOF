package problems;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		
		int highestSum = 0;
		
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
            		
            		System.out.print(arr[row][col] + "\t");
            		
            		// Manually looks like this;
            		
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
            System.out.println();
        }
		
		System.out.println("Highest sum is: " + highestSum);
		
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
		//BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

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

		//bufferedWriter.write(String.valueOf(result));
		//bufferedWriter.newLine();

		//bufferedWriter.close();

		scanner.close();
	}
}
