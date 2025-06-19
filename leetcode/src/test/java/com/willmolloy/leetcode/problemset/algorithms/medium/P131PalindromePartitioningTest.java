package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P131PalindromePartitioningTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P131PalindromePartitioningTest {

  private final P131PalindromePartitioning fun = new P131PalindromePartitioning();

  @Test
  void example() {
    assertThat(fun.partition("aab")).containsExactly(List.of("aa", "b"), List.of("a", "a", "b"));
  }

  @Test
  void singleCharacter() {
    assertThat(fun.partition("a")).containsExactly(List.of("a"));
  }

  @Test
  void emptyString() {
    assertThat(fun.partition("")).containsExactly(List.of());
  }

  @Test
  void inputStringIsPalindrome() {
    assertThat(fun.partition("racecar"))
        .containsExactly(
            List.of("racecar"),
            List.of("r", "aceca", "r"),
            List.of("r", "a", "cec", "a", "r"),
            List.of("r", "a", "c", "e", "c", "a", "r"));
  }
}
