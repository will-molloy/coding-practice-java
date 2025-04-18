package com.willmolloy.projecteuler.problems.difficulty5;

import com.willmolloy.projecteuler.common.Collections;
import java.util.List;
import java.util.Locale;

/**
 * <a href=https://projecteuler.net/problem=22>https://projecteuler.net/problem=22</a>
 *
 * <p>Runtime: O(n log n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P22NameScores {

  public int apply(List<String> names) {
    return Collections.zipWithIndex(names.stream().sorted())
        .mapToInt((p) -> score(p.getLeft()) * (p.getRight() + 1))
        .sum();
  }

  private int score(String name) {
    return name.toUpperCase(Locale.getDefault()).chars().map(c -> c - 'A' + 1).sum();
  }
}
