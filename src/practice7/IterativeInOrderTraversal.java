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
/*
 * Time complexity O(n) where n = the number of nodes
 * The algorithm is in O(n) time complexity because the number of actions it performs depends on
 * how many nodes there are.
 * The algorithm iterates through each node only twice, 
 * once when it is added to the stack and once when it is removed from the stack.
 * For each node, it performs a constant action that prints to data of the node.
 */

/*
 * Space complexity O(h) where h = height of the tree
 * The algorithm is in O(h) space complexity because at any given time,
 * the maximum number of nodes that is stored in the node stack is equal to
 * the height of the tree. The algorithm stops adding to the stack whenever it hits
 * a leaf/node with no child, and never has any additional nodes than that as it proceeds to remove them.
 */

/*
 * Pseudo code:
 * 1.) Create an empty stack NodeStack
 * 2.) Set a node pointer to the root
 * 3.) While the pointer has a left child...
 * 		push the node at the pointer onto the NodeStack
 * 		move the pointer to the left child
 * 4.)Push the node at the pointer onto the NodeStack
 * (all nodes leading to the left-most leaf from the root should be on the stack)
 * 5.) Until the stack is empty...
 * 		move the pointer to the node on top of the stack, then pop the node from the stack
 * 		print the value of that node
 * 		If node at the pointer has a right child...
 * 			move the pointer to the right child
 * 			perform step 3
 * 6.) Once the stack is empty, you're done
 */

