package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P916WordSubsetsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P916WordSubsetsTest {

  private final P916WordSubsets p916WordSubsets = new P916WordSubsets();

  @ParameterizedTest
  @MethodSource
  void examples(String[] as, String[] bs, List<String> expected) {
    assertThat(p916WordSubsets.wordSubsets(as, bs)).containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
            new String[] {"e", "o"},
            List.of("facebook", "google", "leetcode")),
        Arguments.of(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
            new String[] {"l", "e"},
            List.of("apple", "google", "leetcode")),
        Arguments.of(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
            new String[] {"e", "oo"},
            List.of("facebook", "google")),
        Arguments.of(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
            new String[] {"lo", "eo"},
            List.of("google", "leetcode")),
        Arguments.of(
            new String[] {"amazon", "apple", "facebook", "google", "leetcode"},
            new String[] {"ec", "oc", "ceo"},
            List.of("facebook", "leetcode")));
  }
}
