package com.willmolloy.leetcode.problemset.algorithms.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <a
 * href=https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list>https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/</a>
 *
 * <p>Runtime: O(n * n * m * s) (n = outer list size, m = inner list size, s = string size)
 *
 * <p>Extra space: O(n * m * s)
 *
 * <p>Key idea: Convert lists to sets to make contains check faster.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1452PeopleWhoseListOfFavouriteCompaniesIsNotASubsetOfAnotherList {

  // TODO probably more efficient way, this was contest code

  public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
    List<Set<String>> asSets =
        favoriteCompanies.stream().map(list -> new HashSet<>(list)).collect(Collectors.toList());

    List<Integer> result = new ArrayList<>();

    // O(n)
    for (int i = 0; i < favoriteCompanies.size(); i++) {
      if (notSubset(i, asSets)) {
        result.add(i);
      }
    }
    return result;
  }

  private boolean notSubset(int i, List<Set<String>> favoriteCompanies) {
    Set<String> list = favoriteCompanies.get(i);
    // O(n)
    for (int j = 0; j < favoriteCompanies.size(); j++) {
      if (i == j) {
        continue;
      }
      Set<String> test = favoriteCompanies.get(j);
      // O(m * s) (O(m * m * s) if list instead of set)
      if (test.containsAll(list)) {
        return false;
      }
    }
    return true;
  }
}
