package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P458PoorPigsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P458PoorPigsTest {

  private final P458PoorPigs p458 = new P458PoorPigs();

  @Test
  void example() {
    assertThat(p458.poorPigs(1000, 15, 60)).isEqualTo(5);
  }

  @Test
  void exampleBut25Buckets() {
    assertThat(p458.poorPigs(25, 15, 60)).isEqualTo(2);
  }
}
