/**
 * 
 */
package com.conditionObject;

/**
 * @author Sanjeev
 *
 */
public class MessageViewer implements Runnable{
	private Message message;

	public MessageViewer(Message msg) {
		message = msg;
	}

	@Override
	public void run() {
		while(!message.isEndIt())//This will simply check whether message producing task has already been completed or still on.
			message.viewMessage();
	}
}
