package com.willmolloy.projecteuler.problems.difficulty5;

import static com.google.common.base.Preconditions.checkArgument;

import com.willmolloy.projecteuler.common.Maths;

/**
 * <a href=https://projecteuler.net/problem=10>https://projecteuler.net/problem=10</a>
 *
 * <p>Runtime: O(n log(log(n)))
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P10SummationOfPrimes {

  public long apply(int below) {
    checkArgument(below > 2);

    return Maths.allPrimesBelow(below).stream().mapToLong(i -> i).reduce(0L, Long::sum);
  }
}
