package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements Iterable<T>, Deque<T> {
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private Node sentinel;
    private int size;

    /*
     * Creates an empty linked list deque.
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

//    public boolean equals(Object obj) {
//        if (!(obj instanceof LinkedListDeque)) {
//            return false;
//        }
//
//    }

    /* Adds an item of type T to the front of the deque.
        You can assume that item is never null.*/
    @Override
    public void addFirst(T item) {
        sentinel.next = new Node(item, sentinel.next, sentinel);
        if (sentinel.next.next != sentinel) {
            sentinel.next.next.prev = sentinel.next;
        } else { // otherwise, this is the first node ever added, and we need to set the last.
            sentinel.prev = sentinel.next;
        }

        size++;
    }

    /* Adds an item of type T to the back of the deque.
    You can assume that item is never null.*/
    @Override
    public void addLast(T item) {
        sentinel.prev = new Node(item, sentinel, sentinel.prev);
        if (sentinel.prev.prev != sentinel) {
            sentinel.prev.prev.next = sentinel.prev;
        } else { // otherwise, this is the first node ever added, and we need to set the first.
            sentinel.next = sentinel.prev;
        }
        size++;
    }

    /* Same as get, but uses recursion.*/
    public T getRecursive(int index) {
        return getRecursiveHelper(index, sentinel.next);
    }

    private T getRecursiveHelper(int index, Node currentNode) {
        if (index == 0) {
            return currentNode.item;
        }
        return getRecursiveHelper(index - 1, currentNode.next);
    }

    /*
        Returns the number of items in the deque.
    */
    @Override
    public int size() {
        return size;
    }

    /*Prints the items in the deque from first to last, separated by a space.
     Once all the items have been printed, print out a new line.
     */
    @Override
    public void printDeque() {
        Node currentNode = sentinel.next;
        while (currentNode != sentinel) {
            System.out.print(currentNode.item + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    /*Removes and returns the item at the front of the deque.
    If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        Node current = sentinel.next;
        if (current == sentinel) {
            return null;
        }

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;

        return current.item;
    }

    private boolean contains(T x) {
        for (T i : this) {
            if (i == x) {
                return true;
            }
        }
        return false;
    }

    /*Removes and returns the item at the back of the deque. If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        Node current = sentinel.prev;
        if (current == sentinel) {
            return null;
        }


        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size--;

        return current.item;
    }

    /*
        Gets the item˙ at the given index, where 0 is the front,
         1 is the next item, and so forth.
          If no such item exists, returns null. Must not alter the deque!
    */
    @Override
    public T get(int index) {
        Node currentNode = sentinel.next;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.item;
    }

    public Iterator<T> iterator() {
        return new LLIterator();
    }

    private class LLIterator implements Iterator<T> {
        private Node currentNode;

        LLIterator() {
            currentNode = sentinel.next;
        }

        public boolean hasNext() {
            return currentNode != sentinel;

        }

        public T next() {

            T returnItem = currentNode.item;
            currentNode = currentNode.next;
            return returnItem;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        } // optimization

        if (this.getClass() != o.getClass()) {
            return false;
        }
        LinkedListDeque<T> other = (LinkedListDeque<T>) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!this.get(i).equals(other.get(i))) {
                return false;
            }
        }
        return true;
    }


}
