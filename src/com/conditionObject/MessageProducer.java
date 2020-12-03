/**
 * 
 */
package com.conditionObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sanjeev
 *
 */
public class MessageProducer implements Runnable {
	private Message message;

	public MessageProducer(Message msg) {
		message = msg;
	}
	
	@Override
	public void run() {
		pusblishMessages();
	}
	
	private void pusblishMessages(){
		List<String> msgs = new ArrayList<String>();
		msgs.add("We are going to kick off the project.");
		msgs.add("Design will be started on 12/11/2020");
		msgs.add("Coding will be started on 22/11/2020");		
		
		//Start publishing messages by a thread. After each publishing 400 ms pause has been given to consume it by a consumer thread
		for(String msg :  msgs) {
			message.publishMessage(msg);
			try {
	            Thread.sleep(4000);
	        } catch (InterruptedException e) {}
		}
		//Once the publishing is over, say bye to the consumer
		message.publishMessage("Bye");
		message.setEndIt(true);//It is a boolean which is set as true intimate consumer that publishing is over and now you can end consuming
	}
}

