package wilmol.leetcode.problemset.algorithms.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.function.ToIntFunction;

/**
 * Created by wilmol on 2020-06-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/the-k-strongest-values-in-an-array>https://leetcode.com/problems/the-k-strongest-values-in-an-array/</a>
 *
 * <p>Runtime: O(n * log(n))
 *
 * <p>Extra space: O(k)
 *
 * <p>Key: Sort first to get median.
 */
class P1471TheKStrongestValuesInAnArray {

  public int[] getStrongest(int[] arr, int k) {
    int n = arr.length;

    // get median
    Arrays.sort(arr);
    int m = (n - 1) / 2;
    int median = arr[m];

    // weakest at top of heap
    Comparator<Integer> comparator =
        (Comparator.comparingInt((ToIntFunction<Integer>) i -> Math.abs(i - median))
                .thenComparingInt(i -> i)
                .reversed())
            .reversed();
    PriorityQueue<Integer> heap = new PriorityQueue<>(comparator);

    // get k strongest in heap
    for (int i : arr) {
      heap.add(i);
      if (heap.size() > k) {
        heap.remove();
      }
    }

    // convert to required output
    int[] result = new int[k];
    int i = 0;
    // (iterator is faster than heap.remove)
    for (int ii : heap) {
      result[i++] = ii;
    }
    return result;
  }
}
