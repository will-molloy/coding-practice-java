package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-13 at 21:19. */
class P9PalindromeNumberTest {

  private final P9PalindromeNumber function = new P9PalindromeNumber();

  @Test
  void example1IsPalindrome() {
    assertThat(function.isPalindrome(121)).isTrue();
  }

  @Test
  void example2IsNotPalindrome() {
    assertThat(function.isPalindrome(-121)).isFalse();
  }

  @Test
  void example3IsNotPalindrome() {
    assertThat(function.isPalindrome(10)).isFalse();
  }

  @Test
  void singleDigitIsPalindrome() {
    assertThat(function.isPalindrome(0)).isTrue();
    assertThat(function.isPalindrome(1)).isTrue();
    assertThat(function.isPalindrome(6)).isTrue();
    assertThat(function.isPalindrome(9)).isTrue();
  }
}
