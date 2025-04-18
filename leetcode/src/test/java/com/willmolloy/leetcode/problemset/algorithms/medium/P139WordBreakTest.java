package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P139WordBreakTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P139WordBreakTest {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P139WordBreak fun) {
    assertThat(fun.wordBreak("leetcode", ImmutableList.of("leet", "code"))).isTrue();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P139WordBreak fun) {
    assertThat(fun.wordBreak("applepenapple", ImmutableList.of("apple", "pen"))).isTrue();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P139WordBreak fun) {
    assertThat(fun.wordBreak("catsandog", ImmutableList.of("cats", "dog", "sand", "and", "cat")))
        .isFalse();
  }

  static Stream<P139WordBreak> funs() {
    return Stream.of(new P139WordBreak.TopDown(), new P139WordBreak.BottomUp());
  }
}
