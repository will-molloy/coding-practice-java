package com.willmolloy.leetcode.problemset.algorithms.easy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * <a href=https://leetcode.com/problems/fizz-buzz>https://leetcode.com/problems/fizz-buzz/</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Extra memory: O(n)
 *
 * <p>Key idea: Build up the string, fewer conditions compared to testing every case.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P412FizzBuzz {

  public List<String> fizzBuzz(int n) {
    return IntStream.rangeClosed(1, n)
        .mapToObj(
            i -> {
              String s = "";
              if (i % 3 == 0) {
                s += "Fizz";
              }
              if (i % 5 == 0) {
                s += "Buzz";
              }
              if (s.isEmpty()) {
                s += i;
              }
              return s;
            })
        .collect(Collectors.toList());
  }
}
