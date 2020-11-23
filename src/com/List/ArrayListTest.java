/**
 * 
 */
package com.List;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.text.html.HTMLDocument.Iterator;

/**
 * @author Sanjeev
 *
 */
public class ArrayListTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> nameList=new ArrayList<String>();
		ArrayList<String> nameList2=new ArrayList<String>();
		
		nameList.add("Sanjeev");
		nameList.add("Manoj");
		nameList.add("Pandit");
		nameList.add("Sohan");
		nameList.add("Mohan");
		nameList.add("Ganga");
		nameList.add("Ranjit");		
		//Take another list
		nameList2.add("Mangal");
		nameList2.add("Dangal");
		nameList.addAll(nameList2);
		
		//nameList.clear();
		//nameList.remove("Mohan");
		//nameList.remove(1);
		
		//System.out.println(nameList.contains("Sanjeev"));
		
		//System.out.println(nameList.indexOf("Dangal"));
		//Object[] obj=nameList.toArray();
		//for(int i=0;i<obj.length;i++) System.out.println(obj[i]);
		Collections.sort(nameList);
		java.util.Iterator<String> itr=nameList.iterator();
		
		while(itr.hasNext()) 
			{
			String x=itr.next();
			System.out.println(x+" hashCode = "+x.hashCode());//Using iterator			
			}
	   //for(String item:nameList)System.out.println(item);//Using collection based for loop		
	   //nameList.forEach(item-> System.out.println(item));//Using lambda function		
	}

}
