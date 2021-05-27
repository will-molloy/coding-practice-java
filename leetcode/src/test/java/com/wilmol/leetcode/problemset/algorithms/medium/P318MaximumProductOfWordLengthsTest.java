package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.wilmol.testlib.CartesianProduct;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P318MaximumProductOfWordLengthsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P318MaximumProductOfWordLengthsTest {

  static Stream<P318MaximumProductOfWordLengths> solutions() {
    return Stream.of(
        new P318MaximumProductOfWordLengths.LetterSet(),
        new P318MaximumProductOfWordLengths.LetterBitMask());
  }

  @ParameterizedTest
  @MethodSource
  void examples(P318MaximumProductOfWordLengths solution, String[] words, int expected) {
    assertThat(solution.maxProduct(words)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return CartesianProduct.cartesianProduct(solutions(), examplesArgs());
  }

  static Stream<Arguments> examplesArgs() {
    return Stream.of(
        Arguments.of(new String[] {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16),
        Arguments.of(new String[] {"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4),
        Arguments.of(new String[] {"a", "aa", "aaa", "aaaa"}, 0));
  }
}
