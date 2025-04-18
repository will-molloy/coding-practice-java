package com.willmolloy.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * FindAWordTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class FindAWordTest {

  @Test
  void sampleTestCase0() {
    List<String> lines =
        ImmutableList.of(
            "1", "foo bar (foo) bar foo-bar foo_bar foo'bar bar-foo bar, foo.", "1", "foo");
    assertThat(FindAWord.process(lines)).containsExactly(6);
  }
}
