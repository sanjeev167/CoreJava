/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class ThreadE implements Runnable{
	SharedPrinterNew printer;
	SharedScannerNew scanner;
	
	public ThreadE(SharedPrinterNew printer,SharedScannerNew scanner) {		
		this.printer=printer;this.scanner=scanner;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		printer.getPrinter();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\t\t " + Thread.currentThread().getName() + " is waiting for locking on Scanner");

		scanner.getScanner();

	}

}
