/**
 * 
 */
package com.MultiThreading.app.noLock;

/**
 * @author Sanjeev
 *
 */
public class DebitTransaction implements Runnable{
	
	private Bank bank;
	private int inAccount;

	public DebitTransaction(Bank bank, int inAccount) {
		this.bank = bank;
		this.inAccount = inAccount;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
