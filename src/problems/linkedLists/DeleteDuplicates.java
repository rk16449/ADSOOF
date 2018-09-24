package problems.linkedLists;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class DeleteDuplicates {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
    // Complete the removeDuplicates function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        
    	if(head == null) return null;
    	
    	SinglyLinkedListNode node = head;
    	
    	while(node.next != null) {
    		// check if this one equals to the one ahead of us, if it does change its value
    		if(node.data == node.next.data) {
    			node.next = node.next.next;
    		}else {
    			node = node.next;
    		}
    	}
    	return head;
    }
    
    // WHAT NOT TO DO ! (over complicated it here, by storing values into an array etc, (thought the list was unsorted))
    static SinglyLinkedListNode removeDuplicatesBad(SinglyLinkedListNode head) {
    	
    	// Place the value inside an array
    	int[] data = null;
    	
    	// Loop through the linked list
    	SinglyLinkedListNode node = head;
    	while(node != null) {
    		
    		// Store duplicates
    		data = storeValues(data, node.data);
    		
    		// check that this value doesn't exist in data
    		for(int i=0; i<data.length; i++) {
    			if(data[i] == node.data) {
    				// we have a duplicate (remove it!)
    				node = node.next.next;
    			}
    		}
    		
    		
    		// Else continue with the next node
    		node = node.next;
    	}
    	return null;
    }
    
    static int[] storeValues(int[] rgInts, int value) {
    	// returns an array with the duplicates within it
    	int[] newRgInts = new int[rgInts.length+1];
    	
    	boolean exists = false;
    	for(int i=0; i<rgInts.length; i++) {
    		if(rgInts[i] == value) {
    			exists = true;
    			break;
    		}
    	}
    	
    	// Doesn't exist, so add it to the array
    	if(!exists) {
    		for(int i=0; i<rgInts.length; i++) {
    			newRgInts[i] = rgInts[i];
    		}
    		newRgInts[rgInts.length+1] = value;
    		return newRgInts;
    	}else {
    		return rgInts;
    	}
    }
    
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            SinglyLinkedList llist = new SinglyLinkedList();

            int llistCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < llistCount; i++) {
                int llistItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                llist.insertNode(llistItem);
            }

            SinglyLinkedListNode llist1 = removeDuplicates(llist.head);

            printSinglyLinkedList(llist1, " ", bufferedWriter);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
