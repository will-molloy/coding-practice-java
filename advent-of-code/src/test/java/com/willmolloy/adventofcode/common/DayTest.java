package com.willmolloy.adventofcode.common;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link Day}.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
public abstract class DayTest {
  private final Day day;

  protected DayTest(Day day) {
    this.day = day;
  }

  @Test
  void part1_exampleInput() {
    var input = FileInput.example(day);
    assertThat(day.part1(input)).isEqualTo(part1().example());
  }

  @Test
  void part1_realInput() {
    var input = FileInput.real(day);
    assumeTrue(input.isPresent());
    assertThat(day.part1(input.get())).isEqualTo(part1().real());
  }

  @Test
  void part2_exampleInput() {
    var input = FileInput.example(day);
    assertThat(day.part2(input)).isEqualTo(part2().example());
  }

  @Test
  void part2_realInput() {
    var input = FileInput.real(day);
    assumeTrue(input.isPresent());
    assertThat(day.part2(input.get())).isEqualTo(part2().real());
  }

  protected abstract Answer part1();

  protected abstract Answer part2();

  /**
   * Expected answer.
   *
   * @param example expected example answer
   * @param real expected real answer
   */
  public record Answer(Object example, Object real) {}
}
