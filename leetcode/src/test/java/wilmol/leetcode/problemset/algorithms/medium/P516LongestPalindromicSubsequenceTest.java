package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-24. */
class P516LongestPalindromicSubsequenceTest {

  private final P516LongestPalindromicSubsequence p516 = new P516LongestPalindromicSubsequence();

  @Test
  void example1() {
    assertThat(p516.longestPalindromeSubseq("bbbab")).isEqualTo(4);
  }

  @Test
  void example2() {
    assertThat(p516.longestPalindromeSubseq("cbbd")).isEqualTo(2);
  }

  @Test
  void wholeStringIsPalindrome() {
    assertThat(p516.longestPalindromeSubseq("racecar")).isEqualTo(7);
  }

  @Test
  void wholeStringIsPalindromeInterpolated() {
    assertThat(p516.longestPalindromeSubseq("1r2a3c4e5c6a7r8")).isEqualTo(7);
  }

  @Test
  void uniqueCharacters() {
    assertThat(p516.longestPalindromeSubseq("abcxyz123")).isEqualTo(1);
  }

  @Test
  void emptyString() {
    assertThat(p516.longestPalindromeSubseq("")).isEqualTo(0);
  }
}
