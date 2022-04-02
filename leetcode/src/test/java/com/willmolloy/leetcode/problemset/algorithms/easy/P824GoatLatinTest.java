package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P824GoatLatinTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P824GoatLatinTest {

  private final P824GoatLatin p824 = new P824GoatLatin();

  @ParameterizedTest
  @MethodSource
  void examples(String sentence, String expected) {
    assertThat(p824.toGoatLatin(sentence)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of("I speak Goat Latin", "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"),
        Arguments.of(
            "The quick brown fox jumped over the lazy dog",
            "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"));
  }
}
