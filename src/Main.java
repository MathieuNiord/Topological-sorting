/* Authors: Frejoux Gaetan & Niord Mathieu */

/* ---------------------------------------------------
| This class corresponds to the main program that     |
| will be run at launch. It is from its main function |
| that the information necessary for the overall      |
| operation of the program will be retrieved and      |
| it is in this same function that the graph and      |
| its vertices will be instantiated.                  |
 ----------------------------------------------------- */

public class Main {

    /**
     * This method will get a graph in a text format from
     * which a Graph object and its vertices will be
     * instantiated. Then, the program will operate a
     * topological sort and display it.
     *
     * @param args : A file corresponding to a graph to sort
     */
    public static void main(String[] args) {

        Graph graph = Utils.initGraphWithInputs();

        graph.topologicalSort();

    }

}
