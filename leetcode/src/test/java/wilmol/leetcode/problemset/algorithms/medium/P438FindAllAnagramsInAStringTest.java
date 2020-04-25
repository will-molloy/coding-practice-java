package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-25. */
class P438FindAllAnagramsInAStringTest {

  private final P438FindAllAnagramsInAString p438 = new P438FindAllAnagramsInAString();

  @Test
  void example1() {
    assertThat(p438.findAnagrams("cbaebabacd", "abc")).containsExactly(0, 6);
  }

  @Test
  void example2() {
    assertThat(p438.findAnagrams("abab", "ab")).containsExactly(0, 1, 2);
  }

  @Test
  void pLarger() {
    assertThat(p438.findAnagrams("", "a")).isEmpty();
  }

  @Test
  void bothEmpty() {
    assertThat(p438.findAnagrams("", "")).containsExactly(0);
  }
}
