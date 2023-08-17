package deque;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class MaxArrayTest {

    @Test
    public void testLongestString() {

        class StringLengthComparator implements Comparator<String> {
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        }
        
        StringLengthComparator sl = new StringLengthComparator();
        MaxArrayDeque<String> L = new MaxArrayDeque<>(sl);
        L.addFirst("a");
        L.addFirst("aa");
        L.addFirst("aaa");

        String s = L.max();
        assertEquals(s, "aaa");
    }
}
