/**
 * 
 */
package com.MultiThreading.app.imlicitLockThroughSynchronize;;

/**
 * @author Sanjeev 
 * 
 * This class represents a transaction task that can be executed
 *         by a thread.
 */
public class TransferTransactionThreadSafe1 implements Runnable {
	private BankThreadSafe1 bank;
	private int fromAccount;

	public TransferTransactionThreadSafe1(BankThreadSafe1 bank, int fromAccount) {
		this.bank = bank;
		this.fromAccount = fromAccount;
	}

	public void run() {
       //The controll will come here once a thread is started.
		while (true) {//It has been kept always true for continous execution
			int toAccount = (int) (Math.random() * BankThreadSafe1.MAX_ACCOUNT);//Selecting traget account randomly.

			//While a random selection of a target account, it may select a fromAccount from which transaction is to be made
			if (toAccount == fromAccount)
				continue;//It will send the control in the loop again and select the target account different from fromAccount

			int amount = (int) (Math.random() * BankThreadSafe1.MAX_AMOUNT);//It will select a random amount less than or equal to 10

			if (amount == 0)
				continue;//If the selected amount is 0, let it go in the loop again for selecting valid amount value

			bank.transfer(fromAccount, toAccount, amount);//Transfer amount

			try {
				Thread.sleep(10);//After transfering  amount, let the thread sleep for 10 milli seconds
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}