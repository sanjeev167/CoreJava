/**
 * 
 */
package com.Queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Sanjeev
 *
 */
public class ArrayDequeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating Deque and adding elements
		//ArrayDeque is faster than ArrayList and Stack and has no capacity restrictions.
		Deque<String> deque = new ArrayDeque<String>();  
		deque.add("Gautam");  
		deque.add("Karan");  
		deque.add("Ajay");  
		deque.addFirst("SSS");
		deque.addLast("WW");
		
		//Traversing elements  
		for (String str : deque) {  
		System.out.println(str);  
		}  

	}

}
