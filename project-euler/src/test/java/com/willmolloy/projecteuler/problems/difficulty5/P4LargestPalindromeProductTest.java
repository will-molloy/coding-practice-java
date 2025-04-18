package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P4LargestPalindromeProductTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P4LargestPalindromeProductTest {

  @Test
  void largestPalindromeProduct() {
    assertThat(new P4LargestPalindromeProduct().apply(2)).isEqualTo(9_009L);
    assertThat(new P4LargestPalindromeProduct().apply(3)).isEqualTo(906_609L);
  }
}
