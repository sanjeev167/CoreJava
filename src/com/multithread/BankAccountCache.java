/**
 * 
 */
package com.multithread;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Sanjeev
 *
 */
public class BankAccountCache {
	public static Map<Integer, Account> bankAccountCaheMap=new HashMap<Integer, Account>();
	Account bankAccount;
	
	public Account getBankAccountObject(int accountNo) {
		

		bankAccount = bankAccountCaheMap.get(accountNo);
		if (bankAccount == null) {
			bankAccount = Bank.bankAccountList.get(accountNo - 1);//
			bankAccountCaheMap.put(accountNo, bankAccount);
			//System.out.println("\tAccount with id-"+accountNo+" is fetched from Bank-Account-List ");
		} else {
			;//System.out.println("\n\tAccount with id-"+accountNo+" is fetched from Bank-Account-Cache ");
		}
		
		Iterator it = BankAccountCache.bankAccountCaheMap.keySet().iterator();
		while (it.hasNext()) {
			Object object = (Object) it.next();
			//System.out.println("\t\tCurrent-Bank-Account-Cache has accountId-"+ BankAccountCache.bankAccountCaheMap.get(object).getAccountId());
		}
		return bankAccount;
	}

}
