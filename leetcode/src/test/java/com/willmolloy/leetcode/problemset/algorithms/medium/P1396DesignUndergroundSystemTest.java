package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.medium.P1396DesignUndergroundSystem.UndergroundSystem;
import org.junit.jupiter.api.Test;

/**
 * P1396DesignUndergroundSystemTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1396DesignUndergroundSystemTest {

  private static final double TOLERANCE = 1e-5;

  @Test
  void example1() {
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(45, "Leyton", 3);
    undergroundSystem.checkIn(32, "Paradise", 8);
    undergroundSystem.checkIn(27, "Leyton", 10);
    undergroundSystem.checkOut(45, "Waterloo", 15);
    undergroundSystem.checkOut(27, "Waterloo", 20);
    undergroundSystem.checkOut(32, "Cambridge", 22);
    assertThat(undergroundSystem.getAverageTime("Paradise", "Cambridge"))
        .isWithin(TOLERANCE)
        .of(14);
    assertThat(undergroundSystem.getAverageTime("Leyton", "Waterloo")).isWithin(TOLERANCE).of(11);
    undergroundSystem.checkIn(10, "Leyton", 24);
    assertThat(undergroundSystem.getAverageTime("Leyton", "Waterloo")).isWithin(TOLERANCE).of(11);
    undergroundSystem.checkOut(10, "Waterloo", 38);
    assertThat(undergroundSystem.getAverageTime("Leyton", "Waterloo")).isWithin(TOLERANCE).of(12);
  }

  @Test
  void example2() {
    UndergroundSystem undergroundSystem = new UndergroundSystem();
    undergroundSystem.checkIn(10, "Leyton", 3);
    undergroundSystem.checkOut(10, "Paradise", 8);
    assertThat(undergroundSystem.getAverageTime("Leyton", "Paradise")).isWithin(TOLERANCE).of(5);
    undergroundSystem.checkIn(5, "Leyton", 10);
    undergroundSystem.checkOut(5, "Paradise", 16);
    assertThat(undergroundSystem.getAverageTime("Leyton", "Paradise")).isWithin(TOLERANCE).of(5.5);
    undergroundSystem.checkIn(2, "Leyton", 21);
    undergroundSystem.checkOut(2, "Paradise", 30);
    assertThat(undergroundSystem.getAverageTime("Leyton", "Paradise"))
        .isWithin(TOLERANCE)
        .of(6.66667);
  }
}
