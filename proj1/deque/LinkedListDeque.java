package deque;

public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node next;
        public Node prev;

        public Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;
//    private Node last;

    /*
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, sentinel, sentinel);
    }

    /* Adds an item of type T to the front of the deque.
    You can assume that item is never null.*/
    public void addFirst(T item) {

        sentinel.next = new Node(item, sentinel.next, sentinel);
        if (sentinel.next.next != null) {
            sentinel.next.next.prev = sentinel.next;
        }

        size++;
    }

    /* Adds an item of type T to the back of the deque.
    You can assume that item is never null.*/
    public void addLast(T item) {

    }

    /* Same as get, but uses recursion.*/
//    public T getRecursive(int index) {
//    }

    /*
      Returns true if deque is empty, false otherwise.
    */
//    public boolean isEmpty() {
//    }

    /*
        Returns the number of items in the deque.
    */
//    public int size() {
//    }

    /*Prints the items in the deque from first to last, separated by a space.
     Once all the items have been printed, print out a new line.
     */
//    public void printDeque() {
//    }

    /*Removes and returns the item at the front of the deque.
    If no such item exists, returns null.
     */
//    public T removeFirst() {
//    }

    /*Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
//    public T removeLast() {
//    }

    /*
        Gets the item˙ at the given index, where 0 is the front,
         1 is the next item, and so forth.
          If no such item exists, returns null. Must not alter the deque!
    */
//    public T get(int index) {
//    }


    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(12);
        L.addFirst(13);
        L.addFirst(14);

    }
}
