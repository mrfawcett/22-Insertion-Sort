import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class SortLowToHighListTest {

    /** Builds an ArrayList<Integer> from an int[] so each test reads on one line. */
    private static ArrayList<Integer> listOf(int[] values) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int v : values) {
            list.add(v);
        }
        return list;
    }

    @DisplayName("sortLowToHigh list: [3, 5, 6, 1, 2] -> [1, 2, 3, 5, 6]")
    @Test
    void sortLtoH_Test01() {
        ArrayList<Integer> a = listOf(new int[] {3, 5, 6, 1, 2});
        ArrayList<Integer> expected = listOf(new int[] {1, 2, 3, 5, 6});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "five distinct values should end up in increasing order");
    }

    @DisplayName("sortLowToHigh list: two elements [8, 5] -> [5, 8]")
    @Test
    void sortLtoH_Test02() {
        ArrayList<Integer> a = listOf(new int[] {8, 5});
        ArrayList<Integer> expected = listOf(new int[] {5, 8});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "two out-of-order elements need exactly one swap (get/set)");
    }

    @DisplayName("sortLowToHigh list: [6, 3, 8, 1, 9, 2] -> [1, 2, 3, 6, 8, 9]")
    @Test
    void sortLtoH_Test03() {
        ArrayList<Integer> a = listOf(new int[] {6, 3, 8, 1, 9, 2});
        ArrayList<Integer> expected = listOf(new int[] {1, 2, 3, 6, 8, 9});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "six distinct values (even size) should end up in increasing order");
    }

    @DisplayName("sortLowToHigh list: reverse-sorted [9, 8, 7, 5, 1] -> [1, 5, 7, 8, 9]")
    @Test
    void sortLtoH_Test04() {
        ArrayList<Integer> a = listOf(new int[] {9, 8, 7, 5, 1});
        ArrayList<Integer> expected = listOf(new int[] {1, 5, 7, 8, 9});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "worst-case input: every pass must move something");
    }

    @DisplayName("sortLowToHigh list: single element [7] stays [7]")
    @Test
    void sortLtoH_Test05() {
        ArrayList<Integer> a = listOf(new int[] {7});
        ArrayList<Integer> expected = listOf(new int[] {7});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "one element is already sorted; the loops must not run or must be harmless");
    }

    @DisplayName("sortLowToHigh list: empty list stays empty (must not crash)")
    @Test
    void sortLtoH_Test06() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "size 0: the outer loop bound is -1, so nothing should happen");
    }

    @DisplayName("sortLowToHigh list: already sorted [1, 2, 3, 4, 5] stays the same")
    @Test
    void sortLtoH_Test07() {
        ArrayList<Integer> a = listOf(new int[] {1, 2, 3, 4, 5});
        ArrayList<Integer> expected = listOf(new int[] {1, 2, 3, 4, 5});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "sorted input must come out unchanged");
    }

    @DisplayName("sortLowToHigh list: duplicates [4, 1, 4, 2, 1] -> [1, 1, 2, 4, 4]")
    @Test
    void sortLtoH_Test08() {
        ArrayList<Integer> a = listOf(new int[] {4, 1, 4, 2, 1});
        ArrayList<Integer> expected = listOf(new int[] {1, 1, 2, 4, 4});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "equal values must all survive and the size must stay 5; use set, not remove/add");
    }

    @DisplayName("sortLowToHigh list: negatives [3, -7, 0, -1, 5] -> [-7, -1, 0, 3, 5]")
    @Test
    void sortLtoH_Test09() {
        ArrayList<Integer> a = listOf(new int[] {3, -7, 0, -1, 5});
        ArrayList<Integer> expected = listOf(new int[] {-7, -1, 0, 3, 5});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "negative numbers sort below zero; -7 is the smallest");
    }

    @DisplayName("sortLowToHigh list: ten mixed values with repeats -> [-10, -3, -3, 0, 1, 5, 5, 7, 9, 12]")
    @Test
    void sortLtoH_Test10() {
        ArrayList<Integer> a = listOf(new int[] {5, -3, 9, 0, -3, 12, 7, 1, 5, -10});
        ArrayList<Integer> expected = listOf(new int[] {-10, -3, -3, 0, 1, 5, 5, 7, 9, 12});
        InsertionSort.sortLowToHigh(a);
        assertEquals(expected, a,
            "a longer input with duplicates and negatives should still sort completely");
    }
}
