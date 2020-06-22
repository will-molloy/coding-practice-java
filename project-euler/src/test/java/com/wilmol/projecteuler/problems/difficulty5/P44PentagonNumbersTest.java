package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-20 at 12:11 PM. */
class P44PentagonNumbersTest {

  @Test
  void minimumPentagonSumDifferenceDifference() {
    assertThat(
            P44PentagonNumbers
                .minimisedPentagonPairDifferenceWithPentagonSumAndPentagonDifference())
        .isEqualTo(5482660);
  }
}
