/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class Fibonacci {
	
	public static void main(String[] args) {		
		for(int i=0;i<11;i++) {
			int dp[]=new int[i+1];
		//System.out.println("("+i+")th Fibonacci no is "+fibonacci(i));
		//System.out.println("("+i+")th Fibonacci no is "+fibonacciRecr(i,dp));
		  System.out.println("F("+i+")th Febonaci no is "+fibonacciDPTopDown(i,dp));
	   //System.out.println("F("+i+")th Fibonacci no is "+fibonacciDPBottomUp(i));
		}
	}
	
	// This is approach is used with recursion approach to avoid duplicate
	// calculation
	private static int fibonacciDPTopDown(int n, int dp[]) {
		// 0,1,1,2,3,4,5,6,7,8,9
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		// The default value stored in dp array is zero. If it is zero, go for
		// calculation
		if (dp[n] != 0)
			return dp[n];
		 
		return	dp[n]=fibonacciDPTopDown(n - 1, dp) + fibonacciDPTopDown(n - 2, dp);
	}
	
	private static int fibonacciDPBottomUp(int n) {
		//Here , the size of DP array has been taken more than the number. It is so because first two numbers are fixed in
		//Fibonacci series. For storing them in advance it is required. Received value may be 0 or onward.
		//0,1,1,2,3,4,5,6,7,8,9	
		int DP[]=new int[n+2];
		DP[0]=0;
		DP[1]=1;	
		//As Fibonacci series start working from the 3rd element, so the loop is initialized with 2
		//In dynamic programming, all the intermediate calculation is saved in dynamic memory array for further usages.
		//Here, Fibonacci numbers are calculated through the value stored in DP. DP is filled with all the Fibonacci 
		//number using its first two base number.When the loop runs with starting value of i as 2 it starts taking DP[0]
		//and DP[1]. Once it is calculated the next loop will use the value stored in memory and this way it continue 
		//and finally, the final value is stored at DP[n] i.e. DP[i]. After braking the loop, i is equal to n.
		//Benefit of this approach is the repeated calculation is avoided and it is faster than recurssive approach.
		
		for(int i=2;i<n+1;i++) { DP[i]=DP[i-1]+DP[i-2];}		
		//printDP(n, fib);		
		return DP[n];
	}
		
	private static int fibonacciRecr(int n) {
		// TODO Auto-generated method stub
		//0,1,1,2,3,4,5,6,7,8,9		
		//Base value
		if(n==1) return 0;
		if(n==2) return 1;	
		
		//Understand the fact that how many duplicate recursive calls are made
		//For n=4
		//fibonacciRecr(4)=fibonacciRecr(3)+fibonacciRecr(2)
		//fibonacciRecr(3)=fibonacciRecr(2)+fibonacciRecr(1)
		//fibonacciRecr(2)=fibonacciRecr(1)
		//Here, fibonacciRecr(2) is called twice. This can be escaped using dynamic programming in recursion.
		
		return fibonacciRecr(n-1)+fibonacciRecr(n-2);
	}	
	
	//Brute force approach
	private static int fibonacci(int n) {
		// TODO Auto-generated method stub
		//0,1,1,2,3,4,5,6,7,8,9		
		int prev=1, prevPrev=0;
		//Base value
		if(n==1) return 0;
		if(n==2) return 1;
		int next=0;		
		for (int i=2;i<n;i++) {
			next=prev+prevPrev;
			prevPrev=prev;
			prev=next;
		}		
		return next;
	}
	
	private static void printDP(int n, int fib[]) {
		String x="";
		if(n==0)
			x=fib[0]+",";
		if(n==1)
			x=fib[0]+","+fib[1]+",";
		for (int i=2;i<n+1;i++) {
			if(i<n-1)
				x=x+fib[i]+",";
				else
					x=x+fib[i];
				System.out.println(x);
		}
	}
	
}
