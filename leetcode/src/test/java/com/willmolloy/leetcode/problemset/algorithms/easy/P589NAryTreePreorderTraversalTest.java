package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.easy.P589NAryTreePreorderTraversal.Node;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P589NAryTreePreorderTraversalTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P589NAryTreePreorderTraversalTest {

  private final P589NAryTreePreorderTraversal p589NAryTreePreorderTraversal =
      new P589NAryTreePreorderTraversal();

  @Test
  void example1() {
    Node root =
        new Node(
            1, List.of(new Node(3, List.of(new Node(5), new Node(6))), new Node(2), new Node(4)));

    assertThat(p589NAryTreePreorderTraversal.preorder(root))
        .containsExactly(1, 3, 5, 6, 2, 4)
        .inOrder();
  }

  @Test
  void example2() {
    Node root =
        new Node(
            1,
            List.of(
                new Node(2),
                new Node(
                    3,
                    List.of(
                        new Node(6), new Node(7, List.of(new Node(11, List.of(new Node(14))))))),
                new Node(4, List.of(new Node(8, List.of(new Node(12))))),
                new Node(5, List.of(new Node(9, List.of(new Node(13))), new Node(10)))));

    assertThat(p589NAryTreePreorderTraversal.preorder(root))
        .containsExactly(1, 2, 3, 6, 7, 11, 14, 4, 8, 12, 5, 9, 13, 10)
        .inOrder();
  }
}
