package practice8;

import java.util.Scanner;
import java.util.Stack;

public class DeterminingIfBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText(scan);
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> pointer = root;
		int last_number = 0;
		boolean isBST = true;
		//inorder traversal - will return all values in order if BST
		//start with left most leaf
		while(pointer != null){
			stack.push(pointer);
			pointer = pointer.getLeftChild();
		}
		//initiate the last_number to check against...
		last_number = stack.peek().getData();
		
		//perform inorder traversal
		while(!stack.isEmpty() && isBST){
			pointer = stack.pop();
			//check if the current value is greater than the last_number. It should be greater than the last_number since it should be inorder
			if(pointer.getData() < last_number){
				//if the current value is smaller, the tree is not balanced
				isBST = false;
			} else {
				//if the current value is greater, keep checking
				last_number = pointer.getData();
			}
			if(pointer.getRightChild() != null){
				pointer = pointer.getRightChild();
				while(pointer != null){
					stack.push(pointer);
					pointer = pointer.getLeftChild();
				}
			}
			
		}
		
		if(isBST){
			System.out.println("The tree IS a binary search tree.");
		} else {
			System.out.println("The tree IS NOT a binary search tree.");
		}
		
	}

}

/*
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * The worst case is if the algorithm needs to iterate through all the nodes in the inorder traversal
 * in the tree to confirm that it is a Binary Search Tree.
 */

/*
 * Space Complexity: O(h) where h is the height of the tree
 * In addition to the binary tree input, the algorithm uses 3 extra variables: 1 pointer, 1 integer, and a stack
 * The pointer and the integer use a constant amount of space. In the worst case, must store h number of nodes
 * in the stack. The algorithm stops inserting nodes into the stack when a leaf is reached and proceeds to
 * remove nodes from the stack. The stack will at worst contain h nodes.
 */