package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 23/03/2019. */
class P28NumberSpiralDiagonalsTest {

  private final P28NumberSpiralDiagonals numberSpiralDiagonals = new P28NumberSpiralDiagonals();

  @Test
  void test3x3Spiral() {
    assertThat(numberSpiralDiagonals.sumDiagonals(3)).isEqualTo(25);
  }

  @Test
  void test5x5Spiral() {
    assertThat(numberSpiralDiagonals.sumDiagonals(5)).isEqualTo(101);
  }

  @Test
  void test1001x1001spiral() {
    assertThat(numberSpiralDiagonals.sumDiagonals(1_001)).isEqualTo(669_171_001);
  }
}
