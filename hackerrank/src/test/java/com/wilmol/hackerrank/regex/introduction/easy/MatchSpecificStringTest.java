package com.wilmol.hackerrank.regex.introduction.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

class MatchSpecificStringTest {

  @Test
  void testMatchCount() {
    assertThat(
            new MatchSpecificString()
                .matchCount(
                    // CHECKSTYLE IGNORE check FOR NEXT 1 LINES
                    "The hackerrank team is on a mission to flatten the world by restructuring the DNA of every company on the planet. We rank programmers based on their coding skills, helping companies source great programmers and reduce the time to hire. As a result, we are revolutionizing the way companies discover and evaluate talented engineers. The hackerrank platform is the destination for the best engineers to hone their skills and companies to contains top engineers."))
        .isEqualTo(2L);
  }
}