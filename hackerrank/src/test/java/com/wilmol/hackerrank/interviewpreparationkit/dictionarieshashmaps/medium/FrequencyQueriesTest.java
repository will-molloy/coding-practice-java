package com.wilmol.hackerrank.interviewpreparationkit.dictionarieshashmaps.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-09-21. */
class FrequencyQueriesTest {

  @Test
  void sampleInput0() {
    List<int[]> input =
        Arrays.asList(
            new int[] {1, 5},
            new int[] {1, 6},
            new int[] {3, 2},
            new int[] {1, 10},
            new int[] {1, 10},
            new int[] {1, 6},
            new int[] {2, 5},
            new int[] {3, 2});
    assertThat(FrequencyQueries.freqQuery(input)).containsExactly(0, 1).inOrder();
  }

  @Test
  void sampleInput1() {
    List<int[]> input =
        Arrays.asList(new int[] {3, 4}, new int[] {2, 1003}, new int[] {1, 16}, new int[] {3, 1});
    assertThat(FrequencyQueries.freqQuery(input)).containsExactly(0, 1).inOrder();
  }

  @Test
  void sampleInput2() {
    List<int[]> input =
        Arrays.asList(
            new int[] {1, 3},
            new int[] {2, 3},
            new int[] {3, 2},
            new int[] {1, 4},
            new int[] {1, 5},
            new int[] {1, 5},
            new int[] {1, 4},
            new int[] {3, 2},
            new int[] {2, 4},
            new int[] {3, 2});
    assertThat(FrequencyQueries.freqQuery(input)).containsExactly(0, 1, 1).inOrder();
  }

  @Test
  void freqDropsBelowZero() {
    List<int[]> input =
        Arrays.asList(new int[] {2, 1}, new int[] {2, 1}, new int[] {1, 1}, new int[] {3, 1});
    assertThat(FrequencyQueries.freqQuery(input)).containsExactly(1).inOrder();
  }

  @Test
  void freqDropsButAnotherNumberRetainsIt() {
    List<int[]> input =
        Arrays.asList(
            new int[] {1, 1},
            new int[] {1, 1},
            new int[] {1, 2},
            new int[] {1, 2},
            new int[] {2, 1},
            new int[] {3, 2},
            new int[] {3, 1});
    assertThat(FrequencyQueries.freqQuery(input)).containsExactly(1, 1).inOrder();
  }
}
