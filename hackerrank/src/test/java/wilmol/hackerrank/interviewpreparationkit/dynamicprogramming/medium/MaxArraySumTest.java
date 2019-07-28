package wilmol.hackerrank.interviewpreparationkit.dynamicprogramming.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/** Created by Will on 26/03/2019. */
class MaxArraySumTest {

  @Test
  void listOfSize5() {
    assertThat(MaxArraySum.maxSubsetSum(List.of(2, 1, 5, 8, 4))).isEqualTo(11);
    assertThat(MaxArraySum.maxSubsetSum(List.of(3, 7, 4, 6, 5))).isEqualTo(13);
  }

  @Test
  void negativeValuesInList() {
    assertThat(MaxArraySum.maxSubsetSum(List.of(3, 5, -7, 8, 10))).isEqualTo(15);
  }
}
