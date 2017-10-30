package practice7;

import java.util.ArrayList;
import java.util.Stack;

public class DeterminingVisualAppealOfABinaryTree {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText();
		BinaryTreeNode<Integer> pointer = root;
		Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<BinaryTreeNode<Integer>>();
		int counter = 0;
		ArrayList<Integer> leafHeights = new ArrayList<Integer>();
		
		//add special case. The algorithm won't check for a right side on the root if none exists
		if(root.getRightChild() == null){
			leafHeights.add(counter);
		}
		//Move the pointer to the left most node
		while(pointer != null){
			nodeStack.push(pointer);
			pointer = pointer.getLeftChild();
			counter = counter + 1;
		}
		counter -= 1;	//decrement to account for the while loop counting the starting node as 1
		leafHeights.add(counter);
		
		
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
					leafHeights.add(counter);
				}
				//store the nodes in the stack as you pass them
				while(pointer != null){
					nodeStack.push(pointer);
					pointer = pointer.getLeftChild();
					counter = counter + 1;
				}
				counter -= 1; //decrement by one to get rid of the extra count of the first node
				leafHeights.add(counter);
			} else {
				counter -= 1;
			}
		}
		
		//find the shortest branch and the longest branch
		int max = 0;
		int min = leafHeights.get(0);
		for(int i = 0; i < leafHeights.size(); i++){
			//System.out.println("index[" + i + "] - " + leafHeights.get(i));
			if(leafHeights.get(i) > max)
				max = leafHeights.get(i);
			if(leafHeights.get(i) < min)
				min = leafHeights.get(i);
		}
		
		//System.out.println(max-min);
		//if the difference between the shortest and longest branch is greater than 1, it's not balanced
		if((max-min) > 1){
			System.out.print("The binary tree IS NOT visually appealing.");
		} else {
			System.out.print("The binary tree IS visually appealing.");
		}
	}
}

/*
 * Time Complexity: O(n) where n is the number of nodes
 */

/*
 * Space Complexity: O(h+l) where h is the height of the tree and l is the number of leaves
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