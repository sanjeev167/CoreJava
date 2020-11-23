/**
 * 
 */
package com;



/**
 * @author Sanjeev
 *
 */
public class BST_Main {
	
	public static void main(String[] args) {
		// create a BST object
		BinaryTree bst = new BinaryTree();
/* BST tree example
 * 
        45 
     /     \ 
    10      90 
   /  \    /   
  7   12  50   
  
 */

		//insert data into BST
        bst.add(45); 
        bst.add(10); 
        bst.add(7); 
        bst.add(12); 
        bst.add(90); 
        bst.add(50); 
        //print the BST
        System.out.println("The BST Created with input data(Left-root-right):"); 
        bst.dfs_inorder();     
        
        //search a key in the BST
        boolean ret_val = bst.containsNode(50);
        System.out.println("\nKey 50 found in BST:" + ret_val );
        ret_val = bst.containsNode(12);
        System.out.println("\nKey 12 found in BST:" + ret_val );
	}
}
