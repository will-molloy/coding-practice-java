package com.wilmol.leetcode.problemset.algorithms.medium;

import java.math.BigInteger;

/**
 * Created by wilmol on 2019-11-30.
 *
 * <p><a
 * href=https://leetcode.com/problems/multiply-strings>https://leetcode.com/problems/multiply-strings</a>
 *
 * <p>Runtime: O(nm)
 *
 * <p>Key: cheat and use bigint TODO supposed to implement multiplication algorithm!
 */
class P43MultiplyStrings {

  public String multiply(String num1, String num2) {
    return new BigInteger(num1).multiply(new BigInteger(num2)).toString();
  }
}
