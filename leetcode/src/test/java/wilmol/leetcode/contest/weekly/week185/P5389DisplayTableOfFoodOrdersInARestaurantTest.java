package wilmol.leetcode.contest.weekly.week185;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-04-19. */
class P5389DisplayTableOfFoodOrdersInARestaurantTest {

  private final P5389DisplayTableOfFoodOrdersInARestaurant b =
      new P5389DisplayTableOfFoodOrdersInARestaurant();

  @Test
  void example1() {
    assertThat(
            b.displayTable(
                ImmutableList.of(
                    ImmutableList.of("David", "3", "Ceviche"),
                    ImmutableList.of("Corina", "10", "Beef Burrito"),
                    ImmutableList.of("David", "3", "Fried Chicken"),
                    ImmutableList.of("Carla", "5", "Water"),
                    ImmutableList.of("Carla", "5", "Ceviche"),
                    ImmutableList.of("Rous", "3", "Ceviche"))))
        .containsExactly(
            ImmutableList.of("Table", "Beef Burrito", "Ceviche", "Fried Chicken", "Water"),
            ImmutableList.of("3", "0", "2", "1", "0"),
            ImmutableList.of("5", "0", "1", "0", "1"),
            ImmutableList.of("10", "1", "0", "0", "0"));
  }

  @Test
  void example2() {
    assertThat(
            b.displayTable(
                ImmutableList.of(
                    ImmutableList.of("James", "12", "Fried Chicken"),
                    ImmutableList.of("Ratesh", "12", "Fried Chicken"),
                    ImmutableList.of("Amadeus", "12", "Fried Chicken"),
                    ImmutableList.of("Adam", "1", "Canadian Waffles"),
                    ImmutableList.of("Brianna", "1", "Canadian Waffles"))))
        .containsExactly(
            ImmutableList.of("Table", "Canadian Waffles", "Fried Chicken"),
            ImmutableList.of("1", "2", "0"),
            ImmutableList.of("12", "0", "3"));
  }

  @Test
  void example3() {
    assertThat(
            b.displayTable(
                ImmutableList.of(
                    ImmutableList.of("Laura", "2", "Bean Burrito"),
                    ImmutableList.of("Jhon", "2", "Beef Burrito"),
                    ImmutableList.of("Melissa", "2", "Soda"))))
        .containsExactly(
            ImmutableList.of("Table", "Bean Burrito", "Beef Burrito", "Soda"),
            ImmutableList.of("2", "1", "1", "1"));
  }

  @Test
  void noOrders() {
    assertThat(b.displayTable(ImmutableList.of())).containsExactly(ImmutableList.of("Table"));
  }
}
