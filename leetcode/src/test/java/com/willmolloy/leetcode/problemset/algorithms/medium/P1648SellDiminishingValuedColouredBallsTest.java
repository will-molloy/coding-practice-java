package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1648SellDiminishingValuedColouredBallsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1648SellDiminishingValuedColouredBallsTest {

  private final P1648SellDiminishingValuedColouredBalls p1648 =
      new P1648SellDiminishingValuedColouredBalls();

  @ParameterizedTest
  @MethodSource
  void examples(int[] inventory, int orders, int expected) {
    assertThat(p1648.maxProfit(inventory, orders)).isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(new int[] {2, 5}, 4, 14),
        Arguments.of(new int[] {3, 5}, 6, 19),
        Arguments.of(new int[] {2, 8, 4, 10, 6}, 20, 110),
        Arguments.of(new int[] {1000000000}, 1000000000, 21));
  }

  @ParameterizedTest
  @MethodSource
  void intOverflow(int[] inventory, int orders, int expected) {
    assertThat(p1648.maxProfit(inventory, orders)).isEqualTo(expected);
  }

  static Stream<Arguments> intOverflow() {
    return Stream.of(
        Arguments.of(new int[] {497978859, 167261111, 483575207, 591815159}, 836556809, 373219333),
        Arguments.of(
            new int[] {
              701695700, 915736894, 35093938, 364836059, 452183894, 951826038, 861556610, 441929847,
              842650446, 858413011, 457896886, 35119509, 776620034, 396643588, 83585103, 681609037
            },
            598226067,
            525803723),
        Arguments.of(
            new int[] {
              565259708, 715164401, 716563713, 958255469, 844600740, 823949511, 180479359,
              287829385, 164248818, 73361150, 230686692, 322986846, 598720034, 338241127, 748922260,
              181241085, 833659853, 509571179, 250093451, 690995620, 703292727, 595636202
            },
            650114768,
            997286992));
  }

  @Test
  void discussExample() {
    assertThat(p1648.maxProfit(new int[] {20, 20, 20, 10}, 40)).isEqualTo(557);
  }
}
