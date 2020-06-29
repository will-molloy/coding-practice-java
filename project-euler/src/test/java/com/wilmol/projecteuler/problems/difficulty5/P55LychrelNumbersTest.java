package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P55LychrelNumbersTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P55LychrelNumbersTest {

  @Test
  void lychrelNumbersBelow10K() {
    assertThat(P55LychrelNumbers.countLychrelNumbersBelow(10_000)).isEqualTo(249);
  }
}
