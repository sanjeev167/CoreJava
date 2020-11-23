/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class DLDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SharedResource obj1=new SharedResource(); 
		SharedResource obj2=new SharedResource(); 
		
		ThreadA A=new ThreadA(obj1, obj2);		
		Thread At=new Thread(A,"Thread A");
		At.start();
		
		ThreadB B=new ThreadB(obj1, obj2);
		Thread Bt=new Thread(B,"Thread B");
		Bt.start();
	}

}
