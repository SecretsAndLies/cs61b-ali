package IntList;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SquarePrimesTest {

    /**
     * Here is a test for isPrime method. Try running it.
     * It passes, but the starter code implementation of isPrime
     * is broken. Write your own JUnit Test to try to uncover the bug!
     */
    @Test
    public void testSquarePrimesSimple() {
        IntList lst = IntList.of(14, 15, 16, 17, 18);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("14 -> 15 -> 16 -> 289 -> 18", lst.toString());
        assertTrue(changed);
    }


    @Test
    public void testSquarePrimesOnePrime() {
        IntList lst = IntList.of(5, 9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("25 -> 9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesTwoPrimes() {
        IntList lst = IntList.of(22, 25, 13, 5, 9);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("22 -> 25 -> 169 -> 25 -> 9", lst.toString());
        assertTrue(changed);
    }

    @Test
    public void testSquarePrimesAllPrimes3() {
        IntList lst = IntList.of(7, 5, 11);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("49 -> 25 -> 121", lst.toString());
        assertTrue(changed);
    }


    @Test
    public void testSquarePrimesSinglePrime() {
        IntList lst = IntList.of(5);
        boolean changed = IntListExercises.squarePrimes(lst);
        assertEquals("25", lst.toString());
        assertTrue(changed);
    }

}
