/**
 * 
 */
package com.Set;

import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author Sanjeev
 *
 */
public class TreeSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating and adding elements  
		SortedSet<String> set=new TreeSet<String>();  
		set.add("Ravi");  
		set.add("Vijay");  
		set.add("Ravi");  
		set.add("Ajay");  
		//traversing elements  
		Iterator<String> itr=set.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  

	}

}
