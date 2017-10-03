package DijkstraAlgorithm;

// This class represents a graph; it includes an array of vertices and
// a two-dimensional array of weights of the edges between all pairs
// of vertices.
//
// Negative or zero weights imply an edge does not exist between two
// vertices.
//
// Class written by David Herscovici
// dijkstra() method and supporting methods written by Charles Zhu

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Graph {
	private ArrayList<Node> node;
	private double[][] edge;
	private int treeCount;

	public Graph(String file) {
		Scanner fileScanner = null;
		int i, j, n;

		try {
			fileScanner = new Scanner(new File(file));
		} catch (FileNotFoundException e) {
			System.out.println("File " + file + " does not exist");
		}
		n = fileScanner.nextInt();

		// We have to get past the line that included the value of n.
		fileScanner.nextLine();

		// Now read in the names of the nodes
		node = new ArrayList<Node>();
		for (i = 0; i < n; i++)
			node.add(i, new Node(fileScanner.nextLine()));

		// Now read in the weights of the edges
		edge = new double[n][n];
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				edge[i][j] = fileScanner.nextDouble();
	}

	// This method should use Dijkstra's algorithm to find and display
	// the shortest path from the first vertex in the file to every
	// other vertex in the graph. The results of the computation are
	// not saved or returned; they are only displayed to the screen.
	public void dijkstra() {
		// start by initializing the nodes
		node.get(0).setDistance(0);
		for (int j = 1; j < node.size(); j++) {
			node.get(j).setDistance(Double.POSITIVE_INFINITY);
		}

		// have a variable storing the last added node and the current node
		// we're looking at
		// [DELETE]Node lastNode = null;
		Node currentNode;

		// add the starting node.
		node.get(0).addToTree();
		treeCount = 1;
		currentNode = node.get(0);

		// begin checking and updating the nodes, stop when you reach the node
		// you want to
		// get to on the tree
		while (treeCount < node.size()) {
			// STEP 1: Update all of the distances
			for (int k = 0; k < node.size(); k++) {
				// make temporary variable to store distance
				double distance;
				// get the distance from current node to each node to update the
				// distance

				// Test Print: What is the distance from one node to another?
				// System.out.println(currentNode.toString() +
				// node.get(k).toString() + " Distance:"
				// +
				// edge[node.indexOf(currentNode)][node.indexOf(node.get(k))]);

				distance = edge[node.indexOf(currentNode)][node.indexOf(node.get(k))];
				// set distance to infinity if the distance read is 0
				if (distance == 0) {
					distance = Double.POSITIVE_INFINITY;
				}
				/*
				 * update the distance if the node is not already on the tree
				 * and the new distance is better also, update the parent
				 */
				if (distance + currentNode.distance() < node.get(k).distance() && node.get(k).isOnTree() != true) {
					node.get(k).setDistance(distance + currentNode.distance());
					node.get(k).setParent(currentNode);
				}
				// Test print: What is the distance of each node?
				// for (int r = 0; r < node.size(); r++) {
				// System.out.println(node.get(r).toString() +
				// node.get(r).distance());
				// }
			}

			// STEP 2: Check which node to pick to add to the tree

			// make a temporary node to decide which node to add to the tree
			// immediately make it a node that is not already on the tree or it
			// will compare against 0 and 0 will always win
			int best = 0;
			for (int d = 0; d < node.size(); d++) {
				if (node.get(d).isOnTree() == false) {
					best = node.indexOf(node.get(d));
				}
			}

			// go through each node
			for (int x = 0; x < node.size(); x++) {
				/*
				 * If the distance of the this node is better than the current
				 * best, update it. Exclude the nodes that are already on the
				 * tree from checking.
				 * Have a special case to prevent from adding a node that does not
				 * have a parent.
				 */
				if (node.get(x).distance() < node.get(best).distance() && node.get(x).isOnTree() != true && node.get(x).getParent() != null) {
					best = node.indexOf(node.get(x));
				}
				// Test Check: What is the best?
				// System.out.println("Index of Best:" + best);
			}
			// at the end, you will have the best node to add to the tree.

			// add the node to the tree
			node.get(best).addToTree();
			treeCount++;
			// update currentNode
			currentNode = node.get(best);
		}
		// By now, all the nodes should be updated to find the best path
		// initialize a variable to store the answer, to stop the checking loop,
		// and to store the node being checked
		String result = "";
		boolean stop = false;
		Node check = node.get(node.size() - 1);
		// Go follow the trial of parent nodes, adding the name of the node and
		// the distance
		while (stop == false) {
			if (check != node.get(0)) {
				result = result + check.toString() + "(" + check.distance() + ")" + ",";
				check = check.getParent();
			} else {
				// stop when you reach the starting node and don't add a comma
				// at the end
				result = result + check.toString() + "(" + check.distance() + ")";
				stop = true;
			}
		}
		// the result will be printed in reverse order
//		System.out.println("Reverse Order:" + result);
		
		//Fix the order
		String[] items = result.split(",");
		String finalresult = "";
		for (int g = items.length - 1; g >= 0; g--) {
			if (g != 0)
				finalresult = finalresult + (items[g]) + ",";
			else
				finalresult = finalresult + (items[g]);
		}
		System.out.println(finalresult);
	}
}
