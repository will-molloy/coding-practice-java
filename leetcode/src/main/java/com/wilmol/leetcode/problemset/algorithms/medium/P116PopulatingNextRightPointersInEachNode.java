package com.wilmol.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.ArrayDeque;
import java.util.Objects;
import java.util.Queue;
import java.util.stream.Stream;

/**
 * Created by wilmol on 2020-03-08.
 *
 * <p><a
 * href=https://leetcode.com/problems/populating-next-right-pointers-in-each-node>https://leetcode.com/problems/populating-next-right-pointers-in-each-node</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(w) = O(n)
 *
 * <p>Key: BFS
 *
 * @see P117PopulatingNextRightPointersInEachNode2
 */
class P116PopulatingNextRightPointersInEachNode {

  // TODO can do without queue, so O(1) space (still bfs, but use next ptr) ?

  public Node connect(Node root) {
    if (root == null) {
      return null;
    }

    // standard bfs
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

  @SuppressFBWarnings("UWF_UNWRITTEN_FIELD")
  static class Node {
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
