/* Authors: Frejoux Gaetan & Niord Mathieu */

/* ---------------------------------------------------
| This class corresponds to the vertex of a graph.    |
| A vertex has a name, an adjacency list, and a color |
| (here represented by an integer, a vertex list,     |
| and an enumerated type).                            |
 ----------------------------------------------------- */
public class Vertex {

    // --- Attributes ---
    private final int name;
    private final MyLinkedList<Vertex> neighbors;
    private State state;
    private Vertex dad;

    // --- Constructor ---
    public Vertex(int name) {
        this.name = name;
        this.neighbors = new MyLinkedList<>();
        this.state = State.GREEN;
    }

    // --- Getters ---
    public int getName() {
        return name;
    }
    public MyLinkedList<Vertex> getNeighbors() {
        return neighbors;
    }
    public State getState() {
        return state;
    }

    public Vertex getDad() {
        return dad;
    }

    // --- Setters ---
    public void setState(State state_) {
        this.state = state_;
    }

    public void setDad(Vertex dad) {
        this.dad = dad;
    }

    // --- Others ---
    public void addSuccessor(Vertex successor){
        neighbors.addTail(successor);
    }
    // --- Display ---

    @Override
    public String toString() {

        String neighbors = "";

        for(Vertex e : this.neighbors){
            neighbors += '[';
            neighbors += e.getName();
            neighbors += ']';
        }
        return  "[" + name + "]" +
                 " Neighbors " + neighbors +
                " State " + state;
    }
}
