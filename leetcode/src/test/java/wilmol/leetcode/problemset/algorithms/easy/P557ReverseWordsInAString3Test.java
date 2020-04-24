package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-25. */
class P557ReverseWordsInAString3Test {

  private final P557ReverseWordsInAString3 p557 = new P557ReverseWordsInAString3();

  @Test
  void example() {
    assertThat(p557.reverseWords("Let's take LeetCode contest"))
        .isEqualTo("s'teL ekat edoCteeL tsetnoc");
  }
}
