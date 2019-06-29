package com.wilmol.hackerrank.interviewpreparationkit.sorting.medium;

import java.util.Objects;

/**
 * Created by Will on 25/03/2019
 *
 * <p>https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 *
 * <p>Implement a Comparator
 *
 * <p>Runtime: whatever the sorting algorithm run time is (best case O(n log n))
 */
public class ComparatorInterface {

  static Player[] sortPlayers(Player[] players) {
    // bubble sort, O(n ^ 2)
    for (int i = 0; i < players.length; i++) {
      for (int j = i + 1; j < players.length; j++) {
        if (players[j].compareTo(players[i]) < 0) {
          Player temp = players[j];
          players[j] = players[i];
          players[i] = temp;
        }
      }
    }
    return players;
  }
}

// Comparable, Comparator, basically the same thing.. Comparator is a separate class (no clean
// private field access)
class Player implements Comparable<Player> {
  private final String name;

  private final int score;

  public Player(String name, int score) {
    this.name = name;
    this.score = score;
  }

  @Override
  public int compareTo(Player that) {
    if (this.score != that.score) {
      // prefer by score descending
      return Integer.compare(that.score, this.score);
    } else {
      // but if same score, by name ascending
      return this.name.compareTo(that.name);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Player player = (Player) o;
    return score == player.score && Objects.equals(name, player.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, score);
  }
}
