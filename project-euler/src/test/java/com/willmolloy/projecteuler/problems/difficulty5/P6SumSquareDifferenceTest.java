package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P6SumSquareDifferenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P6SumSquareDifferenceTest {

  private final P6SumSquareDifference sumSquareDifference = new P6SumSquareDifference();

  @Test
  void to10() {
    assertThat(sumSquareDifference.apply(10)).isEqualTo(2640);
  }

  @Test
  void to100() {
    assertThat(sumSquareDifference.apply(100)).isEqualTo(25_164_150);
  }
}
