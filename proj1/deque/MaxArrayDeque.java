package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    Comparator<T> d;

    // Creates a MaxArrayDeque with the given Comparator.
    public MaxArrayDeque(Comparator<T> c) {
        super();
        this.d = c;
    }

    // Returns the maximum element in the deque as governed by the previously given Comparator.
    // If the MaxArrayDeque is empty, simply return null.
    public T max() {
        if (isEmpty()) {
            return null;
        }
        T currentMax = this.get(0);
        for (T item : this) {
            if (d.compare(item, currentMax) > 0) {
                currentMax = item;
            }
        }
        return currentMax;
    }

    // Returns the maximum element in the deque as governed by the parameter java.util.Comparator c.
    // If the MaxArrayDeque is empty, simply return null.
    public T max(Comparator<T> c) {
        if (isEmpty()) {
            return null;
        }
        T currentMax = this.get(0);
        for (T item : this) {
            if (c.compare(item, currentMax) > 0) {
                currentMax = item;
            }
        }
        return currentMax;
    }

    public static void main(String[] args) {

    }
}
