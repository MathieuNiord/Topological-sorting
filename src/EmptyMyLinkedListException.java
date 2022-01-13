/**
 * This class is used to store a collection of elements.
 * @author Gaetan Frejoux && Mathieu Niord
 * @see java.lang.RuntimeException
 */
public class EmptyMyLinkedListException extends RuntimeException{
    EmptyMyLinkedListException(){
        super("Empty Stack");
    }
}
