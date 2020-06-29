package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P44PentagonNumbersTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P44PentagonNumbersTest {

  @Test
  void minimumPentagonSumDifferenceDifference() {
    assertThat(
            P44PentagonNumbers
                .minimisedPentagonPairDifferenceWithPentagonSumAndPentagonDifference())
        .isEqualTo(5482660);
  }
}
