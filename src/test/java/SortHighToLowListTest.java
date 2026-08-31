import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class SortHighToLowListTest {

    /** Builds an ArrayList<Integer> from an int[] so each test reads on one line. */
    private static ArrayList<Integer> listOf(int[] values) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int v : values) {
            list.add(v);
        }
        return list;
    }

    @DisplayName("sortHighToLow list: [3, 5, 6, 1, 2] -> [6, 5, 3, 2, 1]")
    @Test
    void sortHtoL_Test01() {
        ArrayList<Integer> a = listOf(new int[] {3, 5, 6, 1, 2});
        ArrayList<Integer> expected = listOf(new int[] {6, 5, 3, 2, 1});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "five distinct values should end up in decreasing order");
    }

    @DisplayName("sortHighToLow list: two elements [5, 8] -> [8, 5]")
    @Test
    void sortHtoL_Test02() {
        ArrayList<Integer> a = listOf(new int[] {5, 8});
        ArrayList<Integer> expected = listOf(new int[] {8, 5});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "two out-of-order elements need exactly one swap (get/set)");
    }

    @DisplayName("sortHighToLow list: [6, 3, 8, 1, 9, 2] -> [9, 8, 6, 3, 2, 1]")
    @Test
    void sortHtoL_Test03() {
        ArrayList<Integer> a = listOf(new int[] {6, 3, 8, 1, 9, 2});
        ArrayList<Integer> expected = listOf(new int[] {9, 8, 6, 3, 2, 1});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "six distinct values (even size) should end up in decreasing order");
    }

    @DisplayName("sortHighToLow list: ascending input [1, 5, 7, 8, 9] -> [9, 8, 7, 5, 1]")
    @Test
    void sortHtoL_Test04() {
        ArrayList<Integer> a = listOf(new int[] {1, 5, 7, 8, 9});
        ArrayList<Integer> expected = listOf(new int[] {9, 8, 7, 5, 1});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "worst-case input for a descending sort: every pass must move something");
    }

    @DisplayName("sortHighToLow list: single element [6] stays [6]")
    @Test
    void sortHtoL_Test05() {
        ArrayList<Integer> a = listOf(new int[] {6});
        ArrayList<Integer> expected = listOf(new int[] {6});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "one element is already sorted; the loops must not run or must be harmless");
    }

    @DisplayName("sortHighToLow list: empty list stays empty (must not crash)")
    @Test
    void sortHtoL_Test06() {
        ArrayList<Integer> a = new ArrayList<Integer>();
        ArrayList<Integer> expected = new ArrayList<Integer>();
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "size 0: the outer loop bound is -1, so nothing should happen");
    }

    @DisplayName("sortHighToLow list: already descending [9, 7, 5, 3, 1] stays the same")
    @Test
    void sortHtoL_Test07() {
        ArrayList<Integer> a = listOf(new int[] {9, 7, 5, 3, 1});
        ArrayList<Integer> expected = listOf(new int[] {9, 7, 5, 3, 1});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "input already in decreasing order must come out unchanged");
    }

    @DisplayName("sortHighToLow list: duplicates [4, 1, 4, 2, 1] -> [4, 4, 2, 1, 1]")
    @Test
    void sortHtoL_Test08() {
        ArrayList<Integer> a = listOf(new int[] {4, 1, 4, 2, 1});
        ArrayList<Integer> expected = listOf(new int[] {4, 4, 2, 1, 1});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "equal values must all survive and the size must stay 5; use set, not remove/add");
    }

    @DisplayName("sortHighToLow list: negatives [3, -7, 0, -1, 5] -> [5, 3, 0, -1, -7]")
    @Test
    void sortHtoL_Test09() {
        ArrayList<Integer> a = listOf(new int[] {3, -7, 0, -1, 5});
        ArrayList<Integer> expected = listOf(new int[] {5, 3, 0, -1, -7});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "negative numbers sort below zero; -7 comes last in decreasing order");
    }

    @DisplayName("sortHighToLow list: ten mixed values with repeats -> [12, 9, 7, 5, 5, 1, 0, -3, -3, -10]")
    @Test
    void sortHtoL_Test10() {
        ArrayList<Integer> a = listOf(new int[] {5, -3, 9, 0, -3, 12, 7, 1, 5, -10});
        ArrayList<Integer> expected = listOf(new int[] {12, 9, 7, 5, 5, 1, 0, -3, -3, -10});
        InsertionSort.sortHighToLow(a);
        assertEquals(expected, a,
            "a longer input with duplicates and negatives should still sort completely");
    }
}
