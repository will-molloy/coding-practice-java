package wilmol.hackerrank.regex.assertions.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-06 at 21:06. */
class PositiveLookbehindTest {

  @Test
  void testMatchCount() {
    assertThat(new PositiveLookbehind().containsCount("123Go!")).isEqualTo(1L);
    assertThat(new PositiveLookbehind().containsCount("123456789")).isEqualTo(4L);
  }
}
