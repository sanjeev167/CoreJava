/**
 * 
 */
package com.MultiThreading.app.imlicitLockThroughSynchronize;;

/**
 * @author Sanjeev
 * 
 * Once 10 transaction thread is started , each thread start selecting a random amount and random target account and start transfering money.
 * 
 *As there is a lock on bank object's transaction method and getTotalbalallance method, no thread could access it unless it is taking a lock on it.
 *
 *Only one locked method will be accessed at time by a thread
 *
 * 
 */
public class TransactionTestThreadSafe1 {
    public static void main(String[] args) {
    	
        BankThreadSafe1 bank = new BankThreadSafe1();//Created a sharable bank object for threads
 
        //Here we are creating a transaction thread which will receive two parameters . one is bank object for having account information and a fromAccountId from which transaction is made
        for (int fromAccountId = 0; fromAccountId < BankThreadSafe1.MAX_ACCOUNT; fromAccountId++) {
        	//We have ten account and we are creating 10 threads. One thread for each account
            Thread t = new Thread(new TransferTransactionThreadSafe1(bank, fromAccountId),"Thread Name -"+fromAccountId);            
            t.start();//When we start it , it will start a transaction 
           
        }
    }
}