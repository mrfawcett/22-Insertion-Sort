import java.util.ArrayList;

/** PROVIDED -- do not change
 *
 * A driver, not a test. It sorts a few arrays and lists both ways and prints
 * the results so you can eyeball them while you work. Run it from your IDE.
 * The autograder never runs this file; only the JUnit tests count.
 */
public class InsertionSortRunner {

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 4, 3};
        testArray(a);

        int[] b = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        testArray(b);

        int[] c = {1, 2, 3, 100, 200, 300, -1, -2, -100, 1000, 4, 123, 973, 17, -25};
        testArray(c);

        int[] d = {1, 2, 5, 4, 3};
        testArrayList(d);

        int[] e = {10, 1, 9, 2, 8, 3, 7, 4, 6, 5};
        testArrayList(e);

        int[] f = {1, 2, 3, 100, 200, 300, -1, -2, -100, 1000, 4, 123, 973, 17, -25};
        testArrayList(f);
    }

    /** Sorts a copy of arr each way and prints both results. */
    public static void testArray(int[] arr) {
        int[] copy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = arr[i];
        }
        System.out.println("Array " + arrayPrint(arr));
        InsertionSort.sortLowToHigh(arr);
        System.out.println("   sorted low to high is " + arrayPrint(arr));
        InsertionSort.sortHighToLow(copy);
        System.out.println("   sorted high to low is " + arrayPrint(copy));
    }

    /** Copies arr into two ArrayLists, sorts one each way, prints both. */
    public static void testArrayList(int[] arr) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        for (int i = 0; i < arr.length; i++) {
            list1.add(arr[i]);
            list2.add(arr[i]);
        }
        System.out.println("ArrayList " + arrayPrint(arr));
        InsertionSort.sortLowToHigh(list1);
        System.out.println("   sorted low to high is " + arrayListPrint(list1));
        InsertionSort.sortHighToLow(list2);
        System.out.println("   sorted high to low is " + arrayListPrint(list2));
    }

    /** Returns the array on one line, e.g. "[1, 2, 5]". */
    public static String arrayPrint(int[] a) {
        String ret = "[";
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                ret += ", ";
            }
            ret += a[i];
        }
        return ret + "]";
    }

    /** Returns the list on one line, e.g. "[1, 2, 5]". */
    public static String arrayListPrint(ArrayList<Integer> a) {
        String ret = "[";
        for (int i = 0; i < a.size(); i++) {
            if (i > 0) {
                ret += ", ";
            }
            ret += a.get(i);
        }
        return ret + "]";
    }
}
