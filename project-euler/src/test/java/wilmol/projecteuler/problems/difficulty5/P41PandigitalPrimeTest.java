package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-19 at 9:47 PM. */
class P41PandigitalPrimeTest {

  @Test
  void largestPandigitalPrime() {
    assertThat(P41PandigitalPrime.largestPandigitalPrime()).isEqualTo(7652413);
  }
}
