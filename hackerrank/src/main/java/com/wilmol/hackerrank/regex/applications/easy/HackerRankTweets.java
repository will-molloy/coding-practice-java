package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-07 at 19:22
 *
 * <p>https://www.hackerrank.com/challenges/hackerrank-tweets/problem
 *
 * <p>Runtime: O(n)
 */
class HackerRankTweets {
  private static final Pattern p = Pattern.compile("hackerrank", Pattern.CASE_INSENSITIVE);

  static boolean hasHackerrank(String string) {
    return p.asPredicate().test(string);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    reader.readLine();
    long count =
        reader
            .lines()
            .mapToInt(
                line -> {
                  Matcher m = p.matcher(line);
                  return m.find() ? 1 : 0;
                })
            .sum();
    System.out.println(count);
  }
}
