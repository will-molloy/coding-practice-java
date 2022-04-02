package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;
import static java.util.stream.Collectors.toList;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P49GroupAnagramsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P49GroupAnagramsTest {

  private final P49GroupAnagrams fun = new P49GroupAnagrams();

  @Test
  void example() {
    List<List<String>> lists =
        fun.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"});
    // sort inner lists since order doesn't matter
    List<List<String>> sorted =
        lists.stream().map(list -> list.stream().sorted().collect(toList())).collect(toList());
    assertThat(sorted)
        .containsExactly(
            ImmutableList.of("ate", "eat", "tea"),
            ImmutableList.of("nat", "tan"),
            ImmutableList.of("bat"));
  }
}
