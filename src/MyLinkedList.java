import java.util.Iterator;

/**
 * This class is used to store a collection of elements.
 * @param <T> type of the element stored
 * @author Gaetan Frejoux && Mathieu Niord
 */
public class MyLinkedList<T> implements Iterable<T>{


    /**
     * This class represent a node of the MyLinkedList
     * where there is an element stored.
     * @param <T> type of the element stored
     * @author Gaetan Frejoux && Mathieu Niord
     */
    private static class MyLinkedListNode<T>{
        private final T element;
        private MyLinkedListNode<T> prev;
        private MyLinkedListNode<T> next;

        MyLinkedListNode(T element){
            this.element = element;
            this.prev = null;
            this.next = null;
        }
    }

    /**
     * This class represent an Iterator for the MyLinkedList class.
     * @author Gaetan Frejoux && Mathieu Niord
     */
    private class MyLinkedListIterator implements Iterator<T> {

        private MyLinkedListNode<T> curr = head;

        public boolean hasNext() {
            return curr != null;
        }

        public T next() {
            T ans = curr.element;
            curr = curr.next;
            return ans;
        }

        public void remove() {
            throw new UnsupportedOperationException("not supported yet");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator();
    }

    private MyLinkedListNode<T> head;
    private MyLinkedListNode<T> tail;
    private int size;
    /**
     * Initialize an empty MyLinkedList
     */
    MyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    /**
     * @return the size of the list
     */
    public int getSize() {
        return size;
    }

    /**
     * Add the element at the beginning of the list
     * @param element element that will be added to the list
     */
    public void addHead(T element){
        size++;
        if(head == null){
            head = new MyLinkedListNode<T>(element);
            tail = head;
        }
        else {
            MyLinkedListNode<T> newHead = new MyLinkedListNode<T>(element);
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
    }

    /**
     * Add the element at the end of the list
     * @param element element that will be added to the list
     */
    public void addTail(T element){
        size++;
        if(tail == null){
            tail = new MyLinkedListNode<T>(element);
            head = tail;
        }
        else{
            MyLinkedListNode<T> newTail = new MyLinkedListNode<T>(element);

            tail.next = newTail;
            newTail.prev = tail;
            tail = newTail;

        }
    }

    /**
     * @exception EmptyMyLinkedListException If the list is empty.
     * @return the head of the list
     */
    public T popHead() {

        if(head == null) throw new EmptyMyLinkedListException();

        size--;

        T answer = head.element;

        head = head.next;

        if(head != null){
            head.prev = null;
        }
        else {
            tail = null;
        }

        return answer;
    }

    /**
     * @exception EmptyMyLinkedListException If the list is empty.
     * @return the head of the list
     */
    public T popTail() {

        if(tail == null) throw new EmptyMyLinkedListException();

        size--;

        T answer = tail.element;

        tail = tail.prev;

        if(tail != null){
            tail.next = null;
        }
        else {
            head = null;
        }

        return answer;
    }

    public void clean(){
        head = null;
        tail = null;
        size = 0;
    }
}
