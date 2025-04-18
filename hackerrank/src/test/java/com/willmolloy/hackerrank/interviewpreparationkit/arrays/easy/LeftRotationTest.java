package com.willmolloy.hackerrank.interviewpreparationkit.arrays.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * LeftRotationTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class LeftRotationTest {

  @Test
  void rotateLeft4Times() {
    assertThat(LeftRotation.rotLeft(new int[] {1, 2, 3, 4, 5}, 4))
        .isEqualTo(new int[] {5, 1, 2, 3, 4});
  }

  @Test
  void rotateLeft10Times() {
    assertThat(
            LeftRotation.rotLeft(
                new int[] {
                  41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51
                },
                10))
        .isEqualTo(
            new int[] {
              77, 97, 58, 1, 86, 58, 26, 10, 86, 51, 41, 73, 89, 7, 10, 1, 59, 58, 84, 77
            });
  }
}
