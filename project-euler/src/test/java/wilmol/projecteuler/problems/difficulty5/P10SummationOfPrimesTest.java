package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 17/03/2019. */
class P10SummationOfPrimesTest {

  private final P10SummationOfPrimes summationOfPrimes = new P10SummationOfPrimes();

  @Test
  void below10() {
    assertThat(summationOfPrimes.apply(10)).isEqualTo(17L);
  }

  @Test
  void below2Million() {
    assertThat(summationOfPrimes.apply(2_000_000)).isEqualTo(142_913_828_922L);
  }
}
