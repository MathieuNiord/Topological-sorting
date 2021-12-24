/* Authors: Frejoux Gaetan & Niord Mathieu */

/* --------------------------------------
| This class corresponds to a graph.     |
| A graph consists of an order (integer) |
| and a bounded array of vertices.       |
 ---------------------------------------- */

public class Graph {

    // --- Attributes ---
    private final int order_;
    private final Vertex[] vertices_;

    // --- Constructor ---
    public Graph(int order) {
        this.order_ = order;
        this.vertices_ = new Vertex[this.order_];
        for (int vertex = 1; vertex <= this.order_; vertex++)
            this.vertices_[vertex - 1] = new Vertex(vertex);
    }

    // --- Getters ---
    public int getOrder() {
        return this.order_;
    }
    public Vertex[] getVertices() {
        return this.vertices_;
    }

    // --- Setters ---
    public void addNeighbor(int source, int destination) {
        this.vertices_[source - 1].addNeighbor(this.vertices_[destination - 1]);
    }

    // --- Others ---
    public void topologicalSort() {
        // TODO : Topological sorting
    }

    // --- Display ---
    @Override
    public String toString() {
        // TODO : toString
        return "";
    }

}
