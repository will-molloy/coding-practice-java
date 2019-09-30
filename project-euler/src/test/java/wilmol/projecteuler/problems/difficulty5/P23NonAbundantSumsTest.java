package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 18/03/2019. */
class P23NonAbundantSumsTest {

  private final P23NonAbundantSums nonAbundantSums = new P23NonAbundantSums();

  @Test
  void oneTo100() {
    assertThat(nonAbundantSums.apply(100)).isEqualTo(2766);
  }

  @Test
  void allPositiveIntegers() {
    assertThat(nonAbundantSums.apply(28_123)).isEqualTo(4_179_871);
  }
}
