/* Authors: Frejoux Gaetan & Niord Mathieu */

/* ---------------------------------------------------
| This class corresponds to the vertex of a graph.    |
| A vertex has a name, an adjacency list, and a color |
| (here represented by an integer, a vertex list,     |
| and an enumerated type).                            |
 ----------------------------------------------------- */

import java.util.ArrayList;

public class Vertex {

    // --- Attributes ---
    private final int name_;
    private final ArrayList<Vertex> neighbors_;
    private State state_;

    // --- Constructor ---
    public Vertex(int name) {
        this.name_ = name;
        this.neighbors_ = new ArrayList<>();
        this.state_ = State.GREEN;
    }

    // --- Getters ---
    public int getName() {
        return name_;
    }
    public ArrayList<Vertex> getNeighbors() {
        return neighbors_;
    }
    public State getState() {
        return state_;
    }

    // --- Setters ---
    public void addNeighbor(Vertex neighbor) {
        this.neighbors_.add(neighbor);
    }
    public void setState(State state_) {
        this.state_ = state_;
    }

    // --- Others ---

    // --- Display ---


    @Override
    public String toString() {
        return "Vertex{" +
                "name_=" + name_ +
                ", neighbors_=" + neighbors_ +
                ", state_=" + state_ +
                '}';
    }
}
