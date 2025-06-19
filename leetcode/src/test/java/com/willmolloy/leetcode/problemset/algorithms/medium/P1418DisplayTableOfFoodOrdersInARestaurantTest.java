package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * P1418DisplayTableOfFoodOrdersInARestaurantTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P1418DisplayTableOfFoodOrdersInARestaurantTest {

  private final P1418DisplayTableOfFoodOrdersInARestaurant b =
      new P1418DisplayTableOfFoodOrdersInARestaurant();

  @Test
  void example1() {
    assertThat(
            b.displayTable(
                List.of(
                    List.of("David", "3", "Ceviche"),
                    List.of("Corina", "10", "Beef Burrito"),
                    List.of("David", "3", "Fried Chicken"),
                    List.of("Carla", "5", "Water"),
                    List.of("Carla", "5", "Ceviche"),
                    List.of("Rous", "3", "Ceviche"))))
        .containsExactly(
            List.of("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
            List.of("3", "0", "2", "1", "0"),
            List.of("5", "0", "1", "0", "1"),
            List.of("10", "1", "0", "0", "0"));
  }

  @Test
  void example2() {
    assertThat(
            b.displayTable(
                List.of(
                    List.of("James", "12", "Fried Chicken"),
                    List.of("Ratesh", "12", "Fried Chicken"),
                    List.of("Amadeus", "12", "Fried Chicken"),
                    List.of("Adam", "1", "Canadian Waffles"),
                    List.of("Brianna", "1", "Canadian Waffles"))))
        .containsExactly(
            List.of("Table", "Canadian Waffles", "Fried Chicken"),
            List.of("1", "2", "0"),
            List.of("12", "0", "3"));
  }

  @Test
  void example3() {
    assertThat(
            b.displayTable(
                List.of(
                    List.of("Laura", "2", "Bean Burrito"),
                    List.of("Jhon", "2", "Beef Burrito"),
                    List.of("Melissa", "2", "Soda"))))
        .containsExactly(
            List.of("Table", "Bean Burrito", "Beef Burrito", "Soda"), List.of("2", "1", "1", "1"));
  }

  @Test
  void noOrders() {
    assertThat(b.displayTable(List.of())).containsExactly(List.of("Table"));
  }
}
