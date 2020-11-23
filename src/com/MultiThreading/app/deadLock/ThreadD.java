/**
 * 
 */
package com.MultiThreading.app.deadLock;

/**
 * @author Sanjeev
 *
 */
public class ThreadD implements Runnable {

	SharedPrinter printer;
	SharedScanner scanner;
	
	public ThreadD(SharedPrinter printer,SharedScanner scanner) {		
		this.printer=printer;this.scanner=scanner;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
				synchronized(scanner) {
					scanner.getScanner();
					
					try {
						Thread.sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("\t\t "+Thread.currentThread().getName()+" is waiting for locking on Printer");
					synchronized(printer) {
						printer.getPrinter();
					}
				}
	}

}
