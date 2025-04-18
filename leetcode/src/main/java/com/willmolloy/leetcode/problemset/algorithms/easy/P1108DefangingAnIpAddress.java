package com.willmolloy.leetcode.problemset.algorithms.easy;

/**
 * <a
 * href=https://leetcode.com/problems/defanging-an-ip-address>https://leetcode.com/problems/defanging-an-ip-address</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Space: O(1)
 *
 * <p>Key idea: knowledge of Java regular expression API
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1108DefangingAnIpAddress {

  public String defangIPaddr(String address) {
    return address.replaceAll("[.]", "[.]");
  }
}
