package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 23/03/2019. */
class P26ReciprocalCyclesTest {

  private final P26ReciprocalCycles reciprocalCycles = new P26ReciprocalCycles();

  @Test
  void longestUpTo10() {
    assertThat(reciprocalCycles.apply(11)).isEqualTo(7);
  }

  @Test
  void longestUpTo1000() {
    assertThat(reciprocalCycles.apply(1001)).isEqualTo(983);
  }
}
