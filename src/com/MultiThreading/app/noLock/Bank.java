/**
 * 
 */
package com.MultiThreading.app.noLock;

/**
 * @author Sanjeev
 *
 */
public class Bank {
	public static final int MAX_ACCOUNT = 10;
    public static final int MAX_AMOUNT = 10;
    public static final int INITIAL_BALANCE = 100;
 
    private Account[] accounts = new Account[MAX_ACCOUNT];
 
    public Bank() {
    	//This will initialize all the bank account with initial balance
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = new Account(INITIAL_BALANCE);
        }
    }
 
    //Formating the message
    String message = "%s transfered amount Rs. %d from accountId ( %s ) to accountId ( %s ). Total balance of All Account: %d\n";
    
    //This method will be called by a thread for transfering amount from one account to another account
    public void transfer(int fromAccountId, int toAccountId, int amount) {
    	//We are checking the sufficiant balance in fromAccount, if yes then the transfer will take place
        if (amount <= accounts[fromAccountId].getBalance()) {
        	
            accounts[fromAccountId].withdraw(amount);//Withdrawn
            accounts[toAccountId].deposit(amount); //Deposited
            
            String threadName = Thread.currentThread().getName();//Taking out thread name to use in message that which has made this transaction
            System.out.printf(message, threadName, amount, fromAccountId, toAccountId, getTotalBalance());
        }
    }
 
	public int getTotalBalance() {
		int total = 0;

		for (int i = 0; i < accounts.length; i++) {
			total += accounts[i].getBalance();
		}

		return total;
	}
}
