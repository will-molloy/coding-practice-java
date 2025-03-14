package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.Iterator;
import java.util.Objects;

/**
 * <a
 * href=https://leetcode.com/problems/peeking-iterator>https://leetcode.com/problems/peeking-iterator/</a>
 *
 * <p>Runtime: O(1) for all operations
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: Track {@code hasPeeked} and {@code peekedElement}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P284PeekingIterator {

  /** PeekingIterator. */
  static class PeekingIterator implements Iterator<Integer> {

    private final Iterator<Integer> iterator;
    private boolean hasPeeked;
    private Integer peekedElement;

    PeekingIterator(Iterator<Integer> iterator) {
      // initialize any member here.
      this.iterator = Objects.requireNonNull(iterator);
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      if (!hasPeeked) {
        peekedElement = iterator.next();
        hasPeeked = true;
      }
      return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      if (!hasPeeked) {
        return iterator.next();
      }
      Integer result = peekedElement;
      hasPeeked = false;
      peekedElement = null;
      return result;
    }

    @Override
    public boolean hasNext() {
      return hasPeeked || iterator.hasNext();
    }
  }
}
