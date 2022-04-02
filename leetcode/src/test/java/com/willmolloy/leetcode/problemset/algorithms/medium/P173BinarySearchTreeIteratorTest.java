package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.BinaryTreeNode;
import com.willmolloy.leetcode.problemset.algorithms.medium.P173BinarySearchTreeIterator.BstIterator;
import org.junit.jupiter.api.Test;

/**
 * P173BinarySearchTreeIteratorTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P173BinarySearchTreeIteratorTest {

  @Test
  void example() {
    BstIterator iterator =
        new BstIterator(BinaryTreeNode.fromLevelOrder(7, 3, 15, null, null, 9, 20));
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(3);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(7);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(9);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(15);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(20);
    assertThat(iterator.hasNext()).isFalse();
  }

  @Test
  void completeTree() {
    BstIterator iterator = new BstIterator(BinaryTreeNode.fromLevelOrder(4, 2, 6, 1, 3, 5, 7));
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(1);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(2);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(3);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(4);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(5);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(6);
    assertThat(iterator.hasNext()).isTrue();
    assertThat(iterator.next()).isEqualTo(7);
    assertThat(iterator.hasNext()).isFalse();
  }
}
