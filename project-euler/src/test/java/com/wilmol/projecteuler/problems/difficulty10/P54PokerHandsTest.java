package com.wilmol.projecteuler.problems.difficulty10;

import static com.google.common.truth.Truth.assertThat;

import com.google.common.collect.ImmutableList;
import com.wilmol.projecteuler.problems.difficulty10.P54PokerHands.Card;
import com.wilmol.projecteuler.problems.difficulty10.P54PokerHands.Hand;
import com.wilmol.projecteuler.problems.difficulty10.P54PokerHands.Rank;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.Test;

/**
 * P54PokerHandsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class P54PokerHandsTest {

  private Pair<Hand, Hand> lineToHand(String line) {
    List<Card> cards =
        Arrays.stream(line.split(" "))
            .map(s -> Card.of(s.substring(0, 1), s.substring(1, 2)))
            .collect(ImmutableList.toImmutableList());
    Set<Card> p1Cards = Set.copyOf(cards.subList(0, 5));
    Set<Card> p2Cards = Set.copyOf(cards.subList(5, 10));
    return Pair.of(Hand.of(p1Cards), Hand.of(p2Cards));
  }

  @Test
  void test1000HandsWithClearWinners() throws IOException {
    List<Pair<Hand, Hand>> hands =
        Files.lines(Path.of("src/test/resources/problem_054/p054_poker.txt"))
            .map(this::lineToHand)
            .collect(ImmutableList.toImmutableList());
    assertThat(hands.size()).isEqualTo(1000);
    assertThat(P54PokerHands.countOfHowManyHandsPlayerOneWins(hands)).isEqualTo(376);
  }

  @Test
  void exampleOneCompareSinglePairs() {
    Pair<Hand, Hand> hands = lineToHand("5H 5C 6S 7S KD " + "2C 3S 8S 8D TD");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // pair of eights > pair of fives
    assertThat(player1Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void exampleTwoCompareHighestCard() {
    Pair<Hand, Hand> hands = lineToHand("5D 8C 9S JS AC " + "2C 5C 7D 8S QH");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // ace > queen
    assertThat(player1Hand.getRank()).isEqualTo(Rank.HIGH_CARD);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.HIGH_CARD);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void exampleThreeCompareThreeOfAKindWithFlush() {
    Pair<Hand, Hand> hands = lineToHand("2D 9C AS AH AC " + "3D 6D 7D TD QD");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // flush > three of a kind
    assertThat(player1Hand.getRank()).isEqualTo(Rank.THREE_OF_A_KIND);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FLUSH);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void exampleFourCompareHighestCardForMatchingPairs() {
    Pair<Hand, Hand> hands = lineToHand("4D 6S 9H QH QC " + "3D 6D 7H QD QS");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both pair of queens, highest card 9 > highest card 7
    assertThat(player1Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void exampleFiveCompareFullHouses() {
    Pair<Hand, Hand> hands = lineToHand("2H 2D 4C 4D 4S " + "3C 3D 3S 9S 9D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // triple 4s > triple 3s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.FULL_HOUSE);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FULL_HOUSE);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothOnePair() {
    Pair<Hand, Hand> hands = lineToHand("2H 7D 8S 8H KH " + "KC 7C 2C 3S 7D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // 2 8s > 2 7s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothOnePairSameValues() {
    Pair<Hand, Hand> hands = lineToHand("2H 7D 8S 8H KH " + "KC 8C 2C 3S 8D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both 2 8s, both highest king, second highest 7 > second highest 3
    assertThat(player1Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.ONE_PAIR);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothTwoPairs() {
    Pair<Hand, Hand> hands = lineToHand("2H 2D 8S 8H KH " + "KC 7C 2C 2S 7D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // 2 8s > 2 7s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.TWO_PAIRS);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.TWO_PAIRS);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothTwoPairsFirstValueIsSame() {
    Pair<Hand, Hand> hands = lineToHand("3H 3D 7S 7H KH " + "AC 7C 2C 2S 7D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both 2 7s, 2 3s > 2 2s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.TWO_PAIRS);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.TWO_PAIRS);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothTwoPairsOfSameValues() {
    Pair<Hand, Hand> hands = lineToHand("2H 2D 7S 7H KH " + "AC 7C 2C 2S 7D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both 2 7s, both 2 2s, ace > king
    assertThat(player1Hand.getRank()).isEqualTo(Rank.TWO_PAIRS);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.TWO_PAIRS);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void bothThreeOfAKind() {
    Pair<Hand, Hand> hands = lineToHand("2H 7D 7S 7H KH " + "AC 8C 8S 2S 8D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // 3 8s > 3 7s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.THREE_OF_A_KIND);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.THREE_OF_A_KIND);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void bothThreeOfAKindSameValues() {
    Pair<Hand, Hand> hands = lineToHand("2H 8D 8S 8H KH " + "AC 8C 8S 2S 8D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both 3 8s, ace > king
    assertThat(player1Hand.getRank()).isEqualTo(Rank.THREE_OF_A_KIND);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.THREE_OF_A_KIND);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void bothStraight() {
    Pair<Hand, Hand> hands = lineToHand("2H, 3H, 4C, 5S, 6D " + "3C, 4S, 5C, 6H, 7D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both straight, 7 > 6
    assertThat(player1Hand.getRank()).isEqualTo(Rank.STRAIGHT);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.STRAIGHT);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void bothFlush() {
    Pair<Hand, Hand> hands = lineToHand("3H, 4H, 5H, 6H, AH " + "2C, 4C, 5C, 6C, AC");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both straight, both highest ace, both second highest 6, both third highest 5, both fourth
    // highest 4,
    // 5th highest: 3 > 2
    assertThat(player1Hand.getRank()).isEqualTo(Rank.FLUSH);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FLUSH);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothFullHouse() {
    Pair<Hand, Hand> hands = lineToHand("3H 3D 3C AC AS " + "4H 4S 4C QD QH");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // 3 4s > 3 3s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.FULL_HOUSE);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FULL_HOUSE);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void bothFullHouseSameTriple() {
    Pair<Hand, Hand> hands = lineToHand("4H 4D 4C AC AS " + "4H 4S 4C QD QH");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both 3 4s, 2 aces > 2 queens
    assertThat(player1Hand.getRank()).isEqualTo(Rank.FULL_HOUSE);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FULL_HOUSE);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothFourOfAKind() {
    Pair<Hand, Hand> hands = lineToHand("4H 4D 4C 4S AS " + "5H 5D 5C 5S QH");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // 4 5s > 4 4s
    assertThat(player1Hand.getRank()).isEqualTo(Rank.FOUR_OF_A_KIND);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FOUR_OF_A_KIND);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void bothFourOfAKindSameValues() {
    Pair<Hand, Hand> hands = lineToHand("5H 5D 5C 5S AS " + "5H 5D 5C 5S QH");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both 4 5s, ace > queen
    assertThat(player1Hand.getRank()).isEqualTo(Rank.FOUR_OF_A_KIND);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.FOUR_OF_A_KIND);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isTrue();
  }

  @Test
  void bothStraightFlush() {
    Pair<Hand, Hand> hands = lineToHand("2H, 3H, 4H, 5H, 6H " + "3D, 4D, 5D, 6D, 7D");
    Hand player1Hand = hands.getLeft();
    Hand player2Hand = hands.getRight();

    // both straight flush, 7 > 6
    assertThat(player1Hand.getRank()).isEqualTo(Rank.STRAIGHT_FLUSH);
    assertThat(player2Hand.getRank()).isEqualTo(Rank.STRAIGHT_FLUSH);
    assertThat(P54PokerHands.playerOneWins(player1Hand, player2Hand)).isFalse();
  }

  @Test
  void testNotAStraightBasedOnSummingOrdinals() {
    // previously detected straight incorrectly (summed reduced ordinal values for sum 0..5)
    Rank rank =
        Hand.of(
                Set.of(
                    Card.of("9", "S"),
                    Card.of("T", "D"),
                    Card.of("T", "S"),
                    Card.of("Q", "C"),
                    Card.of("A", "D")))
            .getRank();
    assertThat(rank).isNotEqualTo(Rank.STRAIGHT);
    assertThat(rank).isNotEqualTo(Rank.STRAIGHT_FLUSH);
    assertThat(rank).isEqualTo(Rank.ONE_PAIR);
  }
}
