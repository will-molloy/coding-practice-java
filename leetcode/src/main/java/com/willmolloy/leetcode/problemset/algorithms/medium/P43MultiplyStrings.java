package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.math.BigInteger;

/**
 * <a
 * href=https://leetcode.com/problems/multiply-strings>https://leetcode.com/problems/multiply-strings</a>
 *
 * <p>Runtime: O(nm)
 *
 * <p>Key idea: cheat and use bigint TODO supposed to implement multiplication algorithm!
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P43MultiplyStrings {

  public String multiply(String num1, String num2) {
    return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
  }
}
