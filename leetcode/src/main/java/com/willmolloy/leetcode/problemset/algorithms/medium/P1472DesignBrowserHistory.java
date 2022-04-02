package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * <a
 * href=https://leetcode.com/problems/design-browser-history>https://leetcode.com/problems/design-browser-history/</a>
 *
 * <p>Key: Store history in a list and maintain pointers to the current page and the last page.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1472DesignBrowserHistory {

  /** BrowserHistory. */
  static class BrowserHistory {

    private final List<String> list = new ArrayList<>();

    private int current;

    private int last;

    BrowserHistory(String homepage) {
      list.add(homepage);
      current = 0;
      last = 0;
    }

    // O(1)
    public void visit(String url) {
      current++;
      // maintaining 'last' pointer and overriding is more efficient than clearing list
      // (clearing is O(n) though O(1) amortised)
      if (current >= list.size()) {
        list.add(url);
      } else {
        list.set(current, url);
      }
      // clear forward history by moving last pointer back
      last = current;
    }

    // O(1)
    public String back(int steps) {
      current = Math.max(0, current - steps);
      return list.get(current);
    }

    // O(1)
    public String forward(int steps) {
      current = Math.min(last, current + steps);
      return list.get(current);
    }
  }
}
