package com.wilmol.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.base.Strings;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Created by wilmol on 2020-06-19. */
class P1044LongestDuplicateSubstringTest {

  @ParameterizedTest
  @MethodSource("p1044")
  void example1LongestDuplicateOverlaps(P1044LongestDuplicateSubstring p1044) {
    assertThat(p1044.longestDupSubstring("banana")).isEqualTo("ana");
  }

  @ParameterizedTest
  @MethodSource("p1044")
  void example2NoDuplicateSubstring(P1044LongestDuplicateSubstring p1044) {
    assertThat(p1044.longestDupSubstring("abcd")).isEmpty();
  }

  @ParameterizedTest
  @MethodSource("p1044")
  void longestDuplicateDoesntOverlap(P1044LongestDuplicateSubstring p1044) {
    assertThat(p1044.longestDupSubstring("abcdabcd")).isEqualTo("abcd");
  }

  @ParameterizedTest
  @MethodSource("p1044")
  void cantBeWholeString(P1044LongestDuplicateSubstring p1044) {
    assertThat(p1044.longestDupSubstring("aaa")).isEqualTo("aa");
  }

  @Test
  void maxInputSize() {
    P1044LongestDuplicateSubstring p1044 =
        new P1044LongestDuplicateSubstring.BinarySearchWithRollingHash();
    assertThat(p1044.longestDupSubstring(Strings.repeat("a", 10_000)))
        .isEqualTo(Strings.repeat("a", 9999));
  }

  static Stream<P1044LongestDuplicateSubstring> p1044() {
    return Stream.of(
        new P1044LongestDuplicateSubstring.BruteForce(),
        new P1044LongestDuplicateSubstring.BinarySearch(),
        new P1044LongestDuplicateSubstring.BinarySearchWithRollingHash());
  }
}
