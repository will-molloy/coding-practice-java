package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P44PentagonNumbersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P44PentagonNumbersTest {

  @Test
  void minimumPentagonSumDifferenceDifference() {
    assertThat(
            P44PentagonNumbers
                .minimisedPentagonPairDifferenceWithPentagonSumAndPentagonDifference())
        .isEqualTo(5482660);
  }
}
