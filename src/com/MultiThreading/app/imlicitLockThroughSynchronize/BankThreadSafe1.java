/**
 * 
 */
package com.MultiThreading.app.imlicitLockThroughSynchronize;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

;

/**
 * @author Sanjeev
 *
 *implicit locking mechanism is used through synchronized
 */
public class BankThreadSafe1 {
	public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 10;
    public static final int INITIAL_BALANCE = 100;
 
    private AccountThreadSafe1[] accounts = new AccountThreadSafe1[MAX_ACCOUNT];
   
    public BankThreadSafe1() {
    	//This will initialize all the bank account with initial balance
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new AccountThreadSafe1(INITIAL_BALANCE);
        }
       
    }
 
    //Formating the message
    String message = "%s transfered amount Rs. %d from accountId ( %s ) to accountId ( %s ). Total balance of All Account: %d\n";	
	public synchronized void transfer(int fromAccountId, int toAccountId, int amount) {
    	
      try {
    	
    	while (amount > accounts[fromAccountId].getBalance()) {		  
    		   wait();
    	       }        	
            accounts[fromAccountId].withdraw(amount);//Withdrawn
            accounts[toAccountId].deposit(amount); //Deposited            
            String threadName = Thread.currentThread().getName();//Taking out thread name to use in message that which has made this transaction
            System.out.printf(message, threadName, amount, fromAccountId, toAccountId, getTotalBalance());
            notifyAll();
      }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}      
    }
 
	public synchronized int getTotalBalance() {
		int total = 0;		
		
		for (int i = 0; i < accounts.length; i++) {
			total += accounts[i].getBalance();
		}		
		return total;
	}
}
