/**
 * 
 */
package com.multithread;

import java.util.ArrayList;

/**
 * @author Sanjeev
 *
 */
public class Bank {

	public static ArrayList<Account> bankAccountList = new ArrayList<Account>();

	static final int INITIAL_BALLANCE = 100;

	public Bank() {
		for (int i = 0; i < 10; i++)
			bankAccountList.add(new Account(INITIAL_BALLANCE, i + 1));
	}

	synchronized boolean transfer(Account fromAccount, Account toAccount, int amountToBeTransfered) {
		boolean transferSuccess = false;

		int availableBallance = bankAccountList.get(fromAccount.getAccountId() - 1).getBallance();

		if (!fromAccount.equals(toAccount) && availableBallance > amountToBeTransfered) {

			int newBallanceInFromAccount = bankAccountList.get(fromAccount.getAccountId() - 1).getBallance()
					- amountToBeTransfered;
			bankAccountList.set(fromAccount.getAccountId() - 1,
					new Account(newBallanceInFromAccount, fromAccount.getAccountId()));

			int newBallanceInToAccount = bankAccountList.get(toAccount.getAccountId() - 1).getBallance()
					+ amountToBeTransfered;
			bankAccountList.set(toAccount.getAccountId() - 1,
					new Account(newBallanceInToAccount, toAccount.getAccountId()));

			transferSuccess = true;
		}
		System.out.println(Thread.currentThread().getName() + " transaction. From-AccountId-"
				+ fromAccount.getAccountId() + "[Bal-"
				+ bankAccountList.get(fromAccount.getAccountId() - 1).getBallance() + "] " + "To-AccountId-"
				+ toAccount.getAccountId() + "[Bal-" + bankAccountList.get(toAccount.getAccountId() - 1).getBallance()
				+ "] " + " Total = [" + checkTheSumTotalOfAllAccountBallence() + "]");
		return transferSuccess;
	}

	private synchronized int checkTheSumTotalOfAllAccountBallence() {
		// TODO Auto-generated method stub
		int sumTotalOfAllAccountBallance = 0;
		for (int i = 0; i < Bank.bankAccountList.size(); i++) {
			sumTotalOfAllAccountBallance = sumTotalOfAllAccountBallance + Bank.bankAccountList.get(i).getBallance();
		}
		return sumTotalOfAllAccountBallance;
	}

	boolean credit(Account toAccount, int amountToBeTransfered) {
		boolean creditSuccess = true;
		int newBallanceAfterCredit = toAccount.getBallance() + amountToBeTransfered;
		bankAccountList.set(toAccount.getAccountId() - 1,
				new Account(newBallanceAfterCredit, toAccount.getAccountId()));
		return creditSuccess;
	}

	boolean debit(Account toAccount, int amountToBeTransfered) {
		boolean debitSuccess = false;
		if (amountToBeTransfered < toAccount.getBallance()) {
			int newBallanceInToAccount = toAccount.getBallance() - amountToBeTransfered;
			bankAccountList.set(toAccount.getAccountId() - 1,
					new Account(newBallanceInToAccount, toAccount.getAccountId()));
			debitSuccess = true;
		}
		return debitSuccess;
	}

}
