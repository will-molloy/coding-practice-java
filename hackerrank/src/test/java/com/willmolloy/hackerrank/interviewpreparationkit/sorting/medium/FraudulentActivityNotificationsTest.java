package com.willmolloy.hackerrank.interviewpreparationkit.sorting.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * FraudulentActivityNotificationsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class FraudulentActivityNotificationsTest {

  @Test
  void sampleInput0() {
    assertThat(
            FraudulentActivityNotifications.activityNotifications(
                new int[] {2, 3, 4, 2, 3, 6, 8, 4, 5}, 5))
        .isEqualTo(2);
  }

  @Test
  void sampleInput1() {
    assertThat(FraudulentActivityNotifications.activityNotifications(new int[] {1, 2, 3, 4, 4}, 4))
        .isEqualTo(0);
  }

  @Test
  void sampleInput2() {
    assertThat(
            FraudulentActivityNotifications.activityNotifications(
                new int[] {10, 20, 30, 40, 50}, 3))
        .isEqualTo(1);
  }
}
