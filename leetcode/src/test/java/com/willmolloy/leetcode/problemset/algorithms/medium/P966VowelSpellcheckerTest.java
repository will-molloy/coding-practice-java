package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P966VowelSpellcheckerTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P966VowelSpellcheckerTest {

  private final P966VowelSpellchecker p966VowelSpellchecker = new P966VowelSpellchecker();

  @ParameterizedTest
  @MethodSource
  void examples(String[] wordList, String[] queries, Iterable<String> expected) {
    assertThat(p966VowelSpellchecker.spellchecker(wordList, queries))
        .asList()
        .containsExactlyElementsIn(expected)
        .inOrder();
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new String[] {"KiTe", "kite", "hare", "Hare"},
            new String[] {
              "kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"
            },
            List.of("kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe")),
        Arguments.of(new String[] {"yellow"}, new String[] {"YellOw"}, List.of("yellow")));
  }
}
