import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Dijkstra {
  static class Edge {
    int start;
    int end;
    int len;
    boolean snakeLadder;
    public Edge(int start, int end, int len) {
      this.start = start;
      this.end = end;
      this.len = len;
      snakeLadder = false;
    }
  }

  static class Node {
    String value;
    Set<Edge> edges;
    int weight;
    public Node(String val) {
      value = val;
      weight = Integer.MAX_VALUE;
      edges = new HashSet<>();
    }
    public void addEdge(Edge e) {
      edges.add(e);
    }
  }


  static Node nodes[] = new Node[101];
  public static void main(String args[]) throws IOException {
    BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    String temp = bfr.readLine();
    int tests = Integer.parseInt(temp);
    for (int j = 0; j < tests; ++j) {
      nodes[0] = new Node("0");
      for (int i = 1; i <= 100; ++i) {
        Node n = new Node(Integer.toString(i));
        if (i+1 <= 100) {
          n.addEdge(new Edge(i, i+1, 1));
        }
        if (i+2 <= 100) {
          n.addEdge(new Edge(i, i+2, 1));
        }
        if (i+3 <= 100) {
          n.addEdge(new Edge(i, i+3, 1));
        }
        if (i+4 <= 100) {
          n.addEdge(new Edge(i, i+4, 1));
        }
        if (i+5 <= 100) {
          n.addEdge(new Edge(i, i+5, 1));
        }
        if (i+6 <= 100) {
          n.addEdge(new Edge(i, i+6, 1));
        }
        nodes[i] = n;
      }
      int ladders = Integer.parseInt(bfr.readLine());
      for (int k = 0; k < ladders; ++k) {
        String s[] = bfr.readLine().split(" ");
        int st = Integer.parseInt(s[0]), en = Integer.parseInt(s[1]);
        nodes[st].edges.clear();
        Edge e = new Edge(st, en, 0);
        e.snakeLadder = true;
        nodes[st].addEdge(e);
      }
      ladders = Integer.parseInt(bfr.readLine());
      for (int k = 0; k < ladders; ++k) {
        String s[] = bfr.readLine().split(" ");
        int st = Integer.parseInt(s[0]), en = Integer.parseInt(s[1]);
        nodes[st].edges.clear();
        Edge e = new Edge(st, en, 0);
        e.snakeLadder = true;
        nodes[st].addEdge(e);
      }

      dijkstra();
    }
  }

  public static void dijkstra() {
    Set<Integer> added = new HashSet<Integer>();
    added.add(1);
    nodes[1].weight = 0;
    int parentStep, stepAdded, minCost;
    Edge addEdge = null;
    for (Node n : nodes)  {
      for (Edge e: n.edges) {
        if (nodes[e.end].weight > nodes[e.start].weight + e.len)  {
          nodes[e.end].weight = nodes[e.start].weight + e.len;
        }
        if (e.snakeLadder)  {
          if (e.start > e.end)  {
            for (int i = e.end; i < e.start; ++i) {
              Node n1 = nodes[i];
              for (Edge e1 : n1.edges)  {
                if (nodes[e1.end].weight > nodes[e1.start].weight + e1.len)  {
                  nodes[e1.end].weight = nodes[e1.start].weight + e1.len;
                }
              }
            }
          } else  {
            for (int i = e.end; i < 100; ++i) {
              Node n1 = nodes[i];
              for (Edge e1 : n1.edges)  {
                if (nodes[e1.end].weight > nodes[e1.start].weight + e1.len)  {
                  nodes[e1.end].weight = nodes[e1.start].weight + e1.len;
                }
              }
            }
          }
        }
      }
    }
    if (nodes[100].weight == Integer.MAX_VALUE)  {
      System.out.println(-1);
    } else  {
      System.out.println(nodes[100].weight);
    }
  }
}
