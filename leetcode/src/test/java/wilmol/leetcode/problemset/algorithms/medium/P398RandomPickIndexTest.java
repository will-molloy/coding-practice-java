package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import wilmol.leetcode.problemset.algorithms.medium.P398RandomPickIndex.Solution;

/** Created by wilmol on 2020-06-08. */
class P398RandomPickIndexTest {

  private static final int NUM_TRIALS = 1_000_000;

  private static final double TOLERANCE = 0.02;

  @Test
  void example() {
    int[] nums = new int[] {1, 2, 3, 3, 3};
    Solution solution = new Solution(nums);

    Map<Integer, Double> actualProbabilitiesPick3 = getActualProbabilities(solution, 3);
    assertThat(actualProbabilitiesPick3.keySet()).containsExactly(2, 3, 4);
    assertThat(actualProbabilitiesPick3.values().stream().mapToDouble(i -> i).sum()).isEqualTo(1);
    assertThat(actualProbabilitiesPick3.get(2)).isWithin(TOLERANCE).of((double) 1 / 3);
    assertThat(actualProbabilitiesPick3.get(3)).isWithin(TOLERANCE).of((double) 1 / 3);
    assertThat(actualProbabilitiesPick3.get(4)).isWithin(TOLERANCE).of((double) 1 / 3);

    Map<Integer, Double> actualProbabilitiesPick1 = getActualProbabilities(solution, 1);
    assertThat(actualProbabilitiesPick1.keySet()).containsExactly(0);
    assertThat(actualProbabilitiesPick1.values().stream().mapToDouble(i -> i).sum()).isEqualTo(1);
    assertThat(actualProbabilitiesPick1.get(0)).isEqualTo(1);
  }

  // helper method to run random trials
  private Map<Integer, Double> getActualProbabilities(Solution solution, int target) {
    Map<Integer, Integer> indexCounts = new HashMap<>();
    for (int i = 0; i < NUM_TRIALS; i++) {
      int randomlyPickedIndex = solution.pick(target);
      indexCounts.put(randomlyPickedIndex, indexCounts.getOrDefault(randomlyPickedIndex, 0) + 1);
    }

    Map<Integer, Double> actualIndexProbabilities = new HashMap<>();
    for (Map.Entry<Integer, Integer> e : indexCounts.entrySet()) {
      actualIndexProbabilities.put(e.getKey(), (double) e.getValue() / NUM_TRIALS);
    }
    return actualIndexProbabilities;
  }
}
