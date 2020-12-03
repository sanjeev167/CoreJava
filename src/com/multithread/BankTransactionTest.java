/**
 * 
 */
package com.multithread;



/**
 * @author Sanjeev
 *
 */
public class BankTransactionTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank bank=new Bank();
		//for(int i=0;i<10;i++)
		//System.out.println("Account Id = "+Bank.bankAccountList.get(i).getAccountId()+" Ballance = "+bank.bankAccountList.get(i).getBallance());
		
		BankAccountCache bankAccountCache=new BankAccountCache();
	
	       for(int i=1;true;i++) {
	    	   int fromAccountId = (int) (Math.random() * 10);
	    	   int toAccountId = (int) (Math.random() * 10);
	    	   if(fromAccountId==0)fromAccountId=1;
	    	   if(toAccountId==0)toAccountId=1;
	    	   Account fromAccount=bankAccountCache.getBankAccountObject(fromAccountId);
	    	   Account toAccount=bankAccountCache.getBankAccountObject(toAccountId);
	    	   int amountToBeTransfered=10;	    	 
			   new Thread(new TransferTransactionThread(bank,fromAccount,toAccount, amountToBeTransfered),"Thread-"+i).start(); 
			   
			
	       }
			
	}

}
