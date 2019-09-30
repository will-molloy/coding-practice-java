package wilmol.projecteuler.problems.difficulty5;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import wilmol.projecteuler.common.Collections;

/**
 * Created by Will on 18/03/2019.
 *
 * <p><a href=https://projecteuler.net/problem=24>https://projecteuler.net/problem=24</a>
 *
 * <p>Runtime: O(n!)
 */
class P24LexicographicPermutations {

  public String apply(String seq, int indexStartingFromOne) {
    List<Integer> digits =
        seq.chars()
            .map(Character::getNumericValue)
            .boxed()
            .collect(ImmutableList.toImmutableList());

    return Collections.permutations(digits).skip(indexStartingFromOne - 1).findFirst().get()
        .stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
