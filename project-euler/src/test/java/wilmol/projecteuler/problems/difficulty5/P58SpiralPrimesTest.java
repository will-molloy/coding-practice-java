package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-05-19 at 17:44. */
class P58SpiralPrimesTest {

  @Test
  void sideLengthWithLessThan10PercentPrimesOnDiagonals() {
    assertThat(P58SpiralPrimes.solve()).isEqualTo(26241);
  }
}
