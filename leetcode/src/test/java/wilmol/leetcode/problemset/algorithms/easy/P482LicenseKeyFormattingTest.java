package wilmol.leetcode.problemset.algorithms.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-05-14. */
class P482LicenseKeyFormattingTest {

  private final P482LicenseKeyFormatting p482 = new P482LicenseKeyFormatting();

  @Test
  void example1() {
    assertThat(p482.licenseKeyFormatting("5F3Z-2e-9-w", 4)).isEqualTo("5F3Z-2E9W");
  }

  @Test
  void example2() {
    assertThat(p482.licenseKeyFormatting("2-5g-3-J", 2)).isEqualTo("2-5G-3J");
  }

  @Test
  void singleCharNoDashed() {
    assertThat(p482.licenseKeyFormatting("r", 1)).isEqualTo("R");
  }

  @Test
  void leaveOutEndingDashes() {
    assertThat(p482.licenseKeyFormatting("--a-a-a-a--", 2)).isEqualTo("AA-AA");
  }
}
