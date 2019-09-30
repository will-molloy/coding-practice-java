package wilmol.projecteuler.problems.difficulty15;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by will on 2019-04-21 at 3:21 PM. */
class P51PrimeDigitReplacementsTest {

  @Test
  void smallestOfSixPrimeFamily() {
    assertThat(P51PrimeDigitReplacements.smallestPrimeOfNSizedPrimeFamilyFormedByReplacingDigits(6))
        .isEqualTo(13);
  }

  @Test
  void smallestOfSevenPrimeFamily() {
    assertThat(P51PrimeDigitReplacements.smallestPrimeOfNSizedPrimeFamilyFormedByReplacingDigits(7))
        .isEqualTo(56_003);
  }

  @Test
  void smallestOfEightPrimeFamily() {
    assertThat(P51PrimeDigitReplacements.smallestPrimeOfNSizedPrimeFamilyFormedByReplacingDigits(8))
        .isEqualTo(121_313);
  }

  @Test
  void testTemplater() {
    assertThat(P51PrimeDigitReplacements.templates("10000"))
        .containsExactly(
            "x0000", "xx000", "xxx00", "xxxx0", "xx0x0", "x0x00", "x0xx0", "x00x0", "1x000",
            "1xx00", "1xxx0", "1x0x0", "10x00", "10xx0", "100x0");
  }
}
