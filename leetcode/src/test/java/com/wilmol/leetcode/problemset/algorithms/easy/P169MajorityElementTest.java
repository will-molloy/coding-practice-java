package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-03-12. */
class P169MajorityElementTest {

  private final P169MajorityElement fun = new P169MajorityElement();

  @Test
  void example1() {
    assertThat(fun.majorityElement(new int[] {3, 2, 3})).isEqualTo(3);
  }

  @Test
  void example2() {
    assertThat(fun.majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2})).isEqualTo(2);
  }

  @Test
  void noMajorityElement() {
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> fun.majorityElement(new int[] {1, 2}));
    assertThat(thrown).hasMessageThat().isEqualTo("No majority element");
  }
}
