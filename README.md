# Insertion Sort

**Unit 5 — Searching and Sorting** · Pairs with lecture 5.3 Insertion Sort (Feb 16/17) · CED 4.15

Insertion sort is how you sort a hand of cards. Cards to your left are in
order. Pick up the next card, slide it left past every card bigger than it,
drop it in the gap. Repeat until you run out of cards. Like selection sort it
is *n²* in the worst case, but on nearly-sorted input it is nearly linear,
and it is the other sort the AP exam asks you to trace by hand.

You write it four times: low-to-high and high-to-low, for `int[]` and for
`ArrayList<Integer>`. The first one is the work; the other three are edits.

---

## What you are given

| File | Status | Purpose |
|---|---|---|
| `src/main/java/InsertionSort.java` | **you complete this** | the four sort methods |
| `src/main/java/InsertionSortRunner.java` | provided | a driver that prints a few arrays before and after; not graded |
| `src/test/java/*Test.java` | provided | the autograder's tests — read them |
| `pom.xml`, `grading.json` | provided | build and grading setup — do not edit |

Run `InsertionSortRunner` from your IDE while you work. The autograder never
runs it; only the tests count.

## What to write

All four methods return `void` and sort **in place**: the caller's array or
list is rearranged.

| Method | Points | What it does |
|---|---|---|
| `static void sortLowToHigh(int[] a)` | 25 | Rearranges `a` into increasing order. |
| `static void sortHighToLow(int[] a)` | 20 | Rearranges `a` into decreasing order. |
| `static void sortLowToHigh(ArrayList<Integer> a)` | 20 | Increasing order, for an `ArrayList<Integer>`. |
| `static void sortHighToLow(ArrayList<Integer> a)` | 15 | Decreasing order, for an `ArrayList<Integer>`. |
| *Algorithm is the one named (insertion sort)* | 20 | Graded by hand — see below. |

### The algorithm

Everything before index `i` is sorted. Take `a[i]` out and call it `key`.
Walk left from `i - 1`, shifting every element bigger than `key` one step to
the right. When you find one that is not bigger (or fall off the left end),
drop `key` into the hole.

```
for i from 1 to length - 1:
    key = a[i]
    j = i - 1
    while (j >= 0 && a[j] > key):     // j >= 0 MUST be first
        a[j + 1] = a[j]               // shift right
        j = j - 1
    a[j + 1] = key                    // drop into the hole
```

`sortHighToLow` is the same code shifting while `a[j] < key`.

### Worked example: `sortLowToHigh({2, 5, 1, 6, 3})`

| `i` | `key` | shifts | array after |
|---|---|---|---|
| 1 | 5 | 2 > 5? no | `2 5 1 6 3` |
| 2 | 1 | 5 > 1 shift, 2 > 1 shift, `j = -1` stop | `1 2 5 6 3` |
| 3 | 6 | 5 > 6? no | `1 2 5 6 3` |
| 4 | 3 | 6 > 3 shift, 5 > 3 shift, 2 > 3? no | `1 2 3 5 6` |

Notice `i = 1` and `i = 3` did no work: the key was already in place. That is
why insertion sort is fast on nearly-sorted data — and why an already-sorted
input makes exactly `length - 1` comparisons and zero shifts.

### The traps

- **`a[j] > key && j >= 0`** — the conditions in the wrong order. When `key`
  is the smallest so far, `j` walks down to `-1`, and `a[-1]` throws
  `ArrayIndexOutOfBoundsException` before `j >= 0` is ever checked. Write
  `j >= 0` **first**; `&&` stops evaluating at the first `false`. The
  reverse-sorted test (`{8, 6, 4, 2, 0}`) hits this on every pass.
- **Forgetting `a[j + 1] = key`** after the loop. The key is shifted over and
  lost; the duplicates test (`{4, 1, 4, 2, 1}`) shows you a wrong multiset.
- **Starting the outer loop at 0.** It works (`j = -1`, the `while` does
  nothing) but it is a wasted pass and reads as if you do not know why
  `i` starts at 1: the one-element prefix `a[0]` is already sorted.
- **Length 0 and 1.** `i = 1` is already past the end, so the outer loop
  never runs. Correct with no special case.

### ArrayList versions

Same loops. `a.size()` for `a.length`, `a.get(j)` for `a[j]`, and
`a.set(index, value)` to write.

```java
int key = a.get(i);
int j = i - 1;
while (j >= 0 && a.get(j) > key) {
    a.set(j + 1, a.get(j));
    j--;
}
a.set(j + 1, key);
```

`a.get(j) > key` unboxes the `Integer` — fine. Do **not** compare two
`Integer` objects with `==`, and do **not** use `remove`/`add` to move
elements. The list's size must never change while you sort.

## Note to the student: the algorithm IS the assignment

The tests can only see the result — a sorted array. They **cannot** tell
insertion sort from selection sort, bubble sort, `Arrays.sort`, or last
week's code with the class name changed. Any of those passes every test.

Any of those also earns **zero** on the hand-graded 20% of this assignment.
Your code must have the shape above: an outer loop from index 1, a `key`, an
inner loop that walks *left* through the sorted prefix shifting elements, and
one final write that drops the key. Your teacher reads the code.

## Examples

| Call | `a` afterward | Why |
|---|---|---|
| `sortLowToHigh({2, 5, 1, 6, 3})` | `{1, 2, 3, 5, 6}` | traced above |
| `sortHighToLow({2, 5, 1, 6, 3})` | `{6, 5, 3, 2, 1}` | same passes, shift while smaller |
| `sortLowToHigh({8, 6, 4, 2, 0})` | `{0, 2, 4, 6, 8}` | every key walks to index 0 — the `j >= 0` test |
| `sortLowToHigh({4, 1, 4, 2, 1})` | `{1, 1, 2, 4, 4}` | duplicates all survive |
| `sortHighToLow({3, -7, 0, -1, 5})` | `{5, 3, 0, -1, -7}` | negatives sort below 0 |
| `sortLowToHigh([])` | `[]` | nothing to do; must not crash |

## Running the tests

`mvn test` runs everything; `mvn test -Dtest=SortLowToHighTest` runs one
rubric line.

| Test class | Rubric line | Points |
|---|---|---|
| `SortLowToHighTest` | `sortLowToHigh(int[])` sorts correctly | 25 |
| `SortHighToLowTest` | `sortHighToLow(int[])` sorts correctly | 20 |
| `SortLowToHighListTest` | `sortLowToHigh(ArrayList<Integer>)` sorts correctly | 20 |
| `SortHighToLowListTest` | `sortHighToLow(ArrayList<Integer>)` sorts correctly | 15 |
| *(by hand)* | Algorithm is the one named: insertion sort | 20 |

The autograder awards a rubric line only when every test in that class passes.
Each class checks a random order, two elements, an even length, the
worst-case (reverse) order, one element, an empty input, an already-sorted
input, duplicates, negatives, and a ten-element mix.

## Suggested order

1. On paper, trace `sortLowToHigh({6, 3, 8, 1, 9, 2})` with the table above.
   Write down `j` at the moment each `while` stops.
2. `sortLowToHigh(int[])`. Run `SortLowToHighTest`. An
   `ArrayIndexOutOfBoundsException: Index -1` means your `&&` is backwards.
3. `sortHighToLow(int[])`. Copy, flip `>` to `<`. Run `SortHighToLowTest`.
4. `sortLowToHigh(ArrayList<Integer>)`. Copy the array version; replace
   `length`/`[]` with `size()`/`get`/`set`. Run `SortLowToHighListTest`.
5. `sortHighToLow(ArrayList<Integer>)`. Run everything, then run
   `InsertionSortRunner` and read the printout.

## Rules of the road

- AP Java subset only: arrays, `ArrayList`, `for`, `while`, `if`, `&&`. No
  `Arrays.sort`, `Collections.sort`, `List.sort`, streams, or `Comparator`.
- Do not change the method headers or `InsertionSortRunner`.
- Do not touch `src/test`, `pom.xml`, `grading.json`, or `.github`. The
  autograder checks that they are byte-identical to the template before it
  runs a single test; if they differ it stops and awards nothing, and the
  change shows up in the roster.
- The method must be an insertion sort — a sorted prefix that grows by one
  element per pass, by shifting. Selection sort from last week, or anything
  else, earns 0 on the 20% hand-graded line even though the tests pass.
