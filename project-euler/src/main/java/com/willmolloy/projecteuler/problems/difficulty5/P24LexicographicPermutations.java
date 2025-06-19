package com.willmolloy.projecteuler.problems.difficulty5;

import com.willmolloy.projecteuler.common.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <a href=https://projecteuler.net/problem=24>https://projecteuler.net/problem=24</a>
 *
 * <p>Runtime: O(n!)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P24LexicographicPermutations {

  public String apply(String seq, int indexStartingFromOne) {
    List<Integer> digits = seq.chars().map(Character::getNumericValue).boxed().toList();

    return Collections.permutations(digits)
        .skip(indexStartingFromOne - 1)
        .findFirst()
        .get()
        .stream()
        .map(String::valueOf)
        .collect(Collectors.joining());
  }
}
