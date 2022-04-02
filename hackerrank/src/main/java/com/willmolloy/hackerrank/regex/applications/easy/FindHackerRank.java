package com.willmolloy.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/find-hackerrank/problem>https://www.hackerrank.com/challenges/find-hackerrank/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class FindHackerRank {

  private FindHackerRank() {}

  /** Answer type. */
  enum Type {
    START(1),
    END(2),
    START_AND_END(0),
    NONE(-1);

    private final int display;

    Type(int display) {
      this.display = display;
    }

    public int getDisplay() {
      return display;
    }
  }

  private static final Pattern STARTS_AND_ENDS = Pattern.compile("^hackerrank(.*hackerrank)?$");

  private static final Pattern STARTS = Pattern.compile("^hackerrank.+$");

  private static final Pattern ENDS = Pattern.compile("^.+hackerrank$");

  static Type findHackerRank(String line) {
    if (STARTS_AND_ENDS.matcher(line).matches()) {
      return Type.START_AND_END;
    }
    if (STARTS.matcher(line).matches()) {
      return Type.START;
    }
    if (ENDS.matcher(line).matches()) {
      return Type.END;
    }
    return Type.NONE;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader
        .lines()
        .forEach(
            line -> {
              // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
              System.out.println(findHackerRank(line).getDisplay());
            });
  }
}
