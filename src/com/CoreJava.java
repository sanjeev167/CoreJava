/**
 * 
 */
package com;

import java.util.Stack;

/**
 * @author Sanjeev
 *
 */
public class CoreJava {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1-5 => 1, 6-25=>2, 26-124=>3, 125-625=>4, 626-3125=>5
		int buckets=3126;
		int minutesToTest=60;
		int minutesToDie=15;
		double pigCount= Math.ceil(Math.log(buckets)/Math.log(minutesToTest/minutesToDie+1)); 
		
		System.out.println("Min. no. of pigs = "+pigCount);
	}

}
