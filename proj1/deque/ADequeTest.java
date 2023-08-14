package deque;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
}
