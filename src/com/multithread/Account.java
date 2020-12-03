/**
 * 
 */
package com.multithread;

/**
 * @author Sanjeev
 *
 */
public class Account {
	
	private int ballance;
	private int accountId;
	
	public Account(int initialBallance,int accountId) {
		// TODO Auto-generated constructor stub
		this.ballance=initialBallance;
		this.accountId=accountId;
	}

	public boolean withdraw(int withdrawlAmount) {
		boolean withDralSuccess=false;
		if(ballance>withdrawlAmount) {
			ballance=ballance-withdrawlAmount; withDralSuccess=true;}
		return withDralSuccess;
		
	}

	public int getBallance() {
		return ballance;
	}

	public void setBallance(int ballance) {
		this.ballance = this.ballance+ballance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	

}
