package ctci.chapterfour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    List<GraphNode> vertices;
    boolean isDirected;
    Map<GraphNode, Integer> vertexMap;

    public List<GraphNode> getVertices() {
        return vertices;
    }

    public Graph(boolean isDirected) {
        vertices = new ArrayList<>();
        vertexMap = new HashMap<>();
        this.isDirected = isDirected;
    }

    void addEdge(GraphNode n1, GraphNode n2) {
        if (vertexMap.get(n1) == null || vertexMap.get(n2) == null)
            throw new IllegalArgumentException();

        vertices.get(vertexMap.get(n1)).children.add(n2);
        // If graph is undirected, add reverse edge as well
        if (!isDirected) {
            vertices.get(vertexMap.get(n2)).children.add(n1);
        }
    }

    void initDefaultGraph() {
        // Directed graph
        // n1 -> n2 ->n3
        //       \n4/
        //
        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        addVertex(n1);
        addVertex(n2);
        addVertex(n3);
        addVertex(n4);

        addEdge(n1, n2);
        addEdge(n1, n3);
        addEdge(n2, n3);
        addEdge(n3, n4);
        addEdge(n4, n2);

    }

    void printGraph() {
        for (GraphNode vertex : vertices) {
            System.out.print(vertex.data + " : ");
            for (GraphNode child : vertex.children) {
                System.out.print(child.data + "->");

            }
            System.out.println();
        }
    }

    public void addVertex(GraphNode n) {
        vertices.add(n);
        vertexMap.put(n, vertices.size() - 1);
    }

    public void markAllNodesUnVisited() {
        for (GraphNode vertex : vertices) {
            vertex.isVisited = false;
        }

    }
}
