package search;


public class LinearSearch <E> {
	public static <E> boolean search(E obj, E[] arr) {
		// Loop through generic arr
		for(int i=0; i<arr.length; i++) {
			// If we find a match return true
			if(arr[i].equals(obj)) 
				return true;
		}
		
		// No match found
		return false;
	}
}
