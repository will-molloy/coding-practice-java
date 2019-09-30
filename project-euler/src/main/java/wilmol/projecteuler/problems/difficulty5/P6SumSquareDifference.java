package wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.util.stream.IntStream;

/**
 * Created by Will on 16/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=6>https://projecteuler.net/problem=6</a>
 *
 * <p>Runtime: O(n)
 */
class P6SumSquareDifference {

  public int apply(int n) {
    Preconditions.checkArgument(n > 1);

    int sumOfSquares = IntStream.rangeClosed(1, n).map(i -> i * i).sum();
    int sum = (n + 1) * n / 2;
    int squareOfSum = sum * sum;
    return squareOfSum - sumOfSquares;
  }
}
