package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

/**
 * P128LongestConsecutiveSequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P128LongestConsecutiveSequenceTest {

  private final P128LongestConsecutiveSequence fun = new P128LongestConsecutiveSequence();

  @Test
  void example() {
    assertThat(fun.longestConsecutive(new int[] {100, 4, 200, 1, 3, 2})).isEqualTo(4);
  }

  @Test
  void empty() {
    assertThat(fun.longestConsecutive(new int[0])).isEqualTo(0);
  }

  @Test
  void noConsecutiveSequence() {
    assertThat(fun.longestConsecutive(new int[] {1, 3, 5, 7, 9})).isEqualTo(1);
  }

  @Test
  void oneTo100() {
    assertThat(fun.longestConsecutive(IntStream.rangeClosed(1, 100).toArray())).isEqualTo(100);
  }

  @Test
  void oneTo100WithGap() {
    int[] nums = IntStream.rangeClosed(1, 100).toArray();
    nums[50] = -1;
    assertThat(fun.longestConsecutive(nums)).isEqualTo(50);
  }
}
