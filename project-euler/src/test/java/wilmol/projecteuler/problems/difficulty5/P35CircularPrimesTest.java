package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-19 at 2:31 PM. */
class P35CircularPrimesTest {

  @Test
  void countBelow100() {
    assertThat(P35CircularPrimes.numCircularPrimesBelow(100)).isEqualTo(13L);
  }

  @Test
  void countBelow1M() {
    assertThat(P35CircularPrimes.numCircularPrimesBelow(1_000_000)).isEqualTo(55L);
  }
}
