package wilmol.leetcode.problemset.algorithms.unknown;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-30. */
class FirstUniqueTest {

  @Test
  void example1() {
    FirstUnique firstUnique = new FirstUnique(new int[] {2, 3, 5});
    assertThat(firstUnique.showFirstUnique()).isEqualTo(2);
    firstUnique.add(5);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(2);
    firstUnique.add(2);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(3);
    firstUnique.add(3);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);
  }

  @Test
  void example2() {
    FirstUnique firstUnique = new FirstUnique(new int[] {7, 7, 7, 7, 7, 7});
    assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);
    firstUnique.add(7);
    firstUnique.add(3);
    firstUnique.add(3);
    firstUnique.add(7);
    firstUnique.add(17);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(17);
  }

  @Test
  void example3() {
    FirstUnique firstUnique = new FirstUnique(new int[] {809});
    assertThat(firstUnique.showFirstUnique()).isEqualTo(809);
    firstUnique.add(809);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);
  }

  @Test
  void numberAdded3Times() {
    FirstUnique firstUnique = new FirstUnique(new int[0]);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);
    firstUnique.add(1);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(1);
    firstUnique.add(1);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);
    firstUnique.add(1);
    assertThat(firstUnique.showFirstUnique()).isEqualTo(-1);
  }
}
