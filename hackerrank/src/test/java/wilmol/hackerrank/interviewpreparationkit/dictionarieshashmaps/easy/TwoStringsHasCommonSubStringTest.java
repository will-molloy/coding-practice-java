package wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 24/03/2019. */
class TwoStringsHasCommonSubStringTest {

  @Test
  void hasCommon() {
    assertThat(TwoStringsHasCommonSubString.hasCommonSubString("hello", "world")).isTrue();
  }

  @Test
  void doesNotHaveCommon() {
    assertThat(TwoStringsHasCommonSubString.hasCommonSubString("hi", "world")).isFalse();
  }
}
