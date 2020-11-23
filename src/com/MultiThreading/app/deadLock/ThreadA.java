/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class ThreadA implements Runnable{
	  private SharedResource obj1;
	  private SharedResource obj2;
	  ThreadA(SharedResource obj1, SharedResource obj2){
	    this.obj1 = obj1;
	    this.obj2 = obj2;
	  }
	@Override
	public void run() {
		
	    synchronized(obj1){
	      System.out.println(Thread.currentThread().getName() + " acquired " + "obj1 lock");
	      try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      System.out.println(Thread.currentThread().getName() + " waiting for  " + "obj2 lock");
	      synchronized(obj2){
	        System.out.println(Thread.currentThread().getName() + " acquired " + "obj2 lock");
	      }
	      
	    }       
	  }  
}
