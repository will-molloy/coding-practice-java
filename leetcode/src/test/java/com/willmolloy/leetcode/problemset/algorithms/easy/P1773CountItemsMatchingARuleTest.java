package com.willmolloy.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * P1773CountItemsMatchingARuleTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1773CountItemsMatchingARuleTest {

  private final P1773CountItemsMatchingARule p1773CountItemsMatchingARule =
      new P1773CountItemsMatchingARule();

  @ParameterizedTest
  @MethodSource
  void examples(List<List<String>> items, String ruleKey, String ruleValue, int expected) {
    assertThat(p1773CountItemsMatchingARule.countMatches(items, ruleKey, ruleValue))
        .isEqualTo(expected);
  }

  static Stream<Arguments> examples() {
    return Stream.of(
        Arguments.of(
            List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")),
            "color",
            "silver",
            1),
        Arguments.of(
            List.of(
                List.of("phone", "blue", "pixel"),
                List.of("computer", "silver", "lenovo"),
                List.of("phone", "gold", "iphone")),
            "type",
            "phone",
            2));
  }
}
