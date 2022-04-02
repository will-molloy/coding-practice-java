package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1048LongestStringChainTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1048LongestStringChainTest {

  private final P1048LongestStringChain p1048LongestStringChain = new P1048LongestStringChain();

  @ParameterizedTest
  @MethodSource
  void examples(String[] words, int expected) {
    assertThat(p1048LongestStringChain.longestStrChain(words)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"a", "b", "ba", "bca", "bda", "bdca"}, 4),
        Arguments.of(new String[] {"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5));
  }
}
