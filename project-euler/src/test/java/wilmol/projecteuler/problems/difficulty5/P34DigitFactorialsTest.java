package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-18 at 9:54 PM. */
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
