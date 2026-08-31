import java.util.ArrayList;

/** READ FIRST
 *
 * Insertion Sort
 *
 * Four methods that sort IN PLACE. They return nothing; the array or list the
 * caller passed in is rearranged. Two directions (low-to-high, high-to-low)
 * times two containers (int[], ArrayList<Integer>).
 *
 * The algorithm (lecture 5.3 / CED 4.15). The part of the array before index
 * i is already sorted. Take element i out ("key"), slide the larger sorted
 * elements one step right, and drop the key into the hole.
 *
 *   for i from 1 to length - 1:
 *       key = a[i]
 *       j = i - 1
 *       while (j >= 0 && a[j] > key):      // j >= 0 MUST come first
 *           a[j + 1] = a[j]                // shift right
 *           j--
 *       a[j + 1] = key                     // drop the key into the hole
 *
 *   sortHighToLow: identical, but shift while a[j] < key.
 *
 * Trace sortLowToHigh({2, 5, 1, 6, 3}):
 *
 *   i=1  key=5   2 > 5? no                                  -> [2 5 1 6 3]
 *   i=2  key=1   5 > 1 shift -> [2 5 5 6 3]; 2 > 1 shift -> [2 2 5 6 3];
 *                j = -1, stop; a[0] = 1                     -> [1 2 5 6 3]
 *   i=3  key=6   5 > 6? no                                  -> [1 2 5 6 3]
 *   i=4  key=3   6 > 3 shift -> [1 2 5 6 6]; 5 > 3 shift -> [1 2 5 5 6];
 *                2 > 3? no, stop; a[2] = 3                  -> [1 2 3 5 6]
 *
 * Rules:
 *   - It must BE an insertion sort: grow a sorted prefix one element at a
 *     time by shifting. Any other sort passes the tests but earns 0 on the
 *     hand-graded 20% of this assignment.
 *   - Must work for length 0 and 1 (the outer loop does not run), for
 *     duplicates, and for negative numbers. Do not special-case them.
 *   - `j >= 0` must be checked BEFORE `a[j] > key`. && stops at the first
 *     false, so the array access never happens with j = -1. Reverse the order
 *     and the reverse-sorted test crashes with ArrayIndexOutOfBoundsException.
 *   - No Arrays.sort, Collections.sort, or streams.
 *   - ArrayList: read with get, write with set. Do not remove/add elements.
 *
 * InsertionSortRunner.java is a provided driver you can run to eyeball your
 * output. The autograder ignores it and runs only the tests.
 */
public class InsertionSort {

    /** COMPLETE THIS METHOD
     * Precondition: a is not null (may be empty).
     * Rearranges a into increasing order using insertion sort.
     *   {2, 5, 1, 6, 3} -> {1, 2, 3, 5, 6}      {4, 1, 4, 2, 1} -> {1, 1, 2, 4, 4}
     * Hint: outer for loop i from 1; inner while loop walks j leftward from i - 1.
     */
    public static void sortLowToHigh(int[] a) {
        // Insert your code below

    }

    /** COMPLETE THIS METHOD
     * Precondition: a is not null (may be empty).
     * Rearranges a into decreasing order using insertion sort.
     *   {2, 5, 1, 6, 3} -> {6, 5, 3, 2, 1}      {3, -7, 0, -1, 5} -> {5, 3, 0, -1, -7}
     * Hint: same loops; shift while a[j] < key instead.
     */
    public static void sortHighToLow(int[] a) {
        // Insert your code below

    }

    /** COMPLETE THIS METHOD
     * Precondition: a is not null (may be empty).
     * Rearranges a into increasing order using insertion sort.
     *   [3, 5, 6, 1, 2] -> [1, 2, 3, 5, 6]
     * Hint: int key = a.get(i); shift with a.set(j + 1, a.get(j)); finish with a.set(j + 1, key).
     *       a.get(j) > key unboxes the Integer for you.
     */
    public static void sortLowToHigh(ArrayList<Integer> a) {
        // Insert your code below

    }

    /** COMPLETE THIS METHOD
     * Precondition: a is not null (may be empty).
     * Rearranges a into decreasing order using insertion sort.
     *   [3, 5, 6, 1, 2] -> [6, 5, 3, 2, 1]
     */
    public static void sortHighToLow(ArrayList<Integer> a) {
        // Insert your code below

    }
}
