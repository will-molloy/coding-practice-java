package wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import java.util.stream.LongStream;

/**
 * Created by Will on 16/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=3>https://projecteuler.net/problem=3</a>
 *
 * <p>Runtime: O(n)
 */
class P3LargestPrimeFactor {

  public long apply(long n) {
    Preconditions.checkArgument(n > 0);

    return LongStream.iterate((long) Math.sqrt(n), i -> i - 1)
        .filter(p -> n % p == 0 && LongMath.isPrime(p))
        .findFirst()
        .orElse(2);
  }
}
