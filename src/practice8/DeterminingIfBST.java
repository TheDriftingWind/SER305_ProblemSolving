package practice8;

import java.util.Scanner;
import java.util.Stack;

public class DeterminingIfBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText(scan);
		int max = root.getData();
		int min = root.getData();
		Stack<BinaryTreeNode<Integer>> stack = new Stack<BinaryTreeNode<Integer>>();
		//preorder traversal
		//keep track of min and max in a subtree
		while(stack.empty()){
			BinaryTreeNode<Integer> tempNode = stack.peek();
			
			//subtree
			if(tempNode.getLeftChild().getData() < tempNode.getData()){
				//NOT BST
			}
			if(tempNode.getRightChild().getData() > tempNode.getData()){
				//NOT BST 
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
	}

}
