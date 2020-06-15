package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import wilmol.leetcode.common.ListNode;

/** Created by Will on 2019-07-23 at 20:29. */
class P21MergeTwoSortedListsTest {

  @ParameterizedTest
  @MethodSource("functions")
  void example(P21MergeTwoSortedLists function) {
    assertThat(function.mergeTwoLists(ListNode.of(1, 2, 4), ListNode.of(1, 3, 4)))
        .isEqualTo(ListNode.of(1, 1, 2, 3, 4, 4));
  }

  @ParameterizedTest
  @MethodSource("functions")
  void singleList(P21MergeTwoSortedLists function) {
    assertThat(function.mergeTwoLists(ListNode.of(1, 2, 4), null)).isEqualTo(ListNode.of(1, 2, 4));
    assertThat(function.mergeTwoLists(null, ListNode.of(1, 3, 4))).isEqualTo(ListNode.of(1, 3, 4));
  }

  @ParameterizedTest
  @MethodSource("functions")
  void listsDontOverlap(P21MergeTwoSortedLists function) {
    assertThat(function.mergeTwoLists(ListNode.of(1, 2, 3), ListNode.of(7, 8, 9)))
        .isEqualTo(ListNode.of(1, 2, 3, 7, 8, 9));
  }

  @ParameterizedTest
  @MethodSource("functions")
  void bothEmpty(P21MergeTwoSortedLists function) {
    assertThat(function.mergeTwoLists(null, null)).isNull();
  }

  static Stream<P21MergeTwoSortedLists> functions() {
    return Stream.of(
        new P21MergeTwoSortedLists.Iterative(), new P21MergeTwoSortedLists.Recursive());
  }
}
