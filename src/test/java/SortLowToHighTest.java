import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class SortLowToHighTest {

    @DisplayName("sortLowToHigh: {2, 5, 1, 6, 3} -> {1, 2, 3, 5, 6}")
    @Test
    void sortLtoH_Test01() {
        int[] a = {2, 5, 1, 6, 3};
        int[] expected = {1, 2, 3, 5, 6};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "five distinct values should end up in increasing order");
    }

    @DisplayName("sortLowToHigh: two elements {6, 3} -> {3, 6}")
    @Test
    void sortLtoH_Test02() {
        int[] a = {6, 3};
        int[] expected = {3, 6};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "two out-of-order elements need exactly one swap");
    }

    @DisplayName("sortLowToHigh: {6, 3, 8, 1, 9, 2} -> {1, 2, 3, 6, 8, 9}")
    @Test
    void sortLtoH_Test03() {
        int[] a = {6, 3, 8, 1, 9, 2};
        int[] expected = {1, 2, 3, 6, 8, 9};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "six distinct values (even length) should end up in increasing order");
    }

    @DisplayName("sortLowToHigh: reverse-sorted {8, 6, 4, 2, 0} -> {0, 2, 4, 6, 8}")
    @Test
    void sortLtoH_Test04() {
        int[] a = {8, 6, 4, 2, 0};
        int[] expected = {0, 2, 4, 6, 8};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "worst-case input: every pass must move something");
    }

    @DisplayName("sortLowToHigh: single element {2} stays {2}")
    @Test
    void sortLtoH_Test05() {
        int[] a = {2};
        int[] expected = {2};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "one element is already sorted; the loops must not run or must be harmless");
    }

    @DisplayName("sortLowToHigh: empty array stays empty (must not crash)")
    @Test
    void sortLtoH_Test06() {
        int[] a = {};
        int[] expected = {};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "length 0: the outer loop bound is -1, so nothing should happen");
    }

    @DisplayName("sortLowToHigh: already sorted {1, 2, 3, 4, 5} stays the same")
    @Test
    void sortLtoH_Test07() {
        int[] a = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "sorted input must come out unchanged");
    }

    @DisplayName("sortLowToHigh: duplicates {4, 1, 4, 2, 1} -> {1, 1, 2, 4, 4}")
    @Test
    void sortLtoH_Test08() {
        int[] a = {4, 1, 4, 2, 1};
        int[] expected = {1, 1, 2, 4, 4};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "equal values must all survive; if one vanished you overwrote instead of swapping");
    }

    @DisplayName("sortLowToHigh: negatives {3, -7, 0, -1, 5} -> {-7, -1, 0, 3, 5}")
    @Test
    void sortLtoH_Test09() {
        int[] a = {3, -7, 0, -1, 5};
        int[] expected = {-7, -1, 0, 3, 5};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "negative numbers sort below zero; -7 is the smallest");
    }

    @DisplayName("sortLowToHigh: ten mixed values with repeats -> {-10, -3, -3, 0, 1, 5, 5, 7, 9, 12}")
    @Test
    void sortLtoH_Test10() {
        int[] a = {5, -3, 9, 0, -3, 12, 7, 1, 5, -10};
        int[] expected = {-10, -3, -3, 0, 1, 5, 5, 7, 9, 12};
        InsertionSort.sortLowToHigh(a);
        assertArrayEquals(expected, a,
            "a longer input with duplicates and negatives should still sort completely");
    }
}
