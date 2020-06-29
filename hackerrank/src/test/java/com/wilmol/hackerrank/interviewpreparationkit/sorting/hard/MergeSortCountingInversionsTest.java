package com.wilmol.hackerrank.interviewpreparationkit.sorting.hard;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * MergeSortCountingInversionsTest.
 *
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
class MergeSortCountingInversionsTest {

  @Test
  void alreadySorted() {
    assertThat(MergeSortCountingInversions.countInversions(new int[] {1, 1, 1, 2, 2}))
        .isEqualTo(0L);
  }

  @Test
  void notSortedSmallArray() {
    assertThat(MergeSortCountingInversions.countInversions(new int[] {2, 1, 3, 1, 2}))
        .isEqualTo(4L);
  }

  @Test
  void notSortedLargeArray() {
    assertThat(
            MergeSortCountingInversions.countInversions(
                new int[] {
                  0, 480130, 735329, 810013, 140187, 972418, 357056, 334780, 854684, 478980, 34590,
                  180238, 567090, 935248, 834854, 514996, 950881, 104525, 874212, 160000, 528785,
                  770712, 201115, 830644, 535327, 668785, 241043, 946633, 645108, 184097, 251762,
                  97219, 664226, 503442, 907232, 320764, 992211, 264287, 171895, 846895, 259618,
                  722836, 543484, 343059, 658083, 378338, 858054, 125316, 999214, 248618, 285315,
                  527999, 535681, 2781, 358642, 71007, 671565, 116036, 17639, 833024, 300132,
                  785753, 930243, 480710, 805546, 353826, 317825, 797757, 134464, 6072, 161003,
                  394081, 728907, 704486, 253492, 386990, 599175, 111545, 28657, 598389, 360162,
                  313971, 642739, 895842, 833103, 1380, 966849, 21019, 633767, 500839, 854043,
                  450251, 802943, 784285, 930960, 608489, 654462, 765136, 922597, 788925, 771207,
                  83599, 699357, 500114, 304436, 952848, 403455, 419963, 580745, 432111, 534703,
                  457258, 262433
                }))
        .isEqualTo(3083L);
  }
}
