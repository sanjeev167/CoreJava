/**
 * 
 */
package com.hashCode;

import com.multithreading.BankAccountCache;

/**
 * @author Sanjeev
 *
 */
public class StudentThread implements Runnable{
	
	private Student student;
	
	public StudentThread(Student student) {
		this.student=student;
	}

	@Override
	public void run() {
		synchronized (student) {
			// Getting thread's name
		   	    
		    try {
		    	 System.out.println("Current Thread Name- " + Thread.currentThread().getName() +" is waiting");	
		    	 
				Thread.sleep(10000);
				
				 boolean hasAnylockHoldByAThread=Thread.holdsLock(student);
				 if(!hasAnylockHoldByAThread) {
					 BankAccountCache.bankAccountCaheMap.remove(student.getId());
					 System.out.println("Current Thread Name- " + Thread.currentThread().getName() 
							 +" has completed its task. Now it is removing it from cache if not locked by others.");	
				 }
				 
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
	}

}
