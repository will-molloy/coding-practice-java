package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P53CombinatoricSelectionsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P53CombinatoricSelectionsTest {

  @Test
  void testNUpTo100() {
    assertThat(P53CombinatoricSelections.countGreaterThanOneMillion(100)).isEqualTo(4075);
  }

  @Test
  void testNUpTo23() {
    assertThat(P53CombinatoricSelections.countGreaterThanOneMillion(23)).isEqualTo(4);
  }
}
