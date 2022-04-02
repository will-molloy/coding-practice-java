package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P187RepeatedDnaSequencesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P187RepeatedDnaSequencesTest {

  private final P187RepeatedDnaSequences p187 = new P187RepeatedDnaSequences();

  @ParameterizedTest
  @MethodSource
  void examples(String s, List<String> expected) {
    assertThat(p187.findRepeatedDnaSequences(s)).containsExactlyElementsIn(expected).inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT", List.of("AAAAACCCCC", "CCCCCAAAAA")),
        Arguments.of("AAAAAAAAAAAAA", List.of("AAAAAAAAAA")));
  }
}
