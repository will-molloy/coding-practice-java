package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherListTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherListTest {

  private final P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList p1452 =
      new P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList();

  @Test
  void example1() {
    assertThat(
            p1452.peopleIndexes(
                List.of(
                    List.of("leetcode", "google", "facebook"),
                    List.of("google", "microsoft"),
                    List.of("google", "facebook"),
                    List.of("google"),
                    List.of("amazon"))))
        .containsExactly(0, 1, 4)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p1452.peopleIndexes(
                List.of(
                    List.of("leetcode", "google", "facebook"),
                    List.of("leetcode", "amazon"),
                    List.of("facebook", "google"))))
        .containsExactly(0, 1)
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(
            p1452.peopleIndexes(
                List.of(
                    List.of("leetcode"),
                    List.of("google"),
                    List.of("facebook"),
                    List.of("amazon"))))
        .containsExactly(0, 1, 2, 3)
        .inOrder();
  }
}
