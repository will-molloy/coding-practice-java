package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P43SubstringDivisibilityTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P43SubstringDivisibilityTest {

  @Test
  void sumAllPandigitalNumbersWithThisProperty() {
    assertThat(P43SubstringDivisibility.pandigitalSumWithDivisibility()).isEqualTo(16_695_334_890L);
  }
}
