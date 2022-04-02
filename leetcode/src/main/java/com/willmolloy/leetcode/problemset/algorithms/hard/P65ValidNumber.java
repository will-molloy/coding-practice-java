package com.willmolloy.leetcode.problemset.algorithms.hard;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://leetcode.com/problems/valid-number>https://leetcode.com/problems/valid-number/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(1)
 *
 * <p>Key: Regex.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P65ValidNumber {

  public boolean isNumber(String s) {
    String decimal = "[+-]?(\\d+[.]|\\d+[.]\\d+|[.]\\d+)";
    String integer = "[+-]?\\d+";
    Pattern p = Pattern.compile(String.format("(%s|%s)([eE]%s)?", decimal, integer, integer));
    Matcher m = p.matcher(s);
    return m.matches();
  }
}
