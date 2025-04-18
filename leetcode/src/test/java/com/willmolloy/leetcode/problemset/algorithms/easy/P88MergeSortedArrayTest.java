package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P88MergeSortedArrayTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P88MergeSortedArrayTest {

  private final P88MergeSortedArray fun = new P88MergeSortedArray();

  @Test
  void example() {
    int[] nums1 = IntStream.of(1, 2, 3, 0, 0, 0).toArray();
    int[] nums2 = IntStream.of(2, 5, 6).toArray();
    int m = 3;
    int n = 3;
    fun.merge(nums1, m, nums2, n);
    assertThat(nums1).asList().containsExactly(1, 2, 2, 3, 5, 6).inOrder();
  }

  @Test
  void nonOverlappingMerge() {
    int[] nums1 = IntStream.of(4, 5, 6, 0, 0, 0).toArray();
    int[] nums2 = IntStream.of(1, 2, 3).toArray();
    int m = 3;
    int n = 3;
    fun.merge(nums1, m, nums2, n);
    assertThat(nums1).asList().containsExactly(1, 2, 3, 4, 5, 6).inOrder();
  }
}
