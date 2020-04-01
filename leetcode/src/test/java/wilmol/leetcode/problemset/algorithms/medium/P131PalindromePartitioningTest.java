package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-01. */
class P131PalindromePartitioningTest {

  private final P131PalindromePartitioning fun = new P131PalindromePartitioning();

  @Test
  void example() {
    assertThat(fun.partition("aab"))
        .containsExactly(ImmutableList.of("aa", "b"), ImmutableList.of("a", "a", "b"));
  }

  @Test
  void singleCharacter() {
    assertThat(fun.partition("a")).containsExactly(ImmutableList.of("a"));
  }

  @Test
  void emptyString() {
    assertThat(fun.partition("")).containsExactly(ImmutableList.of());
  }

  @Test
  void inputStringIsPalindrome() {
    assertThat(fun.partition("racecar"))
        .containsExactly(
            ImmutableList.of("racecar"),
            ImmutableList.of("r", "aceca", "r"),
            ImmutableList.of("r", "a", "cec", "a", "r"),
            ImmutableList.of("r", "a", "c", "e", "c", "a", "r"));
  }
}
