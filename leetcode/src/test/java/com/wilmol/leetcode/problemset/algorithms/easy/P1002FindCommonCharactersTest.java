package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.wilmol.testlib.TestLib;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-04. */
class P1002FindCommonCharactersTest {

  @ParameterizedTest
  @MethodSource
  void examples(P1002FindCommonCharacters p1002, String[] a, List<String> expected) {
    assertThat(p1002.commonChars(a)).containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return TestLib.cartesianProduct(p1002Solutions(), examplesInputsAndOutputs());
  }

  private static List<Arguments> p1002Solutions() {
    return ImmutableList.of(
        Arguments.of(new P1002FindCommonCharacters.ArraysAndLoops()),
        Arguments.of(new P1002FindCommonCharacters.MapsAndStreams()));
  }

  private static List<Arguments> examplesInputsAndOutputs() {
    return ImmutableList.of(
        Arguments.of(new String[] {"bella", "label", "roller"}, ImmutableList.of("e", "l", "l")),
        Arguments.of(new String[] {"cool", "lock", "cook"}, ImmutableList.of("c", "o")));
  }
}
