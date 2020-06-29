package com.wilmol.leetcode.problemset.algorithms.medium;

import java.util.regex.Pattern;

/**
 * <a
 * href=https://leetcode.com/problems/validate-ip-address>https://leetcode.com/problems/validate-ip-address/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra space: O(1)
 *
 * <p>Key: Regular expressions.
 *
 * @see com.wilmol.hackerrank.regex.applications.easy.IpAddressValidation
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P468ValidateIpAddress {

  private static final String BYTE_PATTERN = "(2(5[0-5]|[0-4][0-9])|1[0-9]{1,2}|[1-9]?[0-9])";
  private static final Pattern IPV4_PATTERN =
      Pattern.compile("^(" + BYTE_PATTERN + "[.]){3}" + BYTE_PATTERN + "$");

  private static final String HEX_PATTERN = "[0-9a-f]{1,4}";
  private static final Pattern IPV6_PATTERN =
      Pattern.compile("^(" + HEX_PATTERN + "[:]){7}" + HEX_PATTERN + "$", Pattern.CASE_INSENSITIVE);

  public String validIpAddress(String ip) {
    if (IPV4_PATTERN.matcher(ip).matches()) {
      return "IPv4";
    } else if (IPV6_PATTERN.matcher(ip).matches()) {
      return "IPv6";
    } else {
      return "Neither";
    }
  }
}
