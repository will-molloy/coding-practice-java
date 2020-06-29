package com.wilmol.projecteuler.problems.difficulty5;

import java.util.stream.IntStream;

/**
 * <a href=https://projecteuler.net/problem=1>https://projecteuler.net/problem=1</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P1MultiplesOf3And5 {

  public Integer solve(int limit) {
    return IntStream.range(0, limit).filter(i -> i % 3 == 0 || i % 5 == 0).sum();
  }
}
