/**
 * 
 */
package com.MultiThreading.app.noLock;

/**
 * @author Sanjeev
 * 
 * Once 10 transaction thread is started , each thread start selecting a random amount and random target account and start transfering money.
 * 
 *As there is no restriction of using account object i.e. any thread can use it any time, the balance inconsistency can be observed on the console. It is just because objects are not thread safe.
 */
public class TransactionTest {
    public static void main(String[] args) {
    	
        Bank bank = new Bank();//Created a bank object which will initialize all the account with initial balance
 
        //Here we are creating a transaction thread which will receive two parameters . one is bank object for having account information and a fromAccountId from which transaction is made
        for (int fromAccountId = 0; fromAccountId < Bank.MAX_ACCOUNT; fromAccountId++) {
        	//We have ten account and we are creating 10 threads. One thread for each account
            Thread t = new Thread(new TransferTransaction(bank, fromAccountId),"Thread Name -"+fromAccountId);            
            t.start();//When we start it , it will start a transaction 
        }
    }
}