/**
 * 
 */
package com;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Sanjeev
 *
 */
public class BinaryTree {

	 Node root;//This is the root node of the tree

	 /**
	  * This method is used for adding a node in a binary tree. It always receives two parameters. One is the root node and the value to create a new node in the 
	  * binary tree.
	  * */
	public void add(int value) {
		//A node will be created in BST recursively. It is so because, we have to find a right position for the new data in BST.
		root = addRecursive(root, value);
	}
	
	
	/**
	  * This is a recursive function which will keep calling itself with the current node and data.
	  * 
	  * Possibilities: 
	  * [1] If there is no root node in the tree. current node will be passed as null and a value to create a new node.
	  * [2] If the root exists, then current node and the value for new node will be passed. New node value will be compared with the value of the current node
	  *     Make a decision to go in left or right direction. This decision making will be done recursively unless or until we find a node which has no child.
	  *     Once, we find this node, then we check  whether it should be stored in its left or right.
	  *  
	  * This recursive method will put the new node in the right position. This position may be any where in BST.
	  * */
	private Node addRecursive(Node current, int value) {
		//Will create a node for a tree in all possible cases. This case is achieved while finding a right position within the tree.
		if (current == null) {
			return new Node(value);
		}

		if (value < current.value) {//Will go left side of the current node
			current.left = addRecursive(current.left, value);//Will go in left with left node and value. If current.left==null, then it will get a return value 
			                                                 // as a Node which will be stored in current.left. if current.left!=null, then the method will be called 
			                                                // recursively until current.left==null
			
			
		} else if (value > current.value) {// Will be called as it was called for left side traversal
			current.right = addRecursive(current.right, value);
		}else {
			//If the equality is the case i.e. the node exists already
			return current;
		}

		return current;
	}
	
	
    /**
	  * This method will be used for checking whether a particular node exists within a BST or node.
	  * 
	  * This method will also use a recursive method internally.
	  * */
	public boolean containsNode(int value) {
		return containsNodeRecursive(root, value);
	}
	/**
	  * This recursive method will keep calling itself internally as long as it doesn't find the node to be serached.
	  * */
	private boolean containsNodeRecursive(Node current, int value) {
        if (current == null) {//If there is no tree. Value to be searched is not available as there is no tree.
            return false;
        }
        //If the current node has this value return true as the value is found.
        //This current node value keeps changing in each recursive calls. Once the value is found, a true value is returned.
        if (value == current.value) {
            return true;
        }
        // Here we are using ternary operator to avoid multiple if /else.
        //On condition check value as true for left side or false for right side , recursive method is called to check the value availability in BST
        return value < current.value
          ? containsNodeRecursive(current.left, value)
          : containsNodeRecursive(current.right, value);
    }
	
	/**
	  * This is a method for delting a value in the BST. It is also internally getting a recursive method call. This recursive method will do the actual delete.
	  * 
	  * */
	public boolean delete(int value) {
		//If root is getting null value means the value has been deleted.
		root = deleteRecursive(root, value);
		if (root==null) return true;
		else return false;//value not found.
	}
	/**
	  * This is delete recursive method which will search and delete the \value
	  * */
	private Node deleteRecursive(Node current, int value) {
		//If the tree is not there
        if (current == null) {
            return null;
        }
       
        if (value == current.value) {
            // Case 1: no children
            if (current.left == null && current.right == null) {
                return null;
            }

            // Case 2: only 1 child. There are two possibilities of having one child. Actual deletion is not taking place here. 
            //We will pick its child 
            if (current.right == null) {
                return current.left;//If left node is returned, it means that its parent node which is current node 
                                    //[whose value matches with the value which is supposed to be deleted] is replaced by this left node and value is deleted 
            }

            if (current.left == null) {//Similar logic will be applied here as in the case of when current.right == null
                return current.right;//Means current node becomes current.right and current node is deleted
            }

            // Case 3: 2 children. It is the most complex case as it requires tree re-organization
            //Logic: Node is to be deleted is our currently our current node. So, for reorganizing the tree, we need to pick the smallest value on the right 
            // of this current node which will take the place of the node to be deleted i.e. current.value=smallestInRightOfCurrentNode.
            //Once, you find this smallestInRightOfCurrentNode, we replace the current.value with is value; but reorganization is still pending.
            
            int smallestInRightOfCurrentNode = findSmallestValue(current.right);
            current.value = smallestInRightOfCurrentNode;
            //Re-organization of tree. 
            //The right node has been shifted one level up and the requested node to be deleted's position is now occupied by this right smallest node.
            //The right node is still at its position so we need to reorganize it means delete all the node including this shifted node and construct this 
            //sub-tree again. This is possible when we delete it recursively, it will keep shifting one layer up and prepare the sub-tree.
            //So, change the current node i.e. replace the current node in recursive delete call and pass the value as smallestInRightOfCurrentNode which was
            //earlier found and has been placed at its right position. So, pass it in delete recursive call. This recursive call will delete and prepare the 
            //sub-tree.
            //current.right will receive a new node.
            current.right = deleteRecursive(current.right, smallestInRightOfCurrentNode);
            return current;
        }
        //This part will be used as long as the node with the value to be deleted is not found.
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        //This part will be used as long as the node with the value to be deleted is not found.But it is called when value < current.value fails
        //We can put within else part of above if statement
        current.right = deleteRecursive(current.right, value);        
        return current;
    }

	/**
	  * The right node of the node to be deleted will be passed to it. It has also been called recursively as long as we are not getting the smallest one.
	  * */
    private int findSmallestValue(Node root) {
    	//if root.left == null, root.value will become smaller one as its right will be bigger than root node
    	//if root.left != null, call this findSmallestValue () with root.left recursively and it will return the smallest node. Because as long as root.left==null
    	//we will not get the smallest one.
        return root.left == null ? root.value : findSmallestValue(root.left);
    }
    
    public void dfs_inorder() {
    	traverseInOrder(root);
    }
    
    public void dfs_preorder() {
    	traversePreOrder(root);
    }
    
    public void dfs_postorder() {
    	traversePostOrder(root);
    }

    /**
     * Depth-first search is a type of traversal that goes deep as much as possible in every child before exploring the next sibling.
     * DFS - Inorder
	  * This method is used to read the tree in sorted order. This is called in-order[Left Root Right] mode of reading .
	  * This method is also called recursively
	  * */
    public void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);  //if node.left ==null it will not visit further and it terminates and the control comes back at next level
            //i.e. for visit(node.value) and print it.         
            
            visit(node.value);
           //After printing leaf and its root, the control will go in the right direction for visiting and printing recursively
            traverseInOrder(node.right);
        }
    }

    /**
	  * DFS - Preorder
	  * Root left right
	  * */
    public void traversePreOrder(Node node) {
        if (node != null) {
            visit(node.value);//This is called for printing the node value
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    /**
	  * DFS - Postorder
	  * left right root
	  * */
    public void traversePostOrder(Node node) {
        if (node != null) {
            traversePostOrder(node.left);
            traversePostOrder(node.right);
            visit(node.value);
        }
    }

    /**
     * BFS
     * 
     * Nodes are visited level-wise i.e. all nodes at the same level are visited first before starting the next level.
     * 
     * 
	  * 
	  * */
    public void traverseLevelOrder() {
    	//When there is no tree
        if (root == null) {
            return;
        }
        //We are taking a queue with an objective of pushing nodes level-wise. Using the characteristics of Queue i.e. FIFO , 
        //We will take out node value for taking out level-wise
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);//Put first node as root

        while (!nodes.isEmpty()) {//loop will continue as lomg as it has data

            Node node = nodes.remove();//Take out one node from the queue

            System.out.print(" " + node.value);

            if (node.left != null) {//Start putting new node in queue from left
                nodes.add(node.left);
            }

            if (node.right != null) {//Start putting new node in queue from right. it will complete one level. 
                nodes.add(node.right);
            }
           //So final sequence of insertion of node in each loop is Root, Left, Right.
            //So, while taking out they will come out in the same order because of queue nature. Root, Left, Right.
        }
    }

    /**
	  * 
	  * */
    public void traverseInOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            while(current.left != null) {
                current = current.left;                
                stack.push(current);                
            }
            current = stack.pop();
            visit(current.value);
            if(current.right != null) {
                current = current.right;                
                stack.push(current);
            }
        }
    }
    
    /**
	  * 
	  * */
    public void traversePreOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node current = root;
        stack.push(root);
        while(! stack.isEmpty()) {
            current = stack.pop();
            visit(current.value);
            
            if(current.right != null)
                stack.push(current.right);
                
            if(current.left != null)
                stack.push(current.left);
        }        
    }
    /**
	  * 
	  * */
    public void traversePostOrderWithoutRecursion() {
        Stack<Node> stack = new Stack<Node>();
        Node prev = root;
        Node current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right || (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.value);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }   
    } 
    
    /**
	  * 
	  * */
	public boolean isEmpty() {
       return root == null;
   }

	/**
	  * 
	  * */
   public int getSize() {
       return getSizeRecursive(root);
   }
   /**
	  * This method is used to find the no. of nodes in the tree.
	  * If there is any node that means there is at least root node. So one corresponds to each root node that comes while visiting different node
	  * */
   private int getSizeRecursive(Node current) {
       return current == null ? 0 : getSizeRecursive(current.left) + 1 + getSizeRecursive(current.right);
   }
    /**
	  * 
	  * */
	private void visit(int value) {
		System.out.print(" " + value);
	}
}
