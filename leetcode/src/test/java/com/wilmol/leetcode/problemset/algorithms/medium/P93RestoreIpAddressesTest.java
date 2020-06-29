package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * P93RestoreIpAddressesTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P93RestoreIpAddressesTest {

  private final P93RestoreIpAddresses func = new P93RestoreIpAddresses();

  @Test
  void example() {
    assertThat(func.restoreIpAddresses("25525511135"))
        .containsExactly("255.255.11.135", "255.255.111.35");
  }

  @Test
  void filterOutLeadingZeroes() {
    assertThat(func.restoreIpAddresses("010010")).containsExactly("0.10.0.10", "0.100.1.0");
  }
}
