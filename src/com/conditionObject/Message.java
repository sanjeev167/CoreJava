/**
 * 
 */
package com.conditionObject;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * @author Sanjeev
 *
 */
public class Message {

	final private Lock lock = new ReentrantLock();
	final private Condition producedMsg  = lock.newCondition(); 
	final private Condition consumedMsg = lock.newCondition(); 

	private String message;
	private boolean isMessageStateNew;
	private boolean endIt;

	public void viewMessage() {
		//lock
		lock.lock();
		try {
			//no new message wait for new message
			while (!isMessageStateNew) {
				producedMsg.await();//Will wait until a new message is produced.
				System.out.println("Consumer is waiting for new message to be produced.");
			}
			System.out.println("=====> Here is the latest message : ["+message+"] . Consumer has consumed it.");
			isMessageStateNew = false;//After consuming message it sets the state as false so that viewr could wait for new message and producer could go for 
			                         //generating a new message
			//message consumed, notify waiting thread
			consumedMsg.signal();//Will communicate producer that message has been consumed, go for producing a new message.

		}catch(InterruptedException ie) {
			System.out.println("Thread interrupted - viewMessage");
		}finally {
			lock.unlock();
		}
	}
	
	
	/**
	 * This is a synchronized method so that one thread could use it at one time. A thread using it is put a lock on it.
	 * For communicating with consumer thread , it is using a condition object. Initially, it is checking isMessageStateNew boolean value and passing a message to 
	 * the consumer that wait for a new message to be produced. At the beging its value is false and telling it not to wait. Go for consumption.
	 * After producing, it is setting it true and telling consumer that a new message has been produced and signaling through a producedMsg condition object
	 * */
	public void publishMessage(String message) {
		lock.lock();
		try {
			//last message not consumed, wait for it be consumed
			while (isMessageStateNew) { //Default boolean value is false
				consumedMsg.await();//Will wait until it is consumed
				System.out.println("Producer is waiting for new message to be consumed.");
			}
			System.out.println("=======> Added a latest message for publishing.==> "+message);
			this.message = message;//Assign this newly added message
			isMessageStateNew = true;//Set isMessageStateNew as true for a new message
			//new message added, notify waiting thread for consuming it
			producedMsg.signal();

		}catch(InterruptedException ie) {
			System.out.println("Thread interrupted - publishMessage");
		}finally {
			lock.unlock();
		}

	}
	
	public boolean isEndIt() {
		return endIt;
	}
	public void setEndIt(boolean endIt) {
		this.endIt = endIt;
	}
}
