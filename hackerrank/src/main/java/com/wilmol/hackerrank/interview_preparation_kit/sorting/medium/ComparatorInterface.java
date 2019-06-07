package com.wilmol.hackerrank.interview_preparation_kit.sorting.medium;

import lombok.Data;

/**
 * Created by Will on 25/03/2019
 * <p>
 * https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
 * <p>
 * Implement a Comparator
 * <p>
 * Runtime: whatever the sorting algorithm run time is (best case O(n log n))
 */
class ComparatorInterface
{

  static Player[] sortPlayers(Player[] players)
  {
    // bubble sort, O(n ^ 2)
    for (int i = 0; i < players.length; i++)
    {
      for (int j = i + 1; j < players.length; j++)
      {
        if (players[j].compareTo(players[i]) < 0)
        {
          Player temp = players[j];
          players[j] = players[i];
          players[i] = temp;
        }
      }
    }
    return players;
  }

}

// Comparable, Comparator, basically the same thing.. Comparator is a separate class (no clean private field access)
@Data
class Player
    implements
    Comparable<Player>
{
  private final String name;

  private final int score;

  @Override
  public int compareTo(Player that)
  {
    if (this.score != that.score)
    {
      // prefer by score descending
      return -Integer.compare(this.score, that.score);
    }
    else
    {
      // but if same score, by name ascending
      return this.name.compareTo(that.name);
    }
  }

}
