/* Authors: Frejoux Gaetan & Niord Mathieu */

/* --------------------------------------
| This class corresponds to a graph.     |
| A graph consists of an order (integer) |
| and a bounded array of vertices.       |
 ---------------------------------------- */

public class Graph {
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

    // --- Getters ---
    public int getOrder() {
        return this.order;
    }
    public Vertex[] getVertices() {
        return this.vertices;
    }


    // --- Others ---

    public void topologicSort(){

        MyLinkedList<Vertex> answer = new MyLinkedList<>();

        boolean loop = false;

        for(int i = 0 ; i < order ; i++)
            vertices[i].setState(State.GREEN);

        for(int i = 0 ; i < order ; i++){

            if(vertices[i].getState().equals(State.GREEN)){

                loop = topologicSortDFS(answer, vertices[i], null);

                if(loop) break;
            }
        }
        if(loop) System.out.print("Loop detected : ");
        else System.out.print("Topological sort : ");
        int size = answer.getSize();
        for(int i = 0; i < size-1 ; i++)
            System.out.print(answer.popHead().getName() + ", ");

        if(size>=0)
            System.out.println(answer.popHead().getName());
    }

    private boolean topologicSortDFS(MyLinkedList<Vertex> answer, Vertex current, Vertex dad) {

        current.setState(State.ORANGE);
        current.setDad(dad);
        for(Vertex successor : current.getNeighbors()){

            if(successor.getState().equals(State.GREEN) && topologicSortDFS(answer, successor, current))
                return true;

            if(successor.getState().equals(State.ORANGE)){

                answer.clean();

                Vertex loopElement = current;

                do {
                    answer.addHead(loopElement);
                    loopElement = loopElement.getDad();
                } while (loopElement != null && !loopElement.equals(successor));

                if( loopElement != null)
                    answer.addHead(loopElement);

                return true;
            }
        }

        current.setState(State.RED);

        answer.addHead(current);

        return false;
    }

    // --- Display ---
    @Override
    public String toString() {

        String vertices = "";
        for(int i = 0; i < order ; i++){
            vertices += '\t';
            vertices += this.vertices[i].toString();
            vertices += '\n';
        }
        return  "Order " + order + '\n' +
                "Vertices \n" + vertices + '\n';
    }
}
