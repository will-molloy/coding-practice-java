package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.truth.Correspondence;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P609FindDuplicateFileInSystemTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P609FindDuplicateFileInSystemTest {

  private final P609FindDuplicateFileInSystem p609FindDuplicateFileInSystem =
      new P609FindDuplicateFileInSystem();

  @ParameterizedTest
  @MethodSource
  void examples(String[] paths, Set<Set<String>> expected) {
    assertThat(p609FindDuplicateFileInSystem.findDuplicate(paths))
        .comparingElementsUsing(
            Correspondence.<List<String>, Set<String>>transforming(Set::copyOf, "as set"))
        .containsExactlyElementsIn(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            new String[] {
              "root/a 1.txt(abcd) 2.txt(efgh)",
              "root/c 3.txt(abcd)",
              "root/c/d 4.txt(efgh)",
              "root 4.txt(efgh)"
            },
            Set.of(
                Set.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
                Set.of("root/a/1.txt", "root/c/3.txt"))),
        Arguments.of(
            new String[] {
              "root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)"
            },
            Set.of(
                Set.of("root/a/2.txt", "root/c/d/4.txt"), Set.of("root/a/1.txt", "root/c/3.txt"))));
  }
}
