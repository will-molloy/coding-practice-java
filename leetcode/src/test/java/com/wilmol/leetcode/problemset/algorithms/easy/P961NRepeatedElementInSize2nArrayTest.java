package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * P961NRepeatedElementInSize2nArrayTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P961NRepeatedElementInSize2nArrayTest {

  private final P961NRepeatedElementInSize2nArray fun = new P961NRepeatedElementInSize2nArray();

  @Test
  void example1() {
    assertThat(fun.repeatedNTimes(new int[] {1, 2, 3, 3})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.repeatedNTimes(new int[] {2, 1, 2, 5, 3, 2})).isEqualTo(2);
  }

  @Test
  void example3() {
    assertThat(fun.repeatedNTimes(new int[] {5, 1, 5, 2, 5, 3, 5, 4})).isEqualTo(5);
  }

  @Test
  void noDuplicates() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> fun.repeatedNTimes(new int[0]));
    assertThat(thrown).hasMessageThat().isEqualTo("No duplicates");
  }
}
