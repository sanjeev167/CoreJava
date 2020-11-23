/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class ThreadB implements Runnable{
	private SharedResource obj1;
	private SharedResource obj2;
	
	ThreadB(SharedResource obj1, SharedResource obj2){
	    this.obj1 = obj1;
	    this.obj2 = obj2;
	  }
	//Here nested lock has been taken by the thread. Synchronization block has been used. It is used with synchronized(obj){}
	//Nested lock will create deadlock. Here, two shared resources have been used for nested lock. Other thread is also using the same approach in the reverse order in its run method.
	
	@Override
	public void run() {
		
		synchronized(obj2){
		      System.out.println(Thread.currentThread().getName() + " acquired " + "obj2 lock");
		      try {
				Thread.sleep(1000);//Let this thread sleep for 1000 mili seconds sot hat other thread could get a chance to acquire lock on obj1 and create deadlock
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      System.out.println(Thread.currentThread().getName() + " waiting for  " + "obj1 lock");
		      synchronized(obj1){
		        System.out.println(Thread.currentThread().getName() + " acquired " + "obj1 lock");
		      }//End of inner synchronized block
		    } //End of outer synchronized block 
		
	}
}
