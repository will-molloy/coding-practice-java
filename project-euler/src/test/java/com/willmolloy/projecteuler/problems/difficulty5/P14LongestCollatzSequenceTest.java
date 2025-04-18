package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P14LongestCollatzSequenceTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P14LongestCollatzSequenceTest {

  private final P14LongestCollatzSequence longestCollatzSequence = new P14LongestCollatzSequence();

  @Test
  void startingNumberBelow() {
    assertThat(longestCollatzSequence.apply(14)).isEqualTo(9L);
    assertThat(longestCollatzSequence.apply(100_000)).isEqualTo(77_031L);
    assertThat(longestCollatzSequence.apply(1_000_000)).isEqualTo(837_799L);
  }
}
