package com.wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-04. */
class P1108DefangingAnIpAddressTest {

  private final P1108DefangingAnIpAddress fun = new P1108DefangingAnIpAddress();

  @Test
  void example1() {
    assertThat(fun.defangIPaddr("1.1.1.1")).isEqualTo("1[.]1[.]1[.]1");
  }

  @Test
  void example2() {
    assertThat(fun.defangIPaddr("255.100.50.0")).isEqualTo("255[.]100[.]50[.]0");
  }
}
