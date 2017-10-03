package DijkstraAlgorithm;
// This class represents a single node in a graph.  It also includes
// data to support the use of Dijkstra's algorithm

public class Node
{
  private String name;     // The name of the vertex
  private boolean onTree;  // Has the shortest path been found to this vertex?
  private double dist;     // The current shortest distance to this vertex
  private Node parent;     // The current parent of this node

  // constructor
  public Node(String nm)
  {
    name = nm;
    onTree = false;
    dist = 0;
    parent = null;
  }

  // Setters and getters
  public boolean isOnTree()
  {
    return onTree;
  }

  public void addToTree()
  {
    onTree = true;
  }

  public double distance()
  {
    return dist;
  }

  public void setDistance(double d)
  {
    dist = d;
  }

  public Node getParent()
  {
    return parent;
  }

  public void setParent(Node v)
  {
    parent = v;
  }

  public String toString()
  {
    return name;
  }
}
