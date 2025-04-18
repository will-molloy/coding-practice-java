package com.willmolloy.hackerrank.regex.groupingcapturing.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MatchWordBoundariesTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class MatchWordBoundariesTest {

  @Test
  void testFinds() {
    assertThat(new MatchWordBoundaries().contains("Found any match?")).isTrue();
    assertThat(new MatchWordBoundaries().contains("I found3 i0")).isTrue();
    assertThat(new MatchWordBoundaries().contains("okyouwin? yes")).isTrue();
    assertThat(new MatchWordBoundaries().contains("sorry my b-ad:P")).isTrue();
    assertThat(new MatchWordBoundaries().contains("Iamdead-4u")).isTrue();
  }

  @Test
  void testDoesNotFind() {
    assertThat(new MatchWordBoundaries().contains("found3 i0")).isFalse();
    assertThat(new MatchWordBoundaries().contains("found3 isdvnslknc98098sdcsdbc")).isFalse();
  }
}
