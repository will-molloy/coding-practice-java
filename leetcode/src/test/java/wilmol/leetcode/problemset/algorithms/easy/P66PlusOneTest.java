package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-01-13. */
class P66PlusOneTest {

  private final P66PlusOne fun = new P66PlusOne();

  @Test
  void example1() {
    int[] digits = {1, 2, 3};
    assertThat(fun.plusOne(digits)).asList().containsExactly(1, 2, 4).inOrder();
  }

  @Test
  void example2() {
    int[] digits = {4, 3, 2, 1};
    assertThat(fun.plusOne(digits)).asList().containsExactly(4, 3, 2, 2).inOrder();
  }

  @Test
  void overflow() {
    int[] digits = {1, 0, 9};
    assertThat(fun.plusOne(digits)).asList().containsExactly(1, 1, 0).inOrder();
  }

  @Test
  void doubleOverflow() {
    int[] digits = {1, 9, 9};
    assertThat(fun.plusOne(digits)).asList().containsExactly(2, 0, 0).inOrder();
  }

  @Test
  void overflowCausesIncreaseInLength() {
    int[] digits = {9, 9, 9};
    assertThat(fun.plusOne(digits)).asList().containsExactly(1, 0, 0, 0).inOrder();
  }

  @Test
  void greaterThan9IsIllegal() {
    int[] digits = {9, 9, 10};
    IllegalArgumentException thrown =
        assertThrows(IllegalArgumentException.class, () -> fun.plusOne(digits));
    assertThat(thrown).hasMessageThat().isEqualTo("Element > 9 at index 2 in array [9, 9, 10]");
  }
}
