package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 23/03/2019. */
class P29DistinctPowersTest {

  private final P29DistinctPowers distinctPowers = new P29DistinctPowers();

  @Test
  void between2And5() {
    assertThat(distinctPowers.apply(2, 5)).isEqualTo(15);
  }

  @Test
  void between2And100() {
    assertThat(distinctPowers.apply(2, 100)).isEqualTo(9_183);
  }
}
