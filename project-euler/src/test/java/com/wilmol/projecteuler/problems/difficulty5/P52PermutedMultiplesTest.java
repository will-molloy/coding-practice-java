package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P52PermutedMultiplesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P52PermutedMultiplesTest {

  @Test
  void test2x() {
    assertThat(P52PermutedMultiples.smallestMultipleOfNSizedMultipleFamilyWithSameDigits(2))
        .isEqualTo(125874);
  }

  @Test
  void test6x() {
    assertThat(P52PermutedMultiples.smallestMultipleOfNSizedMultipleFamilyWithSameDigits(6))
        .isEqualTo(142857);
  }
}
