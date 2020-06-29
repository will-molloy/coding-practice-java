package com.wilmol.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * NegativeLookbehindTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class NegativeLookbehindTest {

  @Test
  void testMatchCount() {
    assertThat(new NegativeLookbehind().containsCount("1o1s")).isEqualTo(3L);
    assertThat(new NegativeLookbehind().containsCount("thisisavowel")).isEqualTo(7L);
    assertThat(
            new NegativeLookbehind()
                .containsCount(
                    "1qaz2wsx3edc4rfv5tgb6yhn7ujm8ik9ool./;p01QAZ2WSX3EDC4RFV5TGB6YHN7UJM8IK,9OL.0P;/-['"))
        .isEqualTo(72L);
    assertThat(
            new NegativeLookbehind()
                .containsCount("SC HUIEHKESYG VSBC SF BDS GUIHuhjsd bcukhb2ip4hjjvs bvfdsbvl bv"))
        .isEqualTo(54L);
  }
}
