package com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.medium;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.medium.SherlockValidString.isValid;

import org.junit.jupiter.api.Test;

class SherlockValidStringTest
{

  @Test
  void notValidNeedsTwoDeletions()
  {
    assertThat(isValid("aabbcd")).isFalse();
  }

  @Test
  void notValidNeedsFourOfFiveDeletions()
  {
    assertThat(isValid("aabbccddeefghi")).isFalse();
  }

  @Test
  void notValidThreeFrequenciesOfChars()
  {
    assertThat(isValid("abbccc")).isFalse();
  }

  @Test
  void isValidOnlyOneChar()
  {
    assertThat(isValid("AAAAAAA")).isTrue();
  }

  @Test
  void isValidNeedsOneDeletionsOfHigherCharCount()
  {
    assertThat(isValid("abcdefghhgfedecba")).isTrue();
  }

  @Test
  void isValidNeedsRemovalOfLowerCharCount()
  {
    assertThat(isValid("aaabbbc")).isTrue();
  }

}
