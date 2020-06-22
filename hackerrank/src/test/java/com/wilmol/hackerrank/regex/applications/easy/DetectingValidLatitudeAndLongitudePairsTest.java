package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-07 at 19:01. */
class DetectingValidLatitudeAndLongitudePairsTest {

  @Test
  void testMatches() {
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(75, 180)")).isTrue();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(+75, +180)")).isTrue();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(-75.123345, -180.0)")).isTrue();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(+90.0, -147.45)")).isTrue();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(77.11112223331, 149.99999999)"))
        .isTrue();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(90.00, 180.000000)")).isTrue();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(0.00, 100.000000)")).isTrue();
  }

  @Test
  void testDoesNotMatch() {
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(-090.00000, -180.0000)"))
        .isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(90., 180.)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(+90, +180.2)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(77.11112223331, 249.99999999)"))
        .isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(+190.0, -147.45)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(75, 280)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(91, 180)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(-91, 180)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(-90, 181)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(-90, -181)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(75, 180")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(75,180)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("75, 180)")).isFalse();
    assertThat(DetectingValidLatitudeAndLongitudePairs.isValid("(75, 180))")).isFalse();
  }
}
