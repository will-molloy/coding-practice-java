package wilmol.hackerrank.regex.applications.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-10-19. */
class FindAWordTest {

  @Test
  void sampleTestCase0() {
    List<String> lines =
        ImmutableList.of(
            "1", "foo bar (foo) bar foo-bar foo_bar foo'bar bar-foo bar, foo.", "1", "foo");
    assertThat(FindAWord.process(lines)).containsExactly(6);
  }
}
