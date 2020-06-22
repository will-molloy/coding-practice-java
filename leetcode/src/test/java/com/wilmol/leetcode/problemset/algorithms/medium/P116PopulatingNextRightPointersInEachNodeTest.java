package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.leetcode.problemset.algorithms.medium.P116PopulatingNextRightPointersInEachNode.Node;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-08. */
class P116PopulatingNextRightPointersInEachNodeTest {

  private final P116PopulatingNextRightPointersInEachNode fn =
      new P116PopulatingNextRightPointersInEachNode();

  @Test
  void example() {
    Node root = new Node(1);
    root.left = new Node(2);
    root.right = new Node(3);
    root.left.left = new Node(4);
    root.left.right = new Node(5);
    root.right.left = new Node(6);
    root.right.right = new Node(7);

    Node expectedConnectedRoot = new Node(1);
    expectedConnectedRoot.left = new Node(2);
    expectedConnectedRoot.right = new Node(3);
    expectedConnectedRoot.left.next = expectedConnectedRoot.right;
    expectedConnectedRoot.left.left = new Node(4);
    expectedConnectedRoot.left.right = new Node(5);
    expectedConnectedRoot.right.left = new Node(6);
    expectedConnectedRoot.right.right = new Node(7);
    expectedConnectedRoot.left.left.next = expectedConnectedRoot.left.right;
    expectedConnectedRoot.left.right.next = expectedConnectedRoot.right.left;
    expectedConnectedRoot.right.left.next = expectedConnectedRoot.right.right;
    assertThat(fn.connect(root)).isEqualTo(expectedConnectedRoot);
  }

  @Test
  void nullRoot() {
    assertThat(fn.connect(null)).isNull();
  }
}
