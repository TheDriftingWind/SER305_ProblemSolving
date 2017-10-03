package DijkstraAlgorithm;
// This program solves the shortest path problem using Dijkstra's
// algorithm.  It finds the shortest path from the top vertex to every
// other vertex in the list.  The input file begins with the number of
// nodes in the graph (n), followed by the name of each node (one per
// line), followed by an nxn grid in which the i-j entry gives the
// weight of the edge from vertex i to vertex j.  
//
// To use the program, type java DijkstraPromptForFile <file>

import java.util.Scanner;

public class DijkstraPromptForFile
{
  public static void main(String[] args)
  {
    String file;
    Scanner keyboard = new Scanner(System.in);
    Graph g;

    System.out.print ("Enter the file name: ");
    file = keyboard.nextLine();

    g = new Graph(file);
    g.dijkstra();
    System.out.println();
  }
}


