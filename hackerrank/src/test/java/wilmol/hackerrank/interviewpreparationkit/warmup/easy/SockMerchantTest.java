package wilmol.hackerrank.interviewpreparationkit.warmup.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 24/03/2019. */
class SockMerchantTest {

  @Test
  void fourColoursThreePairs() {
    assertThat(SockMerchant.sockMerchant(new int[] {10, 20, 20, 10, 10, 30, 50, 10, 20}))
        .isEqualTo(3);
  }
}
