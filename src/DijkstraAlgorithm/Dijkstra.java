package DijkstraAlgorithm;
// This program solves the shortest path problem using Dijkstra's
// algorithm.  It finds the shortest path from the top vertex to every
// other vertex in the list.  The input file begins with the number of
// nodes in the graph (n), followed by the name of each node (one per
// line), followed by an nxn grid in which the i-j entry gives the
// weight of the edge from vertex i to vertex j.  
//
// To use the program, type java Dijkstra <file>

public class Dijkstra
{
  public static void main(String[] args)
  {
    if (args.length == 0)
    {
      System.out.println ("USAGE: java Dijkstra <files>");
      System.exit(-1);
    }

    Graph g;

    for (String file : args)
    {
      g = new Graph(file);
      System.out.println(file);
      g.dijkstra();
      System.out.println();
    }
  }
}


