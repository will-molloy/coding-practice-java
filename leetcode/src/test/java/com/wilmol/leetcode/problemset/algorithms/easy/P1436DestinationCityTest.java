package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/**
 * P1436DestinationCityTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1436DestinationCityTest {

  private final P1436DestinationCity p1436 = new P1436DestinationCity();

  @Test
  void example1() {
    assertThat(
            p1436.destCity(
                ImmutableList.of(
                    ImmutableList.of("London", "New York"),
                    ImmutableList.of("New York", "Lima"),
                    ImmutableList.of("Lima", "Sao Paulo"))))
        .isEqualTo("Sao Paulo");
  }

  @Test
  void example2() {
    assertThat(
            p1436.destCity(
                ImmutableList.of(
                    ImmutableList.of("B", "C"),
                    ImmutableList.of("D", "B"),
                    ImmutableList.of("C", "A"))))
        .isEqualTo("A");
  }

  @Test
  void example3() {
    assertThat(p1436.destCity(ImmutableList.of(ImmutableList.of("A", "Z")))).isEqualTo("Z");
  }
}
