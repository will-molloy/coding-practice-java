package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-10-20. */
class TheBritishAndAmericanStyleOfSpellingTest {

  @Test
  void testCase0() {
    assertThat(
            TheBritishAndAmericanStyleOfSpelling.process(
                ImmutableList.of(
                    "2",
                    "hackerrank ui is easy to familiarise with",
                    "to familiarize oneself with ui of hackerrank is easy",
                    "1",
                    "familiarize")))
        .containsExactly(2);
  }

  @Test
  void testCase1() {
    assertThat(
            TheBritishAndAmericanStyleOfSpelling.process(
                ImmutableList.of(
                    "7",
                    // CHECKSTYLE IGNORE LineLength FOR NEXT 1 LINES
                    "unfair arrival faint region pride realise paralyse length officially disturbing",
                    "call fashionable room take claim capable biscuit cough qualified realze",
                    "decoration indeed caramelise gas habit downward salad realize on knee",
                    "catalyse blade artistic put careless league final waste catalyse bedroom",
                    // CHECKSTYLE IGNORE LineLength FOR NEXT 1 LINES
                    "door materialize catalyse round point routine celebration paralyse stranger weather",
                    // CHECKSTYLE IGNORE LineLength FOR NEXT 1 LINES
                    "artificially materialise personally elegant lane celebration statement whom tend bone",
                    "realise infect coloured planet pet estimate lane infectious destroy exchange",
                    "9",
                    "materialize",
                    "catalyze",
                    "realize",
                    "hydrolyze",
                    "caramelize",
                    "recognize",
                    "organize",
                    "paralyze",
                    "colonize")))
        .containsExactly(2, 3, 3, 0, 1, 0, 0, 2, 0)
        .inOrder();
  }
}
