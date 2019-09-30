package wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import wilmol.projecteuler.common.Maths;

/**
 * Created by Will on 17/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=10>https://projecteuler.net/problem=10</a>
 *
 * <p>Runtime: O(n * sqrt(n))
 */
class P10SummationOfPrimes {
  public long apply(int below) {
    Preconditions.checkArgument(below > 2);

    return Maths.allPrimesBelow(below).stream().reduce(0L, Long::sum);
  }
}
