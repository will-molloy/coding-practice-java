package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.primitives.ImmutableIntArray;
import org.junit.jupiter.api.Test;

/**
 * P849MaximiseDistanceToClosestPersonTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P849MaximiseDistanceToClosestPersonTest {

  private final P849MaximiseDistanceToClosestPerson p849 =
      new P849MaximiseDistanceToClosestPerson();

  @Test
  void inBetweenOdd() {
    assertThat(p849.maxDistToClosest(ImmutableIntArray.of(1, 0, 0, 0, 1, 0, 1).toArray()))
        .isEqualTo(2);
  }

  @Test
  void inBetweenEven() {
    assertThat(p849.maxDistToClosest(ImmutableIntArray.of(1, 0, 0, 1, 0, 1).toArray()))
        .isEqualTo(1);
  }

  @Test
  void first() {
    assertThat(p849.maxDistToClosest(ImmutableIntArray.of(0, 1).toArray())).isEqualTo(1);
  }

  @Test
  void last() {
    assertThat(p849.maxDistToClosest(ImmutableIntArray.of(1, 0, 0, 0).toArray())).isEqualTo(3);
  }
}
