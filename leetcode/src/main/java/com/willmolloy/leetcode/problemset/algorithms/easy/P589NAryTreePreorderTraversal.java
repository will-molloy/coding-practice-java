package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

/**
 * <a
 * href=https://leetcode.com/problems/n-ary-tree-preorder-traversal>https://leetcode.com/problems/n-ary-tree-preorder-traversal/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Recursive DFS or iterative DFS with stack. For the stack, it's important children are
 * pushed in reverse order such that their original order is maintained (recursion doesn't need this
 * as it eagerly processes the next node).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P589NAryTreePreorderTraversal {

  public List<Integer> preorder(Node root) {
    Deque<Node> stack = new ArrayDeque<>();
    stack.push(root);

    List<Integer> result = new ArrayList<>();

    while (!stack.isEmpty()) {
      Node node = stack.pop();
      result.add(node.val);
      // push the children in reverse order
      // this way the children are at the front of the stack but still in their original order
      ListIterator<Node> listIterator = node.children.listIterator(node.children.size());
      while (listIterator.hasPrevious()) {
        stack.push(listIterator.previous());
      }
    }
    return result;
  }

  /** N-ary Node. */
  static final class Node {
    private final int val;
    private final List<Node> children;

    Node(int val) {
      this.val = val;
      this.children = List.of();
    }

    Node(int val, List<Node> children) {
      this.val = val;
      this.children = List.copyOf(children);
    }
  }
}
