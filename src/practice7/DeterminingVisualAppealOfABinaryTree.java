package practice7;

import java.util.Stack;

public class DeterminingVisualAppealOfABinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText();
		BinaryTreeNode<Integer> pointer = root;
		Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<BinaryTreeNode<Integer>>();
		int counter = 0;
		int min = 0;
		//Move the pointer to the left most node
		while(pointer != null){
			nodeStack.push(pointer);
			pointer = pointer.getLeftChild();
			counter = counter + 1;
		}
		counter -= 1;	//decrement to account for the while loop counting the starting node as 1
		int max = counter;
		min = counter;
		
		//add special case - algorithm won't check for a right side if none exists
		if(root.getRightChild() == null){
			min = 0;
		}
		
		//iterate through the stack
		while(!nodeStack.isEmpty()){
			//pop and store the node that was just popped from the stack
			pointer = nodeStack.pop();
			//If the node has a right child...
			if(pointer.getRightChild() != null){
				//get perform the same action of getting to the left most node 
				pointer = pointer.getRightChild();
				counter = counter + 1;
				//if there is no right child, this is the rightmost leaf
				if(pointer.getRightChild() == null){
					if(counter > max)
						max = counter;
					if(counter < min)
						min = counter;
				}
				//store the nodes in the stack as you pass them
				while(pointer != null){
					nodeStack.push(pointer);
					pointer = pointer.getLeftChild();
					counter = counter + 1;
				}
				counter -= 1; //decrement by one to get rid of the extra count of the first node
				if(counter > max)
					max = counter;
				if(counter < min)
					min = counter;
			} else {
				counter -= 1;
			}
		}
		
		//if the difference between the shortest and longest branch is greater than 1, it's not balanced
		if((max-min) > 1){
			System.out.print("The binary tree IS NOT visually appealing.");
		} else {
			System.out.print("The binary tree IS visually appealing.");
		}
	}
}

/*
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * The algorithm is in O(n) time complexity because it only needs to run an inorder traversal,
 * which does 1 pass through the tree of nodes. Thus, the number of actions the algorithm performs
 * depends on the number of nodes in the tree.
 */

/*
 * Space Complexity: O(h) where h is the height of the tree and l is the number of leaves
 * The space complexity is O(h) because the stack used to run the inorder traversal only holds a maximum
 * number of nodes equal to the height of the tree. It never has more nodes than the height because it stops
 * adding nodes when it reaches a leaf and removes nodes as it iterates.
 * The other variables used in addition are a constant amount of integers used to store values.
 */

/*
 * Pseudo Code:
 * 1.)Initialize a counter
 * 2.)Run an InOrder traversal...
 * 		when you move down to a child node, increment the counter by 1
 * 		when you move up to a parent node, decrement the counter by 1
 * 3.) When you reach a leaf, storage the value of the counter
 * 4.) After you finish the traversal...
 * 		check the array of stored heights.
 * 5.) Compare the highest and lowest heights stored.
 * 6.) If the difference between the highest and lowest heights stored is greater than 1...
 * 			Print "Binary tree IS NOT visually appealing"
 * 		else...
 * 			Print "Binary tree IS visually appealing"
 */