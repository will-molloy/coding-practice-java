package com.wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * P40ChampernownesConstantsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P40ChampernownesConstantsTest {

  @Test
  void test12thDecimalValue() {
    assertThat(P40ChampernownesConstants.apply(Set.of(12))).isEqualTo(1);
  }

  @Test
  void test1stx10thx100thx1Kthx10Kthx100Kthx1MthDecimalValue() {
    assertThat(
            P40ChampernownesConstants.apply(Set.of(1, 10, 100, 1_000, 10_000, 100_000, 1_000_000)))
        .isEqualTo(210);
  }
}
