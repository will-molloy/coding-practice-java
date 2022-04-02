package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P34DigitFactorialsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P34DigitFactorialsTest {

  @Test
  void naiveSolutionWhichTestsAllCombinationsOfDigits() {
    assertThat(P34DigitFactorials.testAllDigitFactorialsUpToLimitAndSum()).isEqualTo(40730L);
  }

  @Test
  void betterSolutionWhichOnlyTestsUniqueCombinationsOfDigits() {
    assertThat(P34DigitFactorials.testDigitFactorialPermutationsUpToLimitAndSum())
        .isEqualTo(40730L);
  }
}
