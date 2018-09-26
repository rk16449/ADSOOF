package problems.arrays;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class LeftRot {

    // Much cleaner, simpler code (learn this)
    static int[] rotLeft(int[] a, int d) {
    	d %= a.length;
    	
    	System.out.println("value of d is now: " + d);
    	
        int[] ret = new int[a.length];
        for(int i = 0; i < a.length; ++i) {
        	
        	System.out.println("i is: " + i);
        	System.out.println("d is: " + d);
        	System.out.println("i+d is: " + (i+d));
        	System.out.println("(i+d) % a.length is: " + ((i+ d) % a.length));
        	
            ret[i] = a[(i + d) % a.length];
        }
        return ret;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
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

        int[] result = rotLeft(a, d);
        
        scanner.close();
    }
}
