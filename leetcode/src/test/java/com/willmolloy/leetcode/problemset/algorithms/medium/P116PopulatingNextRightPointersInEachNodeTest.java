package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.medium.P116PopulatingNextRightPointersInEachNode.Node;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P116PopulatingNextRightPointersInEachNodeTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P116PopulatingNextRightPointersInEachNodeTest {

  @ParameterizedTest
  @MethodSource("solutions")
  void example(P116PopulatingNextRightPointersInEachNode solution) {
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
    assertThat(solution.connect(root)).isEqualTo(expectedConnectedRoot);
  }

  @ParameterizedTest
  @MethodSource("solutions")
  void nullRoot(P116PopulatingNextRightPointersInEachNode solution) {
    assertThat(solution.connect(null)).isNull();
  }

  static Stream<P116PopulatingNextRightPointersInEachNode> solutions() {
    return Stream.of(
        new P116PopulatingNextRightPointersInEachNode.ExtraSpace(),
        new P116PopulatingNextRightPointersInEachNode.ConstantSpace());
  }
}
