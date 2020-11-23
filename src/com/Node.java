/**
 * 
 */
package com;



/**
 * @author Sanjeev
 *
 */
public class Node {
	// node class that defines BST node
	int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }
}
