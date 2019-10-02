package ctci.chapterfour;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GraphNode {

    int data;
    List<GraphNode> children;
    boolean isVisited;

    public GraphNode(int data) {
        this.data = data;
        children = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphNode graphNode = (GraphNode) o;
        return data == graphNode.data;
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }
}
