/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class ThreadF implements Runnable {

	SharedPrinterNew printer;
	SharedScannerNew scanner;
	
	public ThreadF(SharedPrinterNew printer,SharedScannerNew scanner) {		
		this.printer=printer;this.scanner=scanner;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		scanner.getScanner();

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\t\t " + Thread.currentThread().getName() + " is waiting for locking on Printer");

		printer.getPrinter();

	}

}
