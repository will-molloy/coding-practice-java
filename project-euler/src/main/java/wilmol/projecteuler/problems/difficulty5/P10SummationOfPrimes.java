package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.base.Preconditions.checkArgument;

import wilmol.projecteuler.common.Maths;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=10>https://projecteuler.net/problem=10</a>
 *
 * <p>Runtime: O(n log(log(n)))
 */
class P10SummationOfPrimes {

  public long apply(int below) {
    checkArgument(below > 2);

    return Maths.allPrimesBelow(below).stream().mapToLong(i -> i).reduce(0L, Long::sum);
  }
}
