package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P1268SearchSuggestionsSystemTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1268SearchSuggestionsSystemTest {

  private final P1268SearchSuggestionsSystem p1268SearchSuggestionsSystem =
      new P1268SearchSuggestionsSystem();

  @Test
  void example1() {
    String[] products = {"mobile", "mouse", "moneypot", "monitor", "mousepad"};
    String searchWord = "mouse";

    assertThat(p1268SearchSuggestionsSystem.suggestedProducts(products, searchWord))
        .containsExactly(
            List.of("mobile", "moneypot", "monitor"),
            List.of("mobile", "moneypot", "monitor"),
            List.of("mouse", "mousepad"),
            List.of("mouse", "mousepad"),
            List.of("mouse", "mousepad"))
        .inOrder();
  }

  @Test
  void example2() {
    String[] products = {"havana"};
    String searchWord = "havana";

    assertThat(p1268SearchSuggestionsSystem.suggestedProducts(products, searchWord))
        .isEqualTo(Collections.nCopies(6, List.of("havana")));
  }

  @Test
  void example3() {
    String[] products = {"bags", "baggage", "banner", "box", "cloths"};
    String searchWord = "bags";

    assertThat(p1268SearchSuggestionsSystem.suggestedProducts(products, searchWord))
        .containsExactly(
            List.of("baggage", "bags", "banner"),
            List.of("baggage", "bags", "banner"),
            List.of("baggage", "bags"),
            List.of("bags"))
        .inOrder();
  }

  @Test
  void example4() {
    String[] products = {"havana"};
    String searchWord = "tatiana";

    assertThat(p1268SearchSuggestionsSystem.suggestedProducts(products, searchWord))
        .isEqualTo(Collections.nCopies(7, List.of()));
  }
}
