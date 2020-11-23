/**
 * 
 */
package com.List;

import java.util.Collections;
import java.util.LinkedList;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author Sanjeev
 *
 */
public class LinkedListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LinkedList<String> al = new LinkedList<String>();
		al.add("Ravi");
		al.add("Vijay");
		al.add("Ravi");
		al.add("Ajay");
		al.addFirst("DDD");
		al.addLast("RRR");
		
		// al.add(4, "Fifth");
		// al.listIterator()
		// Collections.sort(al);
        
		java.util.Iterator<String> itr = al.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		java.util.Iterator<String> itr2 = al.descendingIterator();
		System.out.println("############");
		while (itr2.hasNext()) {
			System.out.println(itr2.next());
		}

	}

}
