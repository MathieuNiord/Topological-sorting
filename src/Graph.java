/**
 * This class corresponds to a graph.
 * A graph consists of an order (integer)
 * and a bounded array of vertices.
 * @author Gaetan Frejoux && Mathieu Niord
 */
public class Graph {

    private enum State {
        GREEN,
        ORANGE,
        RED
    }

    private class Vertex {

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

        // --- Others ---
        public void addSuccessor(Vertex successor){
            neighbors.addTail(successor);
        }
        // --- Display ---

    }

    // --- Attributes ---
    private final int order;
    private final Vertex[] vertices;

    // --- Constructor ---
    public Graph(int order) {
        this.order = order;
        this.vertices = new Vertex[order];
        for(int i = 1; i <= order; i++){
            this.vertices[i-1] = new Vertex(i);
        }
    }

    // --- Others ---
    public void addArrow(int from, int to){
        if(from < 1 || from > order || to < 1 || to > order)
            throw new IndexOutOfBoundsException();
        vertices[from-1].addSuccessor(vertices[to-1]);
    }

    public void topologicalSort(){

        MyLinkedList<Vertex> answer = new MyLinkedList<>();

        boolean loop = false;

        for(int i = 0 ; i < order ; i++)
            vertices[i].state = State.GREEN;

        for(int i = 0 ; i < order ; i++){

            if(vertices[i].state.equals(State.GREEN)){

                loop = topologicalSortDFS(answer, vertices[i], null);

                if(loop) break;
            }
        }
        if(loop) System.out.print("Loop detected : ");
        else System.out.print("Topological sort : ");
        int size = answer.getSize();
        for(int i = 0; i < size-1 ; i++)
            System.out.print(answer.popHead().name + ", ");

        if(size>=0)
            System.out.println(answer.popHead().name);
    }

    private boolean topologicalSortDFS(MyLinkedList<Vertex> answer, Vertex current, Vertex dad) {

        current.state = State.ORANGE;
        current.dad = dad;
        for(Vertex successor : current.neighbors){

            if(successor.state.equals(State.GREEN) && topologicalSortDFS(answer, successor, current))
                return true;

            if(successor.state.equals(State.ORANGE)){

                answer.clean();

                Vertex loopElement = current;

                do {
                    answer.addHead(loopElement);
                    loopElement = loopElement.dad;
                } while (loopElement != null && !loopElement.equals(successor));

                if( loopElement != null)
                    answer.addHead(loopElement);

                return true;
            }
        }

        current.state = State.RED;

        answer.addHead(current);

        return false;
    }

}
