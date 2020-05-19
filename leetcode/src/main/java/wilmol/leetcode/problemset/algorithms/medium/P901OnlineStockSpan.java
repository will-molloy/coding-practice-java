package wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by wilmol on 2020-05-19.
 *
 * <p><a
 * href=https://leetcode.com/problems/online-stock-span>https://leetcode.com/problems/online-stock-span/</a>
 *
 * <p>Runtime: O(n) (amortised cost of {@code next} is O(1))
 *
 * <p>Extra space: O(n)
 *
 * <p>Key: Stack because we want to access most recently added items first.
 *
 * @see P739DailyTemperatures
 */
class P901OnlineStockSpan {

  // holds (price, span)
  private final Deque<int[]> stack = new ArrayDeque<>();

  public int next(int price) {
    // initially 1 to include itself
    int span = 1;

    // compared to scanning the list each time
    // we collapse previously smaller prices into the current price
    // correct because future prices will see the current price first
    // i.e.
    // - if smaller: they wont look at the previous prices
    // - if larger: they'll end up adding what this price added up (repeated work)
    while (!stack.isEmpty()) {
      if (stack.peek()[0] <= price) {
        span += stack.pop()[1];
      } else {
        break;
      }
    }
    stack.push(new int[] {price, span});
    return span;
  }
}
