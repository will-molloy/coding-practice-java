package com.willmolloy.projecteuler.problems.difficulty10;

import static java.lang.String.format;
import static java.util.function.Predicate.not;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import com.willmolloy.projecteuler.common.Tuples;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <a href=https://projecteuler.net/problem=54>https://projecteuler.net/problem=54</a>
 *
 * <p>Runtime: O(n)
 *
 * <p>Note: decided on OOP/functional 'declarative' and 'readable' solution. Not the most efficient
 * (i.e. don't need to compute ranks eagerly, can just compare hands lazily).
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P54PokerHands {

  private P54PokerHands() {}

  private static final Logger LOG = LogManager.getLogger();

  /**
   * Count of how many hands player one wins.
   *
   * <p>Assumed player one hands are first in each pair and there is a clear winner for each hand.
   */
  static int countOfHowManyHandsPlayerOneWins(List<Pair<Hand, Hand>> hands) {
    final int[] hand = {1};
    int playerOneWins =
        (int)
            hands.stream()
                .filter(
                    Tuples.predicate(
                        (player1Hand, player2Hand) -> {
                          boolean playerOneWon = playerOneWins(player1Hand, player2Hand);
                          LOG.debug(
                              "Hand {}: Player {} won [{}] vs. [{}]",
                              hand[0]++,
                              playerOneWon ? 1 : 2,
                              player1Hand,
                              player2Hand);
                          return playerOneWon;
                        }))
                .count();
    LOG.info("Player one won {}/{} hands.", playerOneWins, hands.size());
    return playerOneWins;
  }

  static boolean playerOneWins(Hand player1Hand, Hand player2Hand) {
    return player1Hand.compareTo(player2Hand) > 0;
  }

  /** Hand. */
  static final class Hand implements Comparable<Hand> {

    private final Set<Card> cards;

    private final Rank rank;

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Hand hand = (Hand) o;
      return Objects.equals(cards, hand.cards) && rank == hand.rank;
    }

    @Override
    public int hashCode() {
      return Objects.hash(cards, rank);
    }

    public Rank getRank() {
      return rank;
    }

    private Hand(Set<Card> cards, Rank rank) {
      this.cards = cards;
      this.rank = rank;
    }

    public static Hand of(Set<Card> cards) {
      Preconditions.checkArgument(cards.size() == 5, "Hand must consist of 5 cards.");
      // determine rank in decreasing priority order (i.e. check for royal flush first)
      // otherwise get problems, e.g. detect three of a kind when four of a kind exists
      Rank rank =
          Arrays.stream(Rank.values())
              .sorted(Comparator.reverseOrder())
              .filter(r -> r.isRank(cards))
              .findFirst()
              .orElseThrow();
      return new Hand(cards, rank);
    }

    @Override
    public int compareTo(Hand that) {
      // Compare rank,
      // if same, compare value of rank,
      // if same, compare highest card,
      // if same, compare next highest card,
      // etc.
      if (this.rank != that.rank) {
        return this.rank.compareTo(that.rank);
      }
      // Assumed clear winner, hence never return 0
      return this.rank.resolveDraw(this.cards, that.cards) ? 1 : -1;
    }
  }

  /** Card. */
  static final class Card {

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      Card card = (Card) o;
      return value == card.value && suit == card.suit;
    }

    @Override
    public int hashCode() {
      return Objects.hash(value, suit);
    }

    final Value value;

    final Suit suit;

    private Card(Value value, Suit suit) {
      this.suit = suit;
      this.value = value;
    }

    public static Card of(String valueStringValue, String suitStringValue) {
      return new Card(Value.fromString(valueStringValue), Suit.fromString(suitStringValue));
    }

    @Override
    public String toString() {
      return value.stringValue + suit.stringValue;
    }
  }

  /** Suit. */
  enum Suit {
    CLUBS("C"),
    DIAMONDS("D"),
    HEARTS("H"),
    SPADES("S");

    private final String stringValue;

    Suit(String stringValue) {
      this.stringValue = stringValue;
    }

    private static Suit fromString(String stringValue) {
      return Arrays.stream(Suit.values())
          .filter(suit -> suit.stringValue.equals(stringValue))
          .findFirst()
          .orElseThrow(() -> new EnumConstantNotPresentException(Suit.class, stringValue));
    }
  }

  /** Value. */
  enum Value {
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5"),
    SIX("6"),
    SEVEN("7"),
    EIGHT("8"),
    NINE("9"),
    TEN("T"),
    JACK("J"),
    QUEEN("Q"),
    KING("K"),
    ACE("A");

    private final String stringValue;

    Value(String stringValue) {
      this.stringValue = stringValue;
    }

    private static Value fromString(String stringValue) {
      return Arrays.stream(Value.values())
          .filter(value -> value.stringValue.equals(stringValue))
          .findFirst()
          .orElseThrow(() -> new EnumConstantNotPresentException(Value.class, stringValue));
    }
  }

  /** Represents a {@link Hand} rank. */
  enum Rank {
    HIGH_CARD {
      @Override
      boolean isRank(Set<Card> cards) {
        // default rank
        return true;
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        return compareHighestCard(hand1, hand2);
      }
    },

    ONE_PAIR {
      @Override
      boolean isRank(Set<Card> cards) {
        return getFirstPairValue(cards).isPresent();
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on one pair");
        Value hand1PairValue = getFirstPairValue(hand1).orElseThrow();
        Value hand2PairValue = getFirstPairValue(hand2).orElseThrow();
        return compareValuesOrElse(
            hand1PairValue,
            hand2PairValue,
            () -> {
              LOG.debug("Tied on one pair again, using backup");
              return HIGH_CARD.resolveDraw(
                  cardsWithoutValue(hand1, hand1PairValue),
                  cardsWithoutValue(hand2, hand2PairValue));
            });
      }
    },

    TWO_PAIRS {
      @Override
      boolean isRank(Set<Card> cards) {
        Optional<Value> pairValue = getFirstPairValue(cards);
        if (pairValue.isEmpty()) {
          return false;
        }
        Set<Card> otherCards = cardsWithoutValue(cards, pairValue.get());
        return getFirstPairValue(otherCards).isPresent();
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on two pairs");
        // getFirstPairValue returns the first pair of the sorted list, i.e. the lowest pair value
        // therefore calling the method twice will get the second pair on the second call
        Value hand1FirstPairValue = getFirstPairValue(hand1).orElseThrow();
        Value hand1SecondPairValue =
            getFirstPairValue(cardsWithoutValue(hand1, hand1FirstPairValue)).orElseThrow();

        Value hand2FirstPairValue = getFirstPairValue(hand2).orElseThrow();
        Value hand2SecondPairValue =
            getFirstPairValue(cardsWithoutValue(hand2, hand2FirstPairValue)).orElseThrow();

        return compareValuesOrElse(
            hand1SecondPairValue,
            hand2SecondPairValue,
            () -> {
              LOG.debug("Tied on two pairs again, using backup");
              return ONE_PAIR.resolveDraw(
                  cardsWithoutValue(hand1, hand1SecondPairValue),
                  cardsWithoutValue(hand2, hand2SecondPairValue));
            });
      }
    },

    THREE_OF_A_KIND {
      @Override
      boolean isRank(Set<Card> cards) {
        return getTripletValue(cards).isPresent();
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on three of a kind");
        Value hand1TripletValue = getTripletValue(hand1).orElseThrow();
        Value hand2TripletValue = getTripletValue(hand2).orElseThrow();
        return compareValuesOrElse(
            hand1TripletValue,
            hand2TripletValue,
            () -> {
              LOG.debug("Tied on three of a kind again, using backup");
              return HIGH_CARD.resolveDraw(hand1, hand2);
            });
      }
    },

    STRAIGHT {
      @Override
      boolean isRank(Set<Card> cards) {
        return consecutiveValues(cards);
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on straight");
        return HIGH_CARD.resolveDraw(hand1, hand2);
      }
    },

    FLUSH {
      @Override
      boolean isRank(Set<Card> cards) {
        return Rank.sameSuit(cards);
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on flush");
        return HIGH_CARD.resolveDraw(hand1, hand2);
      }
    },

    FULL_HOUSE {
      @Override
      boolean isRank(Set<Card> cards) {
        // full house: pair AND triplet
        // check for triplet first, otherwise may remove triplet when removing pair
        Optional<Value> tripletValue = getTripletValue(cards);
        if (tripletValue.isEmpty()) {
          return false;
        }
        Set<Card> otherCards = cardsWithoutValue(cards, tripletValue.get());
        return otherCards.size() == 2 && ONE_PAIR.isRank(otherCards);
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on full house");
        Value hand1TripletValue = getTripletValue(hand1).orElseThrow();
        Value hand2TripletValue = getTripletValue(hand2).orElseThrow();
        return compareValuesOrElse(
            hand1TripletValue,
            hand2TripletValue,
            () -> {
              LOG.debug("Tied on full house again, using backup");
              Set<Card> hand1WithoutTriplet = cardsWithoutValue(hand1, hand1TripletValue);
              Set<Card> hand2WithoutTriplet = cardsWithoutValue(hand2, hand2TripletValue);
              return ONE_PAIR.resolveDraw(hand1WithoutTriplet, hand2WithoutTriplet);
            });
      }
    },

    FOUR_OF_A_KIND {
      @Override
      boolean isRank(Set<Card> cards) {
        return getQuadrupleValue(cards).isPresent();
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on four of a kind");
        Value hand1QuadrupleValue = getQuadrupleValue(hand1).orElseThrow();
        Value hand2QuadrupleValue = getQuadrupleValue(hand2).orElseThrow();
        return compareValuesOrElse(
            hand1QuadrupleValue,
            hand2QuadrupleValue,
            () -> {
              LOG.debug("Tied on four of a kind again, using backup");
              return HIGH_CARD.resolveDraw(hand1, hand2);
            });
      }
    },

    // royal flush is a (ace high) straight flush
    STRAIGHT_FLUSH {
      @Override
      boolean isRank(Set<Card> cards) {
        return STRAIGHT.isRank(cards) && FLUSH.isRank(cards);
      }

      @Override
      boolean resolveDraw(Set<Card> hand1, Set<Card> hand2) {
        LOG.debug("Tied on straight flush");
        return HIGH_CARD.resolveDraw(hand1, hand2);
      }
    };

    // compare highest card, then second highest, etc.
    private static boolean compareHighestCard(Set<Card> hand1, Set<Card> hand2) {
      Preconditions.checkArgument(hand1.size() == hand2.size(), "Hands must be of same size.");

      if (hand1.isEmpty()) {
        throw new IllegalStateException("Hands tied on HIGH_CARD rank");
      }

      List<Card> hand1Sorted = sortByValue(hand1);
      List<Card> hand2Sorted = sortByValue(hand2);
      Value hand1Best = hand1Sorted.get(hand1.size() - 1).value;
      Value hand2Best = hand2Sorted.get(hand2.size() - 1).value;
      return compareValuesOrElse(
          hand1Best,
          hand2Best,
          () ->
              compareHighestCard(
                  Set.copyOf(hand1Sorted.subList(0, hand1.size() - 1)),
                  Set.copyOf(hand2Sorted.subList(0, hand1.size() - 1))));
    }

    private static boolean compareValuesOrElse(
        Value value1, Value value2, Supplier<Boolean> backup) {
      if (value1.ordinal() > value2.ordinal()) {
        return true;
      }
      if (value1.ordinal() < value2.ordinal()) {
        return false;
      }
      return backup.get();
    }

    static List<Card> sortByValue(Set<Card> cards) {
      return cards.stream().sorted(Comparator.comparing(a -> a.value)).toList();
    }

    private static Set<Card> cardsWithoutValue(Set<Card> cards, Value filterValue) {
      return cards.stream()
          .filter(not(card -> card.value == filterValue))
          .collect(ImmutableSet.toImmutableSet());
    }

    private static Optional<Value> getCommonValue(Set<Card> cards, int rangeSize) {
      Preconditions.checkArgument(
          cards.size() >= rangeSize,
          format("Not enough cards to extract common range of size %d.", rangeSize));
      List<Card> sortedCards = sortByValue(cards);
      return IntStream.rangeClosed(0, cards.size() - rangeSize)
          .filter(
              i ->
                  IntStream.range(1, rangeSize)
                      .allMatch(j -> sortedCards.get(i).value == sortedCards.get(i + j).value))
          .findFirst()
          .stream()
          .mapToObj(i -> sortedCards.get(i).value)
          .findFirst();
    }

    private static Optional<Value> getFirstPairValue(Set<Card> cards) {
      return getCommonValue(cards, 2);
    }

    private static Optional<Value> getTripletValue(Set<Card> cards) {
      return getCommonValue(cards, 3);
    }

    private static Optional<Value> getQuadrupleValue(Set<Card> cards) {
      return getCommonValue(cards, 4);
    }

    private static boolean consecutiveValues(Set<Card> cards) {
      List<Card> sortedCards = sortByValue(cards);
      return IntStream.range(0, cards.size() - 1)
          .allMatch(
              i ->
                  sortedCards.get(i).value.ordinal() + 1 == sortedCards.get(i + 1).value.ordinal());
    }

    private static boolean sameSuit(Set<Card> cards) {
      Suit suit = cards.iterator().next().suit;
      return cards.stream().allMatch(card -> card.suit == suit);
    }

    /**
     * Note: should test ranks in decreasing order, otherwise may get lower rank (e.g. three of a
     * kind matches when four of a kind is possible).
     *
     * @param cards set of {@link Card} representing a {@link Hand}
     * @return true if the set of cards matches the given rank definition.
     */
    abstract boolean isRank(Set<Card> cards);

    /**
     * Resolves a draw between two poker hands.
     *
     * @param hand1 set of {@link Card} representing the first {@link Hand}
     * @param hand2 set of {@link Card} representing the second {@link Hand}
     * @return true if the first set of cards beats the second. Assumes both card sets match the
     *     rank definition and the tie can be resolved.
     */
    abstract boolean resolveDraw(Set<Card> hand1, Set<Card> hand2);
  }
}
