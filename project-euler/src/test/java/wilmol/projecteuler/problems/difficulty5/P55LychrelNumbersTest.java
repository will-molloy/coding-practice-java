package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-25 at 21:25. */
class P55LychrelNumbersTest {

  @Test
  void lychrelNumbersBelow10K() {
    assertThat(P55LychrelNumbers.countLychrelNumbersBelow(10_000)).isEqualTo(249);
  }
}
