/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class Factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		System.out.println("Factorial value of ("+n+") = "+fact(n));

	}
	
	private static int fact(int n) {
		if(n!=0)
			 return n*fact(n-1);
		else
		  return 1;
	}

}
