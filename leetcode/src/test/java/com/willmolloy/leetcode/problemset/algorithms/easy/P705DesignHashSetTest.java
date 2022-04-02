package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.easy.P705DesignHashSet.MyHashSet;
import org.junit.jupiter.api.Test;

/**
 * P705DesignHashSetTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P705DesignHashSetTest {

  @Test
  void example() {
    MyHashSet hashSet = new MyHashSet();
    hashSet.add(1);
    hashSet.add(2);
    assertThat(hashSet.contains(1)).isTrue();
    assertThat(hashSet.contains(3)).isFalse();
    hashSet.add(2);
    assertThat(hashSet.contains(2)).isTrue();
    hashSet.remove(2);
    assertThat(hashSet.contains(2)).isFalse();
  }
}
