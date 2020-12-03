/**
 * 
 */
package com.multithread;

import java.util.Iterator;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;



/**
 * @author Sanjeev
 *
 */
public class TransferTransactionThread implements Runnable {

	Bank bank;
	Account fromAccount;
	Account toAccount;
	int amountToBeTransfered;
	
	public TransferTransactionThread(Bank bank, Account fromAccount, Account toAccount, int amountToBeTransfered) {
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amountToBeTransfered = amountToBeTransfered;
		this.bank = bank;
	}

	

	@Override
	public void run() {		
		bank.transfer(fromAccount, toAccount, amountToBeTransfered);		
        //adjustBankAccountCache(fromAccount, toAccount);	
	}
	
	
	private void adjustBankAccountCache(Account fromAccount, Account toAccount) {
		// TODO Auto-generated method stub
		Iterator it = BankAccountCache.bankAccountCaheMap.keySet().iterator();

		if (BankAccountCache.bankAccountCaheMap.keySet().size() == 0) {
			System.out.println("\t\t\tBefore removing aacount from cache when [ " + Thread.currentThread().getName()
					+ " ] has completed its task. ### Current-Bank-Account-Cache ### has no account. Nothing to remove.");
		} else {
			while (it.hasNext()) {
				Object object = (Object) it.next();
				System.out.println("\t\t\tBefore removing aacount from cache when [ " + Thread.currentThread().getName()
						+ " ] has completed its task. ### Current-Bank-Account-Cache ### has accountId-"
						+ BankAccountCache.bankAccountCaheMap.get(object).getAccountId());
			}
			removeAccountFromCache(fromAccount, toAccount);
		}
	}

	private void removeAccountFromCache(Account fromAccount, Account toAccount) {

		// TODO Auto-generated method stub
		if (!Thread.holdsLock(fromAccount)) {
			System.out.println("\n\t\tCheck lock on FromAccount[ By-" + Thread.currentThread().getName()
					+ "]. No lock found . Remove FromAccount[accountId-" + fromAccount.getAccountId() + "] from cache");

			BankAccountCache.bankAccountCaheMap.remove(fromAccount.getAccountId());
			Iterator it = BankAccountCache.bankAccountCaheMap.keySet().iterator();

			if (!BankAccountCache.bankAccountCaheMap.keySet().iterator().hasNext())
				System.out.println("\t\t\tAfter removing fromAccount from Cache when ["
						+ Thread.currentThread().getName()
						+ "] is completed its task. ### Current-Bank-Account-Cache ### :-- No account in cache");

			while (it.hasNext()) {
				Object object = (Object) it.next();
				System.out.println(
						"\t\t\tAfter removing fromAccount from Cache. ### Current-Bank-Account-Cache ### has accountId-"
								+ BankAccountCache.bankAccountCaheMap.get(object).getAccountId());
			}
		}

		if (!Thread.holdsLock(toAccount)) {
			System.out.println("\n\t\tCheck lock on ToAccount[ By-" + Thread.currentThread().getName()
					+ "]. No lock found . Remove ToAccount[accountId-" + toAccount.getAccountId() + "] from cache");

			BankAccountCache.bankAccountCaheMap.remove(toAccount.getAccountId());
			Iterator it = BankAccountCache.bankAccountCaheMap.keySet().iterator();
			if (!BankAccountCache.bankAccountCaheMap.keySet().iterator().hasNext())
				System.out.println("\t\t\tAfter removing toAccount from Cache when [" + Thread.currentThread().getName()
						+ "] is completed its task. ### Current-Bank-Account-Cache ### :-- No account in cache");

			while (it.hasNext()) {
				Object object = (Object) it.next();
				System.out.println(
						"\t\t\tAfter removing toAccount from Cache. ### Current-Bank-Account-Cache ### has accountId-"
								+ BankAccountCache.bankAccountCaheMap.get(object).getAccountId());
			}
		}
	}

}
