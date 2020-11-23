/**
 * 
 */
package com.MultiThreading;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author Sanjeev
 *
 */
public class HeavyWorkRunnable implements Runnable {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

	@Override
	public void run() {
		
		
		LocalDateTime now = LocalDateTime.now();
		System.out.println("\tDoing heavy processing - START at " + dtf.format(now) + " By "
				+ Thread.currentThread().getName() + " and slept for 1000 milli second");
		try {
			Thread.sleep(1000);
			// Get database connection, delete unused data from DB
			System.out.println("\t\t " + Thread.currentThread().getName() + " has awaken at " + dtf.format(now)
					+ " and going for doDBProcessing");
			doDBProcessing();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(
				"\tDoing heavy processing - END at " + dtf.format(now) + " By " + Thread.currentThread().getName());
	}
	
	
	
	
	

	private void doDBProcessing() throws InterruptedException {
		LocalDateTime now = LocalDateTime.now();
		
		Thread.sleep(5000);
		System.out.println("\t\t\t " + Thread.currentThread().getName() + " has once again slept at " + dtf.format(now)
				+ " for 5000 milli seconds.");
		
		System.out.println("\t\t\t\t " + Thread.currentThread().getName() + " awaken at " + dtf.format(now)
				+ " for completing db processing.");
		
		System.out.println("\t\t\t\t\tdoDBProcessing completed by " + Thread.currentThread().getName());
	}
	
	

}
