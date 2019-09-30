package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 16/03/2019. */
class P6SumSquareDifferenceTest {

  private final P6SumSquareDifference sumSquareDifference = new P6SumSquareDifference();

  @Test
  void to10() {
    assertThat(sumSquareDifference.apply(10)).isEqualTo(2640);
  }

  @Test
  void to100() {
    assertThat(sumSquareDifference.apply(100)).isEqualTo(25_164_150);
  }
}
