package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.util.OptionalInt;
import org.junit.jupiter.api.Test;

/**
 * P5SmallestMultipleTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P5SmallestMultipleTest {

  private final P5SmallestMultiple smallestMultiple = new P5SmallestMultiple();

  @Test
  void from1to10() {
    assertThat(smallestMultiple.apply(1, 10)).isEqualTo(OptionalInt.of(2520));
  }

  @Test
  void from1to20() {
    assertThat(smallestMultiple.apply(1, 20)).isEqualTo(OptionalInt.of(232_792_560));
  }
}
