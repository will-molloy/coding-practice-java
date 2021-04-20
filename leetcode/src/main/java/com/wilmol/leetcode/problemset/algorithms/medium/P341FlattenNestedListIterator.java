package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/**
 * <a
 * href=https://leetcode.com/problems/flatten-nested-list-iterator>https://leetcode.com/problems/flatten-nested-list-iterator/</a>
 *
 * <p>Key: The output could be printed by performing a DFS on the input. This means a {@code stack}
 * should be used.
 *
 * <p>The tricky part is handling empty nested lists, to handle them, iteratively flatten the front
 * of the stack until it's an integer or the stack is empty.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P341FlattenNestedListIterator {

  /** NestedIterator implementation. */
  static class NestedIterator implements Iterator<Integer> {

    private final Deque<NestedInteger> stack;

    NestedIterator(List<NestedInteger> nestedList) {
      stack = new ArrayDeque<>();
      addAll(nestedList);
    }

    @Override
    public Integer next() {
      // run hasNext to maintain the invariant that the front of the stack is an integer
      if (!hasNext()) {
        return null;
      }
      return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
      // while the next element is a list
      while (!stack.isEmpty() && !stack.peek().isInteger()) {
        // flatten that list
        addAll(stack.pop().getList());
      }
      return !stack.isEmpty();
    }

    private void addAll(List<NestedInteger> nestedList) {
      // push the elements in reverse order
      // this way the list is at the front of the stack and the order of the list is maintained
      ListIterator<NestedInteger> listIterator = nestedList.listIterator(nestedList.size());
      while (listIterator.hasPrevious()) {
        stack.push(listIterator.previous());
      }
    }
  }

  /** NestedInteger interface. */
  interface NestedInteger {
    boolean isInteger();

    Integer getInteger();

    List<NestedInteger> getList();
  }

  /** NestedInteger implementation. */
  static final class NestedIntegerImpl implements NestedInteger {
    private final List<NestedInteger> list;
    private final Integer integer;

    NestedIntegerImpl(List<NestedInteger> list) {
      this.list = List.copyOf(list);
      this.integer = null;
    }

    NestedIntegerImpl(Integer integer) {
      this.integer = Objects.requireNonNull(integer);
      this.list = List.of();
    }

    @Override
    public boolean isInteger() {
      return integer != null;
    }

    @Override
    public Integer getInteger() {
      return integer;
    }

    @Override
    public List<NestedInteger> getList() {
      return list;
    }

    @Override
    public String toString() {
      return isInteger() ? integer.toString() : list.toString();
    }
  }
}
