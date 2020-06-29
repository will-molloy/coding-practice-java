package com.wilmol.hackerrank.interviewpreparationkit.stringmanipulation.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * SherlockValidStringTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class SherlockValidStringTest {

  @Test
  void notValidNeedsTwoDeletions() {
    assertThat(SherlockValidString.isValid("aabbcd")).isFalse();
  }

  @Test
  void notValidNeedsFourOfFiveDeletions() {
    assertThat(SherlockValidString.isValid("aabbccddeefghi")).isFalse();
  }

  @Test
  void notValidThreeFrequenciesOfChars() {
    assertThat(SherlockValidString.isValid("abbccc")).isFalse();
  }

  @Test
  void isValidOnlyOneChar() {
    assertThat(SherlockValidString.isValid("AAAAAAA")).isTrue();
  }

  @Test
  void isValidNeedsOneDeletionsOfHigherCharCount() {
    assertThat(SherlockValidString.isValid("abcdefghhgfedecba")).isTrue();
  }

  @Test
  void isValidNeedsRemovalOfLowerCharCount() {
    assertThat(SherlockValidString.isValid("aaabbbc")).isTrue();
  }
}
