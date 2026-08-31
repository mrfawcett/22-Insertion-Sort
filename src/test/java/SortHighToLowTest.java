import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortHighToLowTest {

    @DisplayName("sortHighToLow: {2, 5, 1, 6, 3} -> {6, 5, 3, 2, 1}")
    @Test
    void sortHtoL_Test01() {
        int[] a = {2, 5, 1, 6, 3};
        int[] expected = {6, 5, 3, 2, 1};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "five distinct values should end up in decreasing order");
    }

    @DisplayName("sortHighToLow: two elements {5, 8} -> {8, 5}")
    @Test
    void sortHtoL_Test02() {
        int[] a = {5, 8};
        int[] expected = {8, 5};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "two out-of-order elements need exactly one swap");
    }

    @DisplayName("sortHighToLow: {6, 3, 8, 1, 9, 2} -> {9, 8, 6, 3, 2, 1}")
    @Test
    void sortHtoL_Test03() {
        int[] a = {6, 3, 8, 1, 9, 2};
        int[] expected = {9, 8, 6, 3, 2, 1};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "six distinct values (even length) should end up in decreasing order");
    }

    @DisplayName("sortHighToLow: ascending input {1, 3, 5, 7, 9} -> {9, 7, 5, 3, 1}")
    @Test
    void sortHtoL_Test04() {
        int[] a = {1, 3, 5, 7, 9};
        int[] expected = {9, 7, 5, 3, 1};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "worst-case input for a descending sort: every pass must move something");
    }

    @DisplayName("sortHighToLow: single element {8} stays {8}")
    @Test
    void sortHtoL_Test05() {
        int[] a = {8};
        int[] expected = {8};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "one element is already sorted; the loops must not run or must be harmless");
    }

    @DisplayName("sortHighToLow: empty array stays empty (must not crash)")
    @Test
    void sortHtoL_Test06() {
        int[] a = {};
        int[] expected = {};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "length 0: the outer loop bound is -1, so nothing should happen");
    }

    @DisplayName("sortHighToLow: already descending {9, 7, 5, 3, 1} stays the same")
    @Test
    void sortHtoL_Test07() {
        int[] a = {9, 7, 5, 3, 1};
        int[] expected = {9, 7, 5, 3, 1};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "input already in decreasing order must come out unchanged");
    }

    @DisplayName("sortHighToLow: duplicates {4, 1, 4, 2, 1} -> {4, 4, 2, 1, 1}")
    @Test
    void sortHtoL_Test08() {
        int[] a = {4, 1, 4, 2, 1};
        int[] expected = {4, 4, 2, 1, 1};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "equal values must all survive; if one vanished you overwrote instead of swapping");
    }

    @DisplayName("sortHighToLow: negatives {3, -7, 0, -1, 5} -> {5, 3, 0, -1, -7}")
    @Test
    void sortHtoL_Test09() {
        int[] a = {3, -7, 0, -1, 5};
        int[] expected = {5, 3, 0, -1, -7};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "negative numbers sort below zero; -7 comes last in decreasing order");
    }

    @DisplayName("sortHighToLow: ten mixed values with repeats -> {12, 9, 7, 5, 5, 1, 0, -3, -3, -10}")
    @Test
    void sortHtoL_Test10() {
        int[] a = {5, -3, 9, 0, -3, 12, 7, 1, 5, -10};
        int[] expected = {12, 9, 7, 5, 5, 1, 0, -3, -3, -10};
        InsertionSort.sortHighToLow(a);
        assertArrayEquals(expected, a,
            "a longer input with duplicates and negatives should still sort completely");
    }
}
