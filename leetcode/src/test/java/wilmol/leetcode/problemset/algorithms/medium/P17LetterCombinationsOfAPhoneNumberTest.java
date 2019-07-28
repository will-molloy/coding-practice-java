package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-07-21 at 15:42. */
class P17LetterCombinationsOfAPhoneNumberTest {

  private final P17LetterCombinationsOfAPhoneNumber function =
      new P17LetterCombinationsOfAPhoneNumber();

  @Test
  void example() {
    assertThat(function.letterCombinations("23"))
        .containsExactly("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
  }

  @Test
  void threeDigits() {
    assertThat(function.letterCombinations("234"))
        .containsExactly(
            "adg", "adh", "adi", "aeg", "aeh", "aei", "afg", "afh", "afi", "bdg", "bdh", "bdi",
            "beg", "beh", "bei", "bfg", "bfh", "bfi", "cdg", "cdh", "cdi", "ceg", "ceh", "cei",
            "cfg", "cfh", "cfi");
  }

  @Test
  void withDigitWithFourLetters() {
    assertThat(function.letterCombinations("27"))
        .containsExactly("ap", "aq", "ar", "as", "bp", "bq", "br", "bs", "cp", "cq", "cr", "cs");
  }

  @Test
  void nullOrEmpty() {
    assertThat(function.letterCombinations(null)).isEmpty();
    assertThat(function.letterCombinations("")).isEmpty();
  }
}
