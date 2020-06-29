package com.wilmol.projecteuler.common;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MathsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class MathsTest {

  @Test
  void testIsValidInt() {
    assertThat(Maths.isInteger(2.0d)).isTrue();
    assertThat(Maths.isInteger(2.5d)).isFalse();
  }
}
