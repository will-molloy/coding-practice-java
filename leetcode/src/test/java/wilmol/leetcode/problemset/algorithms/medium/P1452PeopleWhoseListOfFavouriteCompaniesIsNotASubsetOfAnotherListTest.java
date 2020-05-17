package wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-17. */
class P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherListTest {

  private final P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList p1452 =
      new P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList();

  @Test
  void example1() {
    assertThat(
            p1452.peopleIndexes(
                ImmutableList.of(
                    ImmutableList.of("leetcode", "google", "facebook"),
                    ImmutableList.of("google", "microsoft"),
                    ImmutableList.of("google", "facebook"),
                    ImmutableList.of("google"),
                    ImmutableList.of("amazon"))))
        .containsExactly(0, 1, 4)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(
            p1452.peopleIndexes(
                ImmutableList.of(
                    ImmutableList.of("leetcode", "google", "facebook"),
                    ImmutableList.of("leetcode", "amazon"),
                    ImmutableList.of("facebook", "google"))))
        .containsExactly(0, 1)
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(
            p1452.peopleIndexes(
                ImmutableList.of(
                    ImmutableList.of("leetcode"),
                    ImmutableList.of("google"),
                    ImmutableList.of("facebook"),
                    ImmutableList.of("amazon"))))
        .containsExactly(0, 1, 2, 3)
        .inOrder();
  }
}
