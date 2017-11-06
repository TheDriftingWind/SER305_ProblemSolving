package practice8;

import java.util.Scanner;
import java.util.Stack;

public class FindingFirstSmallerIntInBST {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int key = scan.nextInt();
		BinaryTreeNode<Integer> root = BinaryTreeUtilities.readBinaryTreeFromText(scan);
		boolean found = false;
		
		//System.out.println(key);
		//System.out.println(root.getData());
		
		//special cases
		if(root.getLeftChild() == null && root.getRightChild() == null) {
			if(root.getData() > key){
				System.out.print("There is no node in the BST whose value is smaller than the given key.");
			}
		}
		
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


