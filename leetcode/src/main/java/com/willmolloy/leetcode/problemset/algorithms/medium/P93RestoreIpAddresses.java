package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://leetcode.com/problems/restore-ip-addresses>https://leetcode.com/problems/restore-ip-addresses</a>
 *
 * <p>Runtime: O(1) input doesn't grow
 *
 * <p>Space: O(1) input doesn't grow
 *
 * <p>Key idea: depth first search (back tracking generation, similar to permutation problem)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P93RestoreIpAddresses {

  // TODO can use some counter parameter to count number of "\.\d+" added, cheaper than using Regex

  // not a perfect IP address regex,
  // but works in this case because we check the digit sequences before concatenating
  private static final Pattern VALID_IP = Pattern.compile("^(\\d+[.]){3}.*");

  private static final Pattern LEADING_ZERO = Pattern.compile("^0\\d.*");

  public List<String> restoreIpAddresses(String s) {
    // use DFS to generate the IPs
    List<String> ips = new ArrayList<>();
    restoreIpAddresses(ips, "", s);
    return ips;
  }

  private void restoreIpAddresses(List<String> ips, String candidateIp, String s) {

    if (VALID_IP.matcher(candidateIp).matches()) {
      if (s.isEmpty()) {
        // exhausted all digits in s and candidate Ip is valid, add new result
        ips.add(candidateIp);
      }
      // candidate Ip matches, but didn't use all the digits in s, throw away result
      return;
    }

    for (int prefixLength = 1; prefixLength <= 3; prefixLength++) {
      if (s.length() < prefixLength) {
        // avoids string index out of bounds
        break;
      }
      // try all prefixes of size 1, 2, and 3
      String prefix = s.substring(0, prefixLength);
      // can use if less than 255 and it doesn't have leading zeroes
      if (Integer.parseInt(prefix) <= 255 && !LEADING_ZERO.matcher(prefix).matches()) {
        restoreIpAddresses(
            ips,
            candidateIp + (!candidateIp.isEmpty() ? "." : "") + prefix,
            s.substring(prefixLength));
      }
    }
  }
}
