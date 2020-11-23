/**
 * 
 */
package com.MultiThreading;

/**
 * @author Sanjeev
 *
 */
public class MultithreadingDemoThrRunnable implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("MultithreadingDemoThrRunnable is running");
	}

	public static void main(String [] args) {
		
		MultithreadingDemoThrRunnable obj=new MultithreadingDemoThrRunnable();
		Thread tobj=new Thread(obj);//Thread is in new state	
		tobj.start();//Goes in runnijng state.	
	}
	
}
