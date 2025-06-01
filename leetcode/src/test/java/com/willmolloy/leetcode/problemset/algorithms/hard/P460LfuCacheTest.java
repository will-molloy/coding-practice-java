package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link P460LfuCache}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P460LfuCacheTest {

  @Test
  void example() {
    P460LfuCache lfu = new P460LfuCache(2);
    lfu.put(1, 1);
    lfu.put(2, 2);
    assertThat(lfu.get(1)).isEqualTo(1);
    lfu.put(3, 3);
    assertThat(lfu.get(2)).isEqualTo(-1);
    assertThat(lfu.get(3)).isEqualTo(3);
    lfu.put(4, 4);
    assertThat(lfu.get(1)).isEqualTo(-1);
    assertThat(lfu.get(3)).isEqualTo(3);
    assertThat(lfu.get(4)).isEqualTo(4);
  }
}
