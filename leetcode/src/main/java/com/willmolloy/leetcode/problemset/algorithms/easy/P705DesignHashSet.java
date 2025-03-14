package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/design-hashset>https://leetcode.com/problems/design-hashset/</a>
 *
 * <p>Runtime: O(1)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key idea: backing array. Don't need probing or chaining, values fit in single array.
 *
 * @see P707DesignLinkedList
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P705DesignHashSet {

  /** My hash set. */
  static class MyHashSet {

    private final boolean[] array;

    MyHashSet() {
      array = new boolean[1000001];
    }

    void add(int key) {
      array[key] = true;
    }

    void remove(int key) {
      array[key] = false;
    }

    boolean contains(int key) {
      return array[key];
    }
  }
}
