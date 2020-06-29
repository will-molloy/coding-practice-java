package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P116PopulatingNextRightPointersInEachNode.Node;
import org.junit.jupiter.api.Test;

/**
 * P117PopulatingNextRightPointersInEachNode2Test.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P117PopulatingNextRightPointersInEachNode2Test {

  private final P117PopulatingNextRightPointersInEachNode2 fn =
      new P117PopulatingNextRightPointersInEachNode2();

  @Test
  void example() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.right = new Node(7);

    Node expectedConnectedRoot = new Node(1);
    expectedConnectedRoot.left = new Node(2);
    expectedConnectedRoot.right = new Node(3);
    expectedConnectedRoot.left.next = expectedConnectedRoot.right;
    expectedConnectedRoot.left.left = new Node(4);
    expectedConnectedRoot.left.right = new Node(5);
    expectedConnectedRoot.right.right = new Node(7);
    expectedConnectedRoot.left.left.next = expectedConnectedRoot.left.right;
    expectedConnectedRoot.left.right.next = expectedConnectedRoot.right.right;
    assertThat(fn.connect(root)).isEqualTo(expectedConnectedRoot);
  }

  @Test
  void nullRoot() {
    assertThat(fn.connect(null)).isNull();
  }
}
