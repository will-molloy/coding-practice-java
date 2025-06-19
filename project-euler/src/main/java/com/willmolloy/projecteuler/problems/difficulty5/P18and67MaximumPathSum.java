package com.willmolloy.projecteuler.problems.difficulty5;

import static com.willmolloy.projecteuler.common.Tuples.function;

import com.google.common.base.Preconditions;
import com.willmolloy.projecteuler.common.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <a href=https://projecteuler.net/problem=18>https://projecteuler.net/problem=18</a>
 *
 * <p><a href=https://projecteuler.net/problem=67>https://projecteuler.net/problem=67</a>
 *
 * <p>Runtime: O(n) ?
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P18and67MaximumPathSum {

  public int apply(List<List<Integer>> triangle) {
    Preconditions.checkArgument(
        triangle.size() > 0 && triangle.getFirst().size() > 0,
        "Triangle must have at least one element.");

    if (triangle.size() == 1) {
      return triangle.getFirst().getFirst();
    } else {
      List<Integer> secondLast = triangle.get(triangle.size() - 2);
      List<Integer> reducedLast =
          Collections.sliding(triangle.getLast(), 2).stream()
              .map(l -> l.stream().max(Comparator.naturalOrder()).orElse(0))
              .toList();

      List<Integer> newLast =
          Collections.zip(secondLast, reducedLast).map(function(Integer::sum)).toList();

      List<List<Integer>> newTriangle = new ArrayList<>(triangle.subList(0, triangle.size() - 2));
      newTriangle.add(newLast);

      return apply(newTriangle);
    }
  }
}
