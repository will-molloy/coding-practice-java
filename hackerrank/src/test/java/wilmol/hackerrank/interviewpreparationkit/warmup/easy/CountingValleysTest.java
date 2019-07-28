package wilmol.hackerrank.interviewpreparationkit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 24/03/2019. */
class CountingValleysTest {

  @Test
  void oneValley() {
    assertThat(CountingValleys.countingValleys("UDDDUDUU")).isEqualTo(1);
  }

  @Test
  void twoValleys() {
    assertThat(CountingValleys.countingValleys("DDUUDDUDUUUD")).isEqualTo(2);
  }
}
