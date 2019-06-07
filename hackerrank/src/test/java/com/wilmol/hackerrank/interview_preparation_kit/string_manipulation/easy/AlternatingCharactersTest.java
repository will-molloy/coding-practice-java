package com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.interview_preparation_kit.string_manipulation.easy.AlternatingCharacters.alternatingCharacters;

import org.junit.jupiter.api.Test;

class AlternatingCharactersTest
{

  @Test
  void emptyString()
  {
    assertThat(alternatingCharacters("")).isEqualTo(0);
  }

  @Test
  void noAlternating()
  {
    assertThat(alternatingCharacters("AAAAA")).isEqualTo(4);
  }

  @Test
  void onlyAlternating()
  {
    assertThat(alternatingCharacters("ABABABA")).isEqualTo(0);
  }

  @Test
  void mixture()
  {
    assertThat(alternatingCharacters("AABBABABAABB")).isEqualTo(4);
  }

}
