package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-05. */
class P528RandomPickWithWeightTest {

  private static final int TRIALS = 10_000;

  private static final double TOLERANCE = 0.01;

  @Test
  void example1() {
    Map<Integer, Double> actualProbabilities = getActualProbabilities(new int[] {1});
    assertThat(actualProbabilities.get(0)).isEqualTo(1d);
  }

  @Test
  void example2() {
    Map<Integer, Double> actualProbabilities = getActualProbabilities(new int[] {1, 3});
    assertThat(actualProbabilities.get(0)).isWithin(TOLERANCE).of(0.25);
    assertThat(actualProbabilities.get(1)).isWithin(TOLERANCE).of(0.75);
  }

  @Test
  void codeCommentExample() {
    Map<Integer, Double> actualProbabilities = getActualProbabilities(new int[] {2, 5, 3});
    assertThat(actualProbabilities.get(0)).isWithin(TOLERANCE).of(0.2);
    assertThat(actualProbabilities.get(1)).isWithin(TOLERANCE).of(0.5);
    assertThat(actualProbabilities.get(2)).isWithin(TOLERANCE).of(0.3);
  }

  // helper method to run trials
  private Map<Integer, Double> getActualProbabilities(int[] weights) {
    P528RandomPickWithWeight.Solution p528 = new P528RandomPickWithWeight.Solution(weights);
    Map<Integer, Integer> indexCounts = new HashMap<>();
    for (int i = 0; i < TRIALS; i++) {
      int index = p528.pickIndex();
      indexCounts.put(index, indexCounts.getOrDefault(index, 0) + 1);
    }
    Map<Integer, Double> actualIndexProbabilities = new HashMap<>();
    for (int i = 0; i < weights.length; i++) {
      actualIndexProbabilities.put(i, (double) indexCounts.get(i) / TRIALS);
    }
    return actualIndexProbabilities;
  }
}
