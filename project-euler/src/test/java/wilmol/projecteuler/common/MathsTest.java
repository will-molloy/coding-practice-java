package wilmol.projecteuler.common;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 17/03/2019. */
class MathsTest {

  @Test
  void testIsValidInt() {
    assertThat(Maths.isInteger(2.0d)).isTrue();
    assertThat(Maths.isInteger(2.5d)).isFalse();
  }
}
