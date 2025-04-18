package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P140WordBreak2Test.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P140WordBreak2Test {

  @ParameterizedTest
  @MethodSource("funs")
  void example1(P140WordBreak2 fun) {
    assertThat(fun.wordBreak("catsanddog", ImmutableList.of("cat", "cats", "and", "sand", "dog")))
        .containsExactly("cats and dog", "cat sand dog");
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example2(P140WordBreak2 fun) {
    assertThat(
            fun.wordBreak(
                "pineapplepenapple",
                ImmutableList.of("apple", "pen", "applepen", "pine", "pineapple")))
        .containsExactly("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
  }

  @ParameterizedTest
  @MethodSource("funs")
  void example3(P140WordBreak2 fun) {
    assertThat(fun.wordBreak("catsandog", ImmutableList.of("cats", "dog", "sand", "and", "cat")))
        .isEmpty();
  }

  @ParameterizedTest
  @MethodSource("funs")
  void emptyString(P140WordBreak2 fun) {
    assertThat(fun.wordBreak("", ImmutableList.of("a", "b", "c"))).isEmpty();
  }

  static Stream<P140WordBreak2> funs() {
    return Stream.of(new P140WordBreak2.Dfs(), new P140WordBreak2.MemoizedDfs());
  }
}
