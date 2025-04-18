package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P21AmicibleNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P21AmicibleNumbersTest {

  private final P21AmicibleNumbers amicibleNumbers = new P21AmicibleNumbers();

  @Test
  void sumOfPairsBelow10K() {
    assertThat(amicibleNumbers.apply(10_000)).isEqualTo(31_626);
  }
}
