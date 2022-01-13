/* Authors: Frejoux Gaetan & Niord Mathieu */

/* -------------------------------------
| This class is a utility class.        |
| This is where all the "tools" methods |
| are defined.                          |
 --------------------------------------- */

import java.util.Scanner;

public class Utils {

    //Scanner for user's inputs
    public static final Scanner SCANNER = new Scanner(System.in);

    public static int getIntegerInput() {
        try {
            return SCANNER.nextInt();
        }
        catch (Exception e){
            SCANNER.nextLine();
            return getIntegerInput();
        }
    }

    public static boolean isValidOrderNumber(int value){
        return value > 0;
    }

    public static boolean isValidVertexNumber(int order, int value){
        return value >= 1 && value <= order;
    }

    public static boolean isValidSuccessor(int order, int current, int value){
        return isValidVertexNumber(order, value) && value != current;
    }

    /*

    The format of the user input must be as follows :

    order
    1 x1 ... xn 0
    2 y1 ... yn 0
    3 z1 ... zn 0
    .
    .
    .
    order a1 ... an 0

    where order correspond to how many vertex there is inside the graph.

    each line correspond to a specific vertex starting from 1 to order.

    Inside a line, after the vertex number there is every successor of this vertex.

    At the end of every line, there is the value 0 that represent the end of vertex' successors list.

    This format is strict. If there is a bad entry then the program stops with.
    */
    public static Graph initGraphWithInputs() {

        int order = getIntegerInput();

        if(!isValidOrderNumber(order))
            throw new RuntimeException("Invalid order value");

        //creating the graph with his order.
        Graph answer = new Graph(order);

        for(int i = 1 ; i <= order ; i++){

            int vertexNumber = getIntegerInput();

            if(vertexNumber != i)
                throw new RuntimeException("Invalid starting vertex value");

            if(!isValidVertexNumber(order, vertexNumber))
                throw new RuntimeException("Invalid vertex number");

            int successor = getIntegerInput();

            while(successor != 0){
                if(isValidSuccessor(order, i, successor)){
                    answer.addArrow(i,successor);
                    successor = getIntegerInput();
                }
                else throw new RuntimeException("Invalid successor value");
            }
        }
        return answer;
    }
}
