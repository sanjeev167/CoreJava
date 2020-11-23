/**
 * 
 */
package com.Set;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Sanjeev
 *
 */
public class HashSetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//Creating HashSet and adding elements  
		HashSet<String> set=new HashSet<String>();  
		set.add("Vijay"); set.add("Ravi");  
		 
		set.add("Ravi");  
		set.add("Ajay");  
		//Traversing elements  
		Iterator<String> itr=set.iterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		}  

	}

}
