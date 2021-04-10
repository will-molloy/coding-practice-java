package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P953VerifyingAnAlienDictionaryTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P953VerifyingAnAlienDictionaryTest {

  private final P953VerifyingAnAlienDictionary p953VerifyingAnAlienDictionary =
      new P953VerifyingAnAlienDictionary();

  @ParameterizedTest
  @MethodSource
  void examples(String[] words, String order, boolean expected) {
    assertThat(p953VerifyingAnAlienDictionary.isAlienSorted(words, order)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new String[] {"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz", true),
        Arguments.of(new String[] {"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz", false),
        Arguments.of(new String[] {"apple", "app"}, "abcdefghijklmnopqrstuvwxyz", false));
  }

  @Test
  void wa() {
    assertThat(
            p953VerifyingAnAlienDictionary.isAlienSorted(
                new String[] {"ubg", "kwh"}, "qcipyamwvdjtesbghlorufnkzx"))
        .isTrue();
  }
}
