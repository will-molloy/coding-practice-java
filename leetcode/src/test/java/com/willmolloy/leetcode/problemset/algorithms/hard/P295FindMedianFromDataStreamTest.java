package com.willmolloy.leetcode.problemset.algorithms.hard;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.Test;

/**
 * P295FindMedianFromDataStreamTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class P295FindMedianFromDataStreamTest {

  @Test
  void example() {
    P295FindMedianFromDataStream medianStream = new P295FindMedianFromDataStream();
    assertAll(
        () -> medianStream.addNum(1),
        () -> medianStream.addNum(2),
        () -> assertThat(medianStream.findMedian()).isEqualTo(1.5d),
        () -> medianStream.addNum(3),
        () -> assertThat(medianStream.findMedian()).isEqualTo(2d));
  }

  @Test
  void oneToFive() {
    P295FindMedianFromDataStream medianStream = new P295FindMedianFromDataStream();
    assertAll(
        () -> medianStream.addNum(1),
        () -> assertThat(medianStream.findMedian()).isEqualTo(1d),
        () -> medianStream.addNum(2),
        () -> assertThat(medianStream.findMedian()).isEqualTo(1.5d),
        () -> medianStream.addNum(3),
        () -> assertThat(medianStream.findMedian()).isEqualTo(2d),
        () -> medianStream.addNum(4),
        () -> assertThat(medianStream.findMedian()).isEqualTo(2.5d),
        () -> medianStream.addNum(5),
        () -> assertThat(medianStream.findMedian()).isEqualTo(3d));
  }

  @Test
  void fiveToOne() {
    P295FindMedianFromDataStream medianStream = new P295FindMedianFromDataStream();
    assertAll(
        () -> medianStream.addNum(5),
        () -> assertThat(medianStream.findMedian()).isEqualTo(5),
        () -> medianStream.addNum(4),
        () -> assertThat(medianStream.findMedian()).isEqualTo(4.5d),
        () -> medianStream.addNum(3),
        () -> assertThat(medianStream.findMedian()).isEqualTo(4d),
        () -> medianStream.addNum(2),
        () -> assertThat(medianStream.findMedian()).isEqualTo(3.5d),
        () -> medianStream.addNum(1),
        () -> assertThat(medianStream.findMedian()).isEqualTo(3d));
  }

  @Test
  void negativeNumbers() {
    P295FindMedianFromDataStream medianStream = new P295FindMedianFromDataStream();
    assertAll(
        () -> medianStream.addNum(-1),
        () -> assertThat(medianStream.findMedian()).isEqualTo(-1d),
        () -> medianStream.addNum(-2),
        () -> assertThat(medianStream.findMedian()).isEqualTo(-1.5d),
        () -> medianStream.addNum(-3),
        () -> assertThat(medianStream.findMedian()).isEqualTo(-2d),
        () -> medianStream.addNum(-4),
        () -> assertThat(medianStream.findMedian()).isEqualTo(-2.5d),
        () -> medianStream.addNum(-5),
        () -> assertThat(medianStream.findMedian()).isEqualTo(-3d));
  }
}
