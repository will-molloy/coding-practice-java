package wilmol.hackerrank.interviewpreparationkit.sorting.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 25/03/2019. */
class BubbleSortCountSwapsTest {

  @Test
  void noSwapsAlreadySorted() {
    assertThat(BubbleSortCountSwaps.countSwaps(new int[] {1, 2, 3})).isEqualTo(0);
  }

  @Test
  void threeSwapsReverseOrder() {
    assertThat(BubbleSortCountSwaps.countSwaps(new int[] {3, 2, 1})).isEqualTo(3);
  }

  @Test
  void sevenSwapsMustBubbleUpElements() {
    assertThat(BubbleSortCountSwaps.countSwaps(new int[] {4, 3, 5, 1, 2})).isEqualTo(7);
  }
}
