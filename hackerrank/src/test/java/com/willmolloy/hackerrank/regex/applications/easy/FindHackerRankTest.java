package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.willmolloy.hackerrank.regex.applications.easy.FindHackerRank.findHackerRank;

import com.willmolloy.hackerrank.regex.applications.easy.FindHackerRank.Type;
import org.junit.jupiter.api.Test;

/**
 * FindHackerRankTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class FindHackerRankTest {

  @Test
  void ends() {
    assertThat(findHackerRank(" hackerrank")).isEqualTo(Type.END);
    assertThat(findHackerRank("i love hackerrank")).isEqualTo(Type.END);
  }

  @Test
  void starts() {
    assertThat(findHackerRank("hackerrank ")).isEqualTo(Type.START);
    assertThat(findHackerRank("hackerrank is an awesome place for programmers"))
        .isEqualTo(Type.START);
  }

  @Test
  void both() {
    assertThat(findHackerRank("hackerrank")).isEqualTo(Type.START_AND_END);
    assertThat(findHackerRank("hackerrankhackerrank")).isEqualTo(Type.START_AND_END);
    assertThat(findHackerRank("hackerrank hackerrank")).isEqualTo(Type.START_AND_END);
    assertThat(findHackerRank("hackerrank abc123 hackerrank")).isEqualTo(Type.START_AND_END);
  }

  @Test
  void none() {
    assertThat(findHackerRank(" hackerrank ")).isEqualTo(Type.NONE);
    assertThat(findHackerRank("i think hackerrank is a great place to hangout"))
        .isEqualTo(Type.NONE);
    assertThat(findHackerRank("nothing at all")).isEqualTo(Type.NONE);
  }
}
