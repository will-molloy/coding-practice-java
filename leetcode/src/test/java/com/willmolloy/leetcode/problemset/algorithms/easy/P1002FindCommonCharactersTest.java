package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.testlib.CartesianProduct.cartesianProduct;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1002FindCommonCharactersTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1002FindCommonCharactersTest {

  @ParameterizedTest
  @MethodSource
  void examples(P1002FindCommonCharacters p1002, String[] a, List<String> expected) {
    assertThat(p1002.commonChars(a)).containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return cartesianProduct(p1002Solutions(), examplesInputsAndOutputs());
  }

  private static Stream<P1002FindCommonCharacters> p1002Solutions() {
    return Stream.of(
        new P1002FindCommonCharacters.ArraysAndLoops(),
        new P1002FindCommonCharacters.MapsAndStreams());
  }

  private static Stream<Arguments> examplesInputsAndOutputs() {
    return Stream.of(
        Arguments.of(new String[] {"bella", "label", "roller"}, ImmutableList.of("e", "l", "l")),
        Arguments.of(new String[] {"cool", "lock", "cook"}, ImmutableList.of("c", "o")));
  }
}
