/**
 * 
 */
package com.hashCode;

import com.multithreading.Account;
import com.multithreading.BankAccountCache;

/**
 * @author Sanjeev
 *
 */
public class TestHashCode {

	public static void main(String args[]) {
		
		Student s1=new Student(1);
		Student s2=new Student(1);
		Account bankAccount=BankAccountCache.bankAccountCaheMap.get(1);
		//System.out.println("s1 = "+s1.hashCode());
		//System.out.println("s2 = "+s2.hashCode());
		
		//System.out.println("s1 and s2 equal test = "+s1.equals(s2));
	
		StudentThread st1=new StudentThread(s1);		
		Thread t1=new Thread(st1,"First Thread");
		t1.start();
		
		
		StudentThread st2=new StudentThread(s1);
		Thread t2=new Thread(st2,"Second Thread");
		t2.start();
		
		
	} 
}
