package com.willmolloy.leetcode.problemset.algorithms.medium;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.HashSet;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations>https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/</a>
 *
 * <p>TODO Runtime: O(b<sup>d</sup>) = O(2<sup>d</sup>) - makes sense that d is proportional to
 * {@code s.length()}?
 *
 * <p>Extra memory: Same as runtime since we store all nodes in the hash set.
 *
 * <p>Key idea: Trying all combinations of {@code add}/{@code rotate} forms a tree. Use DFS to
 * traverse such tree. Use hash set to know when the pattern repeats and we can stop computation.
 *
 * @see P189RotateArray
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
@SuppressFBWarnings("UWF_FIELD_NOT_INITIALIZED_IN_CONSTRUCTOR")
final class P1625LexicographicallySmallestStringAfterApplyingOperations {

  private Set<String> seen;
  private String min;

  public String findLexSmallestString(String s, int a, int b) {
    min = s;
    seen = new HashSet<>();
    seen.add(s);
    dfs(s, a, b);
    return min;
  }

  private void dfs(String s, int a, int b) {
    String add = add(s, a);
    if (seen.add(add)) {
      min = min(min, add);
      dfs(add, a, b);
    }

    String rotate = rotate(s, b);
    if (seen.add(rotate)) {
      min = min(min, rotate);
      dfs(rotate, a, b);
    }
  }

  // add a to odd indices
  private String add(String s, int a) {
    char[] chars = s.toCharArray();
    for (int i = 1; i < chars.length; i += 2) {
      int next = (Character.digit(chars[i], 10) + a) % 10;
      chars[i] = (char) (next + '0');
    }
    return new String(chars);
  }

  // rotate right by b
  private String rotate(String s, int b) {
    char[] chars = s.toCharArray();
    char[] copy = chars.clone();
    for (int i = 0; i < chars.length; i++) {
      chars[i] = copy[(i + (chars.length - b)) % chars.length];
    }
    return new String(chars);
  }

  private String min(String a, String b) {
    return a.compareTo(b) < 0 ? a : b;
  }
}
