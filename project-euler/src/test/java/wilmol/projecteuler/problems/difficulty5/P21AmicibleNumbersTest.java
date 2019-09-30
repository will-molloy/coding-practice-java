package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 17/03/2019. */
class P21AmicibleNumbersTest {

  private final P21AmicibleNumbers amicibleNumbers = new P21AmicibleNumbers();

  @Test
  void sumOfPairsBelow10K() {
    assertThat(amicibleNumbers.apply(10_000)).isEqualTo(31_626);
  }
}
