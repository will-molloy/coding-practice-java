package com.wilmol.leetcode.problemset.algorithms.easy;

/**
 * Created by wilmol on 2020-04-04.
 *
 * <p><a
 * href=https://leetcode.com/problems/defanging-an-ip-address>https://leetcode.com/problems/defanging-an-ip-address</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key: knowledge of Java regular expression API
 */
class P1108DefangingAnIpAddress {

  public String defangIPaddr(String address) {
    return address.replaceAll("[.]", "[.]");
  }
}
