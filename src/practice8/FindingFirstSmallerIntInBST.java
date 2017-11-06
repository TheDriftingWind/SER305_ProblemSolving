package practice8;

import java.util.Scanner;
import java.util.Stack;

public class FindingFirstSmallerIntInBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText(scan);
		boolean found = false;

		
		//perform a preorder traversal
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		stack.push(root);
		
		while(stack.empty() == false && !found){
			BinaryTreeNode<Integer> tempNode = stack.peek();
			
			//check if the current node is == or < the key
			if(tempNode.getData() < key){
				System.out.print(tempNode.getData());
				//break while loop if found
				found = true;
			}
			//pop from stack
			stack.pop();
			//add left and right child
			if(tempNode.getLeftChild() != null){
				stack.push(tempNode.getLeftChild());
			}
			if(tempNode.getRightChild() != null){
				stack.push(tempNode.getRightChild());
			}
		}
		if(found == false){
			System.out.print("There is no node in the BST whose value is smaller than the given key.");
		}
		
		
	}
}

/*
 * Time Complexity: O(n) where n is the number of nodes
 * The algorithm performs a preorder traversal while performing a constant amount of
 * actions each iteration. In the worst case, the a full traversal needs to be performed
 * leading to a O(n) time complexity.
 */

/*
 * Space Complexity: O(h) where h is the height of the tree
 * The object that consumes the most amount of space is the stack of nodes.
 * The space complexity is in O(h) because the stack never contains more nodes
 * than the height of the tree. Nodes are no longer added once a leaf is reached.
 */

