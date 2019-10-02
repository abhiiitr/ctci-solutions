package ctci.chapterfour;

import java.util.LinkedList;
import java.util.Queue;

public class RouteBetweenNodes {

    public static boolean findRouteBetweenNodes(Graph graph, GraphNode start, GraphNode end) {

        if (start == end)
            return true;

        Queue<GraphNode> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            GraphNode node = queue.poll();
            node.isVisited = true;
            if (node.data == end.data)
                return true;
            for (GraphNode child : node.children) {
                if (!child.isVisited) {
                    queue.add(child);
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(true);

        GraphNode n1 = new GraphNode(1);
        GraphNode n2 = new GraphNode(2);
        GraphNode n3 = new GraphNode(3);
        GraphNode n4 = new GraphNode(4);
        graph.addVertex(n1);
        graph.addVertex(n2);
        graph.addVertex(n3);
        graph.addVertex(n4);


        graph.addEdge(n1, n2);
        graph.addEdge(n1, n3);
        graph.addEdge(n2, n3);
        graph.addEdge(n3, n4);
//        graph.addEdge(n4, n2);
        graph.printGraph();

        System.out.println(findRouteBetweenNodes(graph, n2, n1));
        graph.markAllNodesUnVisited();
        System.out.println(findRouteBetweenNodes(graph, n1, n4));
        graph.markAllNodesUnVisited();
        System.out.println(findRouteBetweenNodes(graph, n3, n2));
    }
}
