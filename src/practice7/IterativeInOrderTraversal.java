package practice7;

import java.util.Stack;

public class IterativeInOrderTraversal {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText();
		BinaryTreeNode<Integer> pointer = root;
		Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<BinaryTreeNode<Integer>>();
		
		//Move the pointer to the left most node
		while(pointer.getLeftChild() != null){
			//store nodes in a stack to pop them in order
			nodeStack.push(pointer);
			pointer = pointer.getLeftChild();
		}
		nodeStack.push(pointer);
		
		//iterate through the stack
		while(!nodeStack.isEmpty()){
			//pop and store the node that was just popped from the stack
			pointer = nodeStack.pop();
			System.out.print(pointer.getData() + " ");
			//If the node has a right child...
			if(pointer.getRightChild() != null){
				//get perform the same action of getting to the left most node 
				pointer = pointer.getRightChild();
				//store the nodes in the stack as you pass them
				while(pointer != null){
					nodeStack.push(pointer);
					pointer = pointer.getLeftChild();
				}
			}
		}
	}
}
