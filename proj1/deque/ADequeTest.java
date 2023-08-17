package deque;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ADequeTest {

    @Test
    public void testisEmpty() {
        ArrayDeque<Integer> L = new ArrayDeque<>();
        assertTrue(L.isEmpty());
        L.addFirst(12);
        assertFalse(L.isEmpty());
        L.addFirst(13);
        assertFalse(L.isEmpty());
    }

    @Test
    public void testGet() {

        ArrayDeque<Integer> L = new ArrayDeque<>();
        L.addFirst(0);
        int i = L.get(0);
        assertEquals(0, i);
        L.addFirst(1);
        int j = L.get(0);
        assertEquals(1, j);
        L.addFirst(2);
        int k = L.get(0);
        assertEquals(2, k);

    }


    @Test
    public void randomizedTest() {
        LinkedList<Integer> L = new LinkedList<>();
        ArrayDeque<Integer> B = new ArrayDeque<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 8);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                B.addLast(randVal);
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                assertEquals(size, B.size());
            } else if (operationNumber == 2) {
                // get(0)
                int size = L.size();
                if (size > 0) {
                    Integer lLast = L.get(0);
                    Integer bLast = B.get(0);
                    assertEquals(lLast, bLast);
                }
            } else if (operationNumber == 3) {
                // removeLast
                int size = L.size();
                if (size > 0) {
                    Integer lLast = L.removeLast();
                    Integer bLast = B.removeLast();
                    assertEquals(lLast, bLast);
                }
            } else if (operationNumber == 4) {
                // addFirst
                int randVal = StdRandom.uniform(0, 100);
                L.addFirst(randVal);
                B.addFirst(randVal);
            } else if (operationNumber == 5) {
                // removeFirst
                int size = L.size();
                if (size > 0) {
                    Integer lLast = L.removeFirst();
                    Integer bLast = B.removeFirst();
                    assertEquals(lLast, bLast);
                }
            } else if (operationNumber == 6) {
                // isEmpty
                assertEquals(L.isEmpty(), B.isEmpty());

            } else if (operationNumber == 7) {
                // isEmpty
                int randVal = StdRandom.uniform(0, 100);
                assertEquals(L.contains(randVal), B.contains(randVal));
            }


        }

    }


}
