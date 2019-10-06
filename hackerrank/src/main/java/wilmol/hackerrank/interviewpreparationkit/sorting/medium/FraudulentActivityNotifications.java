package wilmol.hackerrank.interviewpreparationkit.sorting.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by wilmol on 2019-10-06.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting>https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting</a>
 *
 * <p>Runtime: O(nd) (heap remove specific element is O(n))
 *
 * <p>Key: two heaps to track a running median
 *
 * @see wilmol.leetcode.problemset.algorithms.hard.P480SlidingWindowMedian (TODO its in the old
 *     project but not here)
 */
final class FraudulentActivityNotifications {

  private FraudulentActivityNotifications() {}

  // TODO not really sorting.. apparently 'count sort' can be used to pass the time limit

  static int activityNotifications(int[] expenditure, int d) {
    int count = 0;
    // sliding window of size d
    RunningMedian runningMedian = new RunningMedian();
    for (int i = 0; i < expenditure.length - 1; i++) {
      if (i >= d) {
        if (expenditure[i] >= 2 * runningMedian.median()) {
          count += 1;
        }
        // remove first element added such that window size is maintained on next add
        runningMedian.remove(expenditure[i - d]);
      }
      runningMedian.add(expenditure[i]);
    }
    return count;
  }

  /** Tracks a running median. */
  private static class RunningMedian {
    // minheap - store larger elements
    // maxheap - store smaller elements
    // keep them balanced in size (if odd size, max heap defaults to being larger)
    // such that removing from the heap(s) will provide easy median
    private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

    void add(int e) {
      // add to max heap first
      if (maxHeap.isEmpty() || e < maxHeap.peek()) {
        // max heap tracks smaller half
        maxHeap.add(e);
      } else {
        // min heap tracks larger half
        minHeap.add(e);
      }
      rebalance();
    }

    void remove(int e) {
      // O(n) remove used
      if (!minHeap.remove(e)) {
        maxHeap.remove(e);
      }
      rebalance();
    }

    private void rebalance() {
      // while difference in size > 1
      while (Math.abs(maxHeap.size() - minHeap.size()) > 1) {
        PriorityQueue<Integer> largerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        PriorityQueue<Integer> smallerHeap = maxHeap.size() > minHeap.size() ? minHeap : maxHeap;
        smallerHeap.add(largerHeap.remove());
      }
    }

    double median() {
      if (!maxHeap.isEmpty() && maxHeap.size() == minHeap.size()) {
        return ((double) (maxHeap.peek() + minHeap.peek())) / 2;
      } else {
        PriorityQueue<Integer> largerHeap = maxHeap.size() > minHeap.size() ? maxHeap : minHeap;
        if (largerHeap.isEmpty()) {
          throw new IllegalArgumentException();
        }
        return largerHeap.peek();
      }
    }
  }
}
