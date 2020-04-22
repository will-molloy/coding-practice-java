package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-22. */
class P720LongestWordInDictionaryTest {

  private final P720LongestWordInDictionary p720 = new P720LongestWordInDictionary();

  @Test
  void example1() {
    assertThat(p720.longestWord(new String[] {"w", "wo", "wor", "worl", "world"}))
        .isEqualTo("world");
  }

  @Test
  void example2() {
    assertThat(
            p720.longestWord(new String[] {"a", "banana", "app", "appl", "ap", "apply", "apple"}))
        .isEqualTo("apple");
  }
}
