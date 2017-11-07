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
		//inorder traversal
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
			System.out.print("The tree IS a binary search tree");
		} else {
			System.out.print("The tree IS NOT a binary search tree");
		}
		
	}

}
