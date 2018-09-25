package problems.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRotation {



    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }
        
        System.out.println("n: " + n + " d: " + d);
        
        
        a = left(n, d, a);
        for(int i=0; i< a.length; i++) {
        	System.out.println(a[i]);
        }
        
        

        scanner.close();
    }
    
    // returns an int[] array where n is the pivot, d is the distance to move to the left
    static int[] left(int n, int d, int[] a) {
    	
    	// copy array
    	int[] data = new int[a.length];
    	
    	for(int i=0; i<a.length; i++) {
    		// Find the pivot
    		if(a[i] == n) {
    			// move everything to the left, filling up data for the first time using a
    			data = shiftLeft(a);
    			// move this value to the left, d times
    			for(int x=1; x<d; x++) {
    				data = shiftLeft(data);
    			}
    			break;
    		}
    	}
    	
    	return data;
    }
    
    static int[] shiftLeft(int[] a) {
    	int[] data = new int[a.length];
    	// moves everything by one
    	for(int i=0; i<a.length-1; i++) {
    		data[i] = a[i+1];
    	}
    	// append value to the end
    	data[a.length-1] = a[0];
    	return data;
    }
}
