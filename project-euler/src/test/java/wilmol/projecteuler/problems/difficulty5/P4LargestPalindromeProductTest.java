package wilmol.projecteuler.problems.difficulty5;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by Will on 16/03/2019. */
class P4LargestPalindromeProductTest {

  @Test
  void largestPalindromeProduct() {
    assertThat(new P4LargestPalindromeProduct().apply(2)).isEqualTo(9_009L);
    assertThat(new P4LargestPalindromeProduct().apply(3)).isEqualTo(906_609L);
  }
}
