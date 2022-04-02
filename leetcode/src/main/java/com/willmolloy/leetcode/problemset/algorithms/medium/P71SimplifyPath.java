package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

/**
 * <a
 * href=https://leetcode.com/problems/simplify-path>https://leetcode.com/problems/simplify-path/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key: Simulate with stack. Ignore "..", "." and "".
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P71SimplifyPath {

  public String simplifyPath(String path) {
    Deque<String> stack = new ArrayDeque<>();
    Set<String> ignore = Set.of("..", ".", "");

    for (String dir : path.split("/")) {
      if (dir.equals("..") && !stack.isEmpty()) {
        stack.pop();
      } else if (!ignore.contains(dir)) {
        stack.push(dir);
      }
    }

    String s = "";
    for (String dir : stack) {
      s = "/" + dir + s;
    }
    return s.isEmpty() ? "/" : s;
  }
}
