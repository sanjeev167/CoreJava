/**
 * 
 */
package com.MultiThreading.app.imlicitLockThroughSynchronize;

/**
 * @author Sanjeev This class represents an account in the bank
 */
public class AccountThreadSafe1 {
	private int balance = 0;

	public AccountThreadSafe1(int balance) {
		this.balance = balance;
	}

	public void withdraw(int amount) {
		this.balance -= amount;
	}

	public void deposit(int amount) {
		this.balance += amount;
	}

	public int getBalance() {
		return this.balance;
	}
}
