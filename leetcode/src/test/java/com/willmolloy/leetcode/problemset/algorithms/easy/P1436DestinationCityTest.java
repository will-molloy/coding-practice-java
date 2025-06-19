package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P1436DestinationCityTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1436DestinationCityTest {

  private final P1436DestinationCity p1436 = new P1436DestinationCity();

  @Test
  void example1() {
    assertThat(
            p1436.destCity(
                List.of(
                    List.of("London", "New York"),
                    List.of("New York", "Lima"),
                    List.of("Lima", "Sao Paulo"))))
        .isEqualTo("Sao Paulo");
  }

  @Test
  void example2() {
    assertThat(p1436.destCity(List.of(List.of("B", "C"), List.of("D", "B"), List.of("C", "A"))))
        .isEqualTo("A");
  }

  @Test
  void example3() {
    assertThat(p1436.destCity(List.of(List.of("A", "Z")))).isEqualTo("Z");
  }
}
