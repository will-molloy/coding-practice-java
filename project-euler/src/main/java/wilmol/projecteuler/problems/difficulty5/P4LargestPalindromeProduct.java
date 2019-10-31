package wilmol.projecteuler.problems.difficulty5;

import com.google.common.base.Preconditions;
import java.util.function.Supplier;
import java.util.stream.LongStream;
import wilmol.projecteuler.common.Strings;

/**
 * Created by Will on 16/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=4>https://projecteuler.net/problem=4</a>
 *
 * <p>Runtime: O(n ^ 2)
 */
class P4LargestPalindromeProduct {

  public long apply(int numDigits) {
    Preconditions.checkArgument(numDigits > 0);

    int end = (int) Math.pow(10, numDigits) - 1;
    int start = (int) Math.pow(10, numDigits - 1);

    Supplier<LongStream> range = () -> LongStream.rangeClosed(start, end);

    return range
        .get()
        .flatMap(a -> range.get().map(b -> a * b))
        .filter(n -> Strings.isPalindrome(String.valueOf(n)))
        .max()
        .orElse(0);
  }
}