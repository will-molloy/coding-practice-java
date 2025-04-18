package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

/**
 * P86PartitionListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P86PartitionListTest {

  private final P86PartitionList func = new P86PartitionList();

  @Test
  void example() {
    assertThat(func.partition(ListNode.of(1, 4, 3, 2, 5, 2), 3))
        .isEqualTo(ListNode.of(1, 2, 2, 4, 3, 5));
  }

  @Test
  void exampleFirstRunOnly() {
    assertThat(func.partition(ListNode.of(1, 4, 3, 2), 3)).isEqualTo(ListNode.of(1, 2, 4, 3));
  }

  @Test
  void singleSwap() {
    assertThat(func.partition(ListNode.of(2, 1), 2)).isEqualTo(ListNode.of(1, 2));
  }

  @Test
  void nullInput() {
    assertThat(func.partition(null, 0)).isEqualTo(null);
  }

  @Test
  void singleNode() {
    assertThat(func.partition(ListNode.of(1), 0)).isEqualTo(ListNode.of(1));
  }

  @Test
  void allGreaterThanX() {
    assertThat(func.partition(ListNode.of(1, 2, 3), 0)).isEqualTo(ListNode.of(1, 2, 3));
  }

  @Test
  void allEqualToX() {
    assertThat(func.partition(ListNode.of(3, 3, 3), 3)).isEqualTo(ListNode.of(3, 3, 3));
  }

  @Test
  void allLessThanX() {
    assertThat(func.partition(ListNode.of(1, 2, 3), 4)).isEqualTo(ListNode.of(1, 2, 3));
  }

  @Test
  void firstGreaterThanEqualToX() {
    assertThat(func.partition(ListNode.of(3, 1, 2), 3)).isEqualTo(ListNode.of(1, 2, 3));
  }

  @Test
  void secondGreaterThanEqualToX() {
    assertThat(func.partition(ListNode.of(1, 3, 1, 2), 3)).isEqualTo(ListNode.of(1, 1, 2, 3));
  }
}
