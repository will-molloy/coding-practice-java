package com.wilmol.hackerrank.interviewpreparationkit.search.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2019-09-09. */
class HashTablesIceCreamParlorTest {

  @Test
  void example1() {
    assertThat(HashTablesIceCreamParlor.whatFlavors(new int[] {1, 4, 5, 3, 2}, 4))
        .asList()
        .containsExactly(1, 4)
        .inOrder();
  }

  @Test
  void example2() {
    assertThat(HashTablesIceCreamParlor.whatFlavors(new int[] {2, 2, 4, 3}, 4))
        .asList()
        .containsExactly(1, 2)
        .inOrder();
  }

  @Test
  void example3() {
    assertThat(HashTablesIceCreamParlor.whatFlavors(new int[] {1, 2, 3, 5, 6}, 5))
        .asList()
        .containsExactly(2, 3)
        .inOrder();
  }

  @Test
  void example4() {
    assertThat(HashTablesIceCreamParlor.whatFlavors(new int[] {1, 2, 3, 5, 6}, 5))
        .asList()
        .containsExactly(2, 3)
        .inOrder();
  }
}
