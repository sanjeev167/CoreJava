/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class SelectionSort {

	/**
	 * In selection sort, we select one element and start comparing it with all right rest elements one by and keep swapping if 
	 * required for ascending or descending order. In first pass, one element is sorted 
	 * and place it at the beginning of the sub-sorted array. Once the element is placed at the beginning at the sorted
	 * sub-array, pick the new element and follow the same proceedure just before the last element
	 */
	public static void main(String[] args) {
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		int n=arr.length;
        for(int i=0;i<n-1;i++) {
        	int selIndex=i;
        	for(int j=i+1;j<n-1;j++) {        		
        		if(arr[selIndex]>arr[j]) {
        			//Swap it
        			int temp = arr[i];
        			arr[selIndex]=arr[j];
        			arr[j]=temp;
        		}
        	}printArray(arr);
        }
       // printArray(arr);
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
