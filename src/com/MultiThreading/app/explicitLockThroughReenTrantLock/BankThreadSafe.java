/**
 * 
 */
package com.MultiThreading.app.explicitLockThroughReenTrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

;

/**
 * @author Sanjeev
 *
 *explicit locking mechanism is used through ReentrantLock
 */
public class BankThreadSafe {
	public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 10;
    public static final int INITIAL_BALANCE = 100;
 
    private AccountThreadSafe[] accounts = new AccountThreadSafe[MAX_ACCOUNT];
    private Lock bankLock;
    private Condition availableFund;
    public BankThreadSafe() {
    	//This will initialize all the bank account with initial balance
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new AccountThreadSafe(INITIAL_BALANCE);
        }
        bankLock=new ReentrantLock();//Initializing bankLock with ReentrantLock
        availableFund=bankLock.newCondition();//It will be used for checking new condition of a locked bank object
    }
 
    //Formating the message
    String message = "%s transfered amount Rs. %d from accountId ( %s ) to accountId ( %s ). Total balance of All Account: %d\n";
    
	// This method will be called by a thread for transfering amount from one
	// account to another account
	public void transfer(int fromAccountId, int toAccountId, int amount) {
    	//It will be accessed who has lock on this bank object
    	bankLock.lock();
    	//We are checking the sufficiant balance in fromAccount, if yes then the transfer will take place
      try {
    	while (amount <= accounts[fromAccountId].getBalance()) {
    		//It will wait for sufficient balanace in the from account
    		availableFund.await();
    	
    	
    	       }
        	
            accounts[fromAccountId].withdraw(amount);//Withdrawn
            accounts[toAccountId].deposit(amount); //Deposited
            
            String threadName = Thread.currentThread().getName();//Taking out thread name to use in message that which has made this transaction
            System.out.printf(message, threadName, amount, fromAccountId, toAccountId, getTotalBalance());
            availableFund.signalAll();//It will awake all waiting threads to get a lock
      }catch (Exception e) {
			// TODO: handle exception
        	e.printStackTrace();
		}
      
      finally {
    	  bankLock.unlock();//Release the lock
      }
    }
 
	public int getTotalBalance() {
		int total = 0;
		bankLock.lock();//It will be accessed who has lock on this bank object
		try {
		for (int i = 0; i < accounts.length; i++) {
			total += accounts[i].getBalance();
		}
		}finally{
			bankLock.unlock();
		}
		return total;
	}
}
