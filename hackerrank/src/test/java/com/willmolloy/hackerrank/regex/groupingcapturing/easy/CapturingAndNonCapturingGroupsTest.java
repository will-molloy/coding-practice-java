package com.willmolloy.hackerrank.regex.groupingcapturing.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * CapturingAndNonCapturingGroupsTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class CapturingAndNonCapturingGroupsTest {

  @Test
  void testFinds() {
    assertThat(new CapturingAndNonCapturingGroups().contains("okokok! cya")).isTrue();
    assertThat(new CapturingAndNonCapturingGroups().contains("oookokokokokoko")).isTrue();
    assertThat(new CapturingAndNonCapturingGroups().contains("okokokokokok")).isTrue();
  }

  @Test
  void testDoesNotFind() {
    assertThat(new CapturingAndNonCapturingGroups().contains("ok okokkonooK")).isFalse();
    assertThat(new CapturingAndNonCapturingGroups().contains("okok-orokok")).isFalse();
    assertThat(new CapturingAndNonCapturingGroups().contains("KOKOKOKOKOKOKO")).isFalse();
    assertThat(new CapturingAndNonCapturingGroups().contains("ok ok ok ok")).isFalse();
  }
}
