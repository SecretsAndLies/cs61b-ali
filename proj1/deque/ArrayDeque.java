package deque;

import java.util.Iterator;

public class ArrayDeque<T> implements Iterable<T>, Deque<T> {

    private int size;
    private T[] items;
    private int firstIndex;
    private int lastIndex;


    /*
     * Creates an empty deque.
     */
    public ArrayDeque() {
        size = 0;
        items = (T[]) new Object[8];
        firstIndex = 4;
        lastIndex = 4;
    }

    /*
     * Adds an item of type T to the front of the deque.
     * You can assume that item is never null.
     */
    @Override
    public void addFirst(T item) {
        if (isFull()) {
            resize(size * 2);
        }
        items[firstIndex] = item;

        if (isEmpty()) {
            lastIndex++;
        }
        firstIndex--;
        resetIndexesIfNeeded();
        size++;
    }

    /*
        wraps around last index at the start of the array if needed.
    */
    private void resetIndexesIfNeeded() {
        firstIndex = resetIndex(firstIndex);
        lastIndex = resetIndex(lastIndex);
    }

    private int resetIndex(int index) {
        if (index > items.length - 1) {
            return 0;
        }
        if (index < 0) {
            return items.length - 1;
        }
        return index;
    }

    /*
     * Adds an item of type T to the back of the deque.
     * You can assume that item is never null.
     */
    @Override
    public void addLast(T item) {
        if (isFull()) {
            resize(size * 2);
        }

        if (isEmpty()) {
            firstIndex--;
        }


        // write values
        items[lastIndex] = item;
        lastIndex++;
        resetIndexesIfNeeded();
        size++;
    }

    private void resize(int capacity) {
        T[] a = (T[]) new Object[capacity];
        int destStartAt = capacity / 3;
        int sourceStartAt = resetIndex(firstIndex + 1);
        for (int i = 0; i < size; i++) {
            int sourceIndex = (sourceStartAt + i) % items.length;
            int destIndex = destStartAt + i;
            a[destIndex] = items[sourceIndex];
        }
        firstIndex = destStartAt - 1;
        lastIndex = destStartAt + (size - 1) + 1;

        items = a;
    }

    /*
     * Prints the items in the deque from first to last,
     * separated by a space. Once all the items have been printed,
     * print out a new line.
     */
    @Override
    public void printDeque() {
        int start = resetIndex(firstIndex + 1);
        for (int i = 0; i < size; i++) {
            int itemIndex = (start + i) % items.length; // getting the length remainder ensures we don’t go out of bounds.
            System.out.print(items[itemIndex] + " ");
        }
        System.out.println();
    }

    /*
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeFirst() {
        if (size == 0) return null;

        int firstItemIndex = resetIndex(firstIndex + 1);

        T returnItem = items[firstItemIndex];
        items[firstItemIndex] = null;
        size--;
        if (isEmpty()) {
            lastIndex--;
        }
        firstIndex++;
        resetIndexesIfNeeded();
        resizeSmallerIfNeeded();
        return returnItem;

    }

    private void resizeSmallerIfNeeded() {
        double percentFull = size / (double) items.length;
        if (percentFull < 0.25 && items.length >= 16) {
            resize(items.length / 2);
        }
    }

    /*
     * Returns the number of items in the deque.
     */
    public int size() {
        return size;
    }


    /*
     * Removes and returns the item at the back of the deque.
     * If no such item exists, returns null.
     */
    @Override
    public T removeLast() {
        if (size == 0) return null;
        int lastItemIndex = resetIndex(lastIndex - 1);

        T returnItem = items[lastItemIndex];
        items[lastItemIndex] = null;
        size--;
        if (isEmpty()) {
            firstIndex++;
        }
        lastIndex--;
        resetIndexesIfNeeded();
        resizeSmallerIfNeeded();
        return returnItem;

    }

    /*
     * Gets the item at the given index, where 0 is the front,
     * 1 is the next item, and so forth. If no such item exists,
     * returns null. Must not alter the deque!
     */
    @Override
    public T get(int index) {
        int actualIndex = (index + firstIndex + 1) % items.length;
        if (index > size) return null;
        return items[actualIndex];
    }

    public Iterator<T> iterator() {
        return new ArrayIterator();

    }

    private class ArrayIterator implements Iterator<T> {
        private int pos;
        private int i;

        public ArrayIterator() {
            pos = (firstIndex + 1) % items.length;
            i = 0;
        }

        public boolean hasNext() {
            return i < size;

        }

        public T next() {
            pos = (firstIndex + 1 + i) % items.length;
            T returnItem = items[pos];
            pos++;
            i++;
            return returnItem;
        }
    }

    public boolean contains(T i) {
        for (T v : this) {
            if (v == i) return true;
        }
        return false;
    }

    public boolean equals(Object o) {
        if (o == null) return false;
        if (this == o) {
            return true;
        } // optimization

        if (this.getClass() != o.getClass()) {
            return false;
        }
        ArrayDeque<T> other = (ArrayDeque<T>) o;
        if (this.size() != other.size()) {
            return false;
        }
        for (T item : this) {
            if (!other.contains(item)) {
                return false;
            }
        }
        return true;
    }

    /*
        returns if the array is full.
    */
    private Boolean isFull() {
        return size == items.length;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        for (int i = 0; i < 1; i++) {
            L.addLast(i);
        }
        for (int i : L) {
            L.removeLast();
        }
//        System.out.println(L.contains(101));
    }
}
