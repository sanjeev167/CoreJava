/**
 * 
 */
package com.List;

import java.util.Iterator;
import java.util.Vector;

/**
 * @author Sanjeev
 *
 */
public class VectorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Vector<String> v=new Vector<String>();  
		v.add("Ayush");  
		v.add("Amit");  
		v.add("Ashish");  
		v.add("Garima"); 
		v.set(0, "VVVVV");  
	
		Iterator<String> itr=v.listIterator();  
		while(itr.hasNext()){  
		System.out.println(itr.next());  
		} 

	}

}
