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
		
		//add special case. The algorithm won't check for a right side if none exists
		if(root.getRightChild() == null){
			leafHeights.add(counter);
		}
		//Move the pointer to the left most node
		while(pointer.getLeftChild() != null){
			//store nodes in a stack to pop them in order
			nodeStack.push(pointer);
			pointer = pointer.getLeftChild();
			counter+=1;
		}
		nodeStack.push(pointer);
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
					counter += 1;
				}
				leafHeights.add(counter);
			} else {
				counter -= 1;
			}
		}
		
		//find the shortest branch and the longest branch
		int max = 0;
		int min = leafHeights.get(0);
		for(int i = 0; i < leafHeights.size(); i++){
			if(leafHeights.get(i) > max)
				max = leafHeights.get(i);
			if(leafHeights.get(i) < min)
				min = leafHeights.get(i);
		}
		
		//if the difference between the shortest and longest branch is greater than 1, it's not balanced
		if((max-min) > 1){
			System.out.println("The binary tree IS NOT visually appealing.");
		} else {
			System.out.println("The binary tree IS visually appealing.");
		}
	}
}
