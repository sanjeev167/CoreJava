/**
 * 
 */
package com.MultiThreading.app.noLock;

/**
 * @author Sanjeev
 *
 */
public class CreditTransaction implements Runnable{
	
	private Bank bank;
	private int inAccount;

	public CreditTransaction(Bank bank, int inAccount) {
		this.bank = bank;
		this.inAccount = inAccount;
	}


	@Override
	public void run() {
		
		
	}

}
