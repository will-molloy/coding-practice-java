package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-24. */
class P821ShortestDistanceToACharacterTest {

  private final P821ShortestDistanceToACharacter p821 = new P821ShortestDistanceToACharacter();

  @Test
  void example() {
    assertThat(p821.shortestToChar("loveleetcode", 'e'))
        .asList()
        .containsExactly(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0)
        .inOrder();
  }
}
