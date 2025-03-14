package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * <a
 * href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node>https://leetcode.com/problems/populating-next-right-pointers-in-each-node/</a>
 *
 * @see P117PopulatingNextRightPointersInEachNode2
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
interface P116PopulatingNextRightPointersInEachNode {

  Node connect(Node root);

  /**
   * O(n) space solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(w) = O(n)
   *
   * <p>Key idea: BFS with queue.
   */
  class ExtraSpace implements P116PopulatingNextRightPointersInEachNode {

    @Override
    public Node connect(Node root) {
      if (root == null) {
        return null;
      }

      // standard bfs - iterate level by level
      Queue<Node> queue = new ArrayDeque<>();
      queue.add(root);
      while (!queue.isEmpty()) {
        int levelSize = queue.size();
        for (int i = 0; i < levelSize; i++) {
          Node node = queue.remove();
          Stream.of(node.left, node.right).filter(Objects::nonNull).forEach(queue::add);
          // set next
          node.next = i == levelSize - 1 ? null : queue.peek();
        }
      }
      return root;
    }
  }

  /**
   * O(1) space solution.
   *
   * <p>Runtime: O(n)
   *
   * <p>Space: O(1)
   *
   * <p>Key idea: BFS by following {@code next} pointer.
   */
  class ConstantSpace implements P116PopulatingNextRightPointersInEachNode {

    public Node connect(Node root) {
      // bfs - iterate level by level

      // save level start so can go to next level
      Node levelStart = root;

      while (levelStart != null) {

        // iterate level
        Node node = levelStart;
        while (node != null) {

          // set next pointers for next level
          if (node.left != null) {
            node.left.next = node.right;
          }
          if (node.right != null && node.next != null) {
            node.right.next = node.next.left;
          }

          // continue level iteration by following next pointer
          node = node.next;
        }

        // go to next level
        levelStart = levelStart.left;
      }
      return root;
    }
  }

  /** Node. */
  @SuppressFBWarnings("UWF_UNWRITTEN_FIELD")
  class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
      this.val = val;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Node node = (Node) o;
      return val == node.val
          && Objects.equals(left, node.left)
          && Objects.equals(right, node.right)
          && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
      return Objects.hash(val, left, right, next);
    }
  }
}
