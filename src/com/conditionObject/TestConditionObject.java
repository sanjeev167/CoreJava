/**
 * 
 */
package com.conditionObject;

/**
 * @author Sanjeev
 *
 */
public class TestConditionObject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Message msg = new Message();//This is the message class which has two methods of publishing and consuming (viewMeassage). This is a shareable resource 
		                            //Which is being shared among threads
		
		Thread messageProducer = new Thread(new MessageProducer(msg));
		Thread messageViewer = new Thread(new MessageViewer(msg));
		
		messageProducer.start();
		messageViewer.start();

	}

}
