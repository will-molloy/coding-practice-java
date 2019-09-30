package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-20 at 5:43 PM. */
class P47DistinctPrimeFactorsTest {

  @Test
  void firstOfTwoConsecutiveWithTwoDistinctPrimeFactorsEach() {
    assertThat(P47DistinctPrimeFactors.firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(2))
        .isEqualTo(14);
  }

  @Test
  void firstOfThreeConsecutiveWithThreeDistinctPrimeFactorsEach() {
    assertThat(P47DistinctPrimeFactors.firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(3))
        .isEqualTo(644);
  }

  @Test
  void firstOfFourConsecutiveWithFourDistinctPrimeFactorsEach() {
    assertThat(P47DistinctPrimeFactors.firstOfSetWithSizeNAndNDistinctConsecutivePrimeFactors(4))
        .isEqualTo(134_043);
  }
}
