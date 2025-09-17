package com.willmolloy.adventofcode.common;

import static com.google.common.base.Preconditions.checkArgument;

/**
 * A day in the advent-of-code calendar.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public abstract class Day {
  private final int year;
  private final int day;

  protected Day(int year, int day) {
    checkArgument(year >= 2015, "Invalid year: %s", year);
    checkArgument(day >= 1 && day <= 25, "Invalid day: %s", day);
    this.year = year;
    this.day = day;
  }

  public final int year() {
    return year;
  }

  public final int day() {
    return day;
  }

  protected abstract Object part1(Input input);

  protected abstract Object part2(Input input);

  @Override
  public final String toString() {
    return "Day[%d, %d]".formatted(year, day);
  }
}
