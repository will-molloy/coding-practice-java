package wilmol.hackerrank.interviewpreparationkit.sorting.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;
import wilmol.hackerrank.interviewpreparationkit.sorting.medium.ComparatorInterface.Player;

/** Created by Will on 25/03/2019. */
class ComparatorInterfaceTest {

  @Test
  void testTwoFieldComparableClass() {
    Player[] input =
        new Player[] {
          new Player("amy", 100),
          new Player("david", 100),
          new Player("heraldo", 50),
          new Player("aakansha", 75),
          new Player("aleksa", 150)
        };
    Player[] sorted =
        new Player[] {
          new Player("aleksa", 150),
          new Player("amy", 100),
          new Player("david", 100),
          new Player("aakansha", 75),
          new Player("heraldo", 50)
        };

    assertThat(ComparatorInterface.sortPlayers(input)).isEqualTo(sorted);
  }
}
