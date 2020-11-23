/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class BubbleSort {
	public static void main(String[] args) {
		// In Bubble sort, the first loop is used for iterating n-1 times. In each pass, one element is bubbled up by inner loop
		//by one position. At the end of inner loop, selected element from the outer loop will keep bubbling up by inner loop and take its position
		
		//The inner loop will keep swapping adjacent elements in each pass starting from 0 to n-1-passcount
		
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		printArray(arr);
		System.out.println("After Sorting");
		int temp;
		for(int i=0;i<arr.length-1;i++) {			
			for(int j=0; j<arr.length-1-i;j++) {
				if(arr[j]>arr[j+1]) {
					//Swap
					temp=arr[j];
					arr[j]=arr[j+1];//Pull back
					arr[j+1]=temp;//Let the bigger one go ahead
				}printArray(arr);
			}			
		}		
	}

	/* Prints the array */
	static void  printArray(int arr[])
    {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
	
}
