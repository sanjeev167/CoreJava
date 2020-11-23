/**
 * 
 */
package com;

/**
 * @author Sanjeev
 *
 */
public class InsertionSort {

	/**
	 * In Insertion sort, we select one element as a key[start at index 1] and compare it with its all left elements one by one.
	 *  In each step, smaller will go one place back.The bigger will be at key for copying it at the smaller place. Now, the pointer from
	 *  the initial plcae i.e. j pointing at start will be reduced by 1 and once again compare with immediate left element of it. Iterate 
	 *  it until j reaches at -1 
	 *  
	 * 
	 */
	public static void main(String[] args) {
		int arr[] = {64, 34, 25, 12, 22, 11, 90};
		int n=arr.length;
		int key=0, j=0;
        for(int i=0;i<n;++i) {//Here, i has been post incremented so that key could be selected from i=1 place
        	
        	j=i;//j has been initialized with i so that while loop will start with j=1 or j pointing the key element
        	//We will compare key element arr[j] with its predecessor arr[j-1]. if predecessor is bigger from its successor, move predecessor 
        	//one place forward and preserve the key.Now, predecessor comes at successor.Then copy key at the predecessor place.
        	
        	while(j>0) {//This loop will shift key element at its right position
        		if(arr[j-1]>arr[j]) {
        		key=arr[j];//Preserve key element
        		//Make an space by pushing all the elements
        		arr[j]=arr[j-1];//Move predecessor at successor position. At this stage predecessor and successor have equal value
        		arr[j-1]=key;//Now, copy successor at predecessor position. which was preserved at key at its successor position 
        		}
        		j=j-1;//Now, reduce j by one in each while iteration so that a new key element will be selected 
        	}//while loop end
        	//If the selected key arr[j] i.e. arr[i] is at right place. The loop will go in the outer loop for selecting a new element.
        	//For each selected key element through outer loop, the inner while loop will again compare with its all left element as we did 
        	//earlier.        	
        }
        printArray(arr);

	}
	
	/* A utility function to print array of size n*/
    static void printArray(int arr[]) 
    { 
        int n = arr.length; 
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
  
        System.out.println(); 
    } 

}
