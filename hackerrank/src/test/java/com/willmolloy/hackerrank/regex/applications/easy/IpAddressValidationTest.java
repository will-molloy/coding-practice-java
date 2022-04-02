package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * IpAddressValidationTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class IpAddressValidationTest {

  @Test
  void ipv4Addresses() {
    assertThat(IpAddressValidation.addressType("123.123.123.123"))
        .isEqualTo(IpAddressValidation.Type.IPv4);
    assertThat(IpAddressValidation.addressType("255.255.255.255"))
        .isEqualTo(IpAddressValidation.Type.IPv4);
    assertThat(IpAddressValidation.addressType("249.255.255.255"))
        .isEqualTo(IpAddressValidation.Type.IPv4);
    assertThat(IpAddressValidation.addressType("199.99.99.99"))
        .isEqualTo(IpAddressValidation.Type.IPv4);
    assertThat(IpAddressValidation.addressType("1.1.1.1")).isEqualTo(IpAddressValidation.Type.IPv4);
    assertThat(IpAddressValidation.addressType("0.0.0.0")).isEqualTo(IpAddressValidation.Type.IPv4);
  }

  @Test
  void ipv6Addresses() {
    assertThat(IpAddressValidation.addressType("2001:0db8:0000:0000:0000:ff00:0042:8329"))
        .isEqualTo(IpAddressValidation.Type.IPv6);
    assertThat(IpAddressValidation.addressType("ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff"))
        .isEqualTo(IpAddressValidation.Type.IPv6);
    assertThat(IpAddressValidation.addressType("F:F:F:F:F:F:abcF:F"))
        .isEqualTo(IpAddressValidation.Type.IPv6);
    assertThat(IpAddressValidation.addressType("0:00:000:0000:00:00f:0:00f0"))
        .isEqualTo(IpAddressValidation.Type.IPv6);
  }

  @Test
  void invalidIpAddresses() {
    assertThat(IpAddressValidation.addressType("123..123.123.123"))
        .isEqualTo(IpAddressValidation.Type.Neither);
    assertThat(IpAddressValidation.addressType("1.1.1.1.1"))
        .isEqualTo(IpAddressValidation.Type.Neither);
    assertThat(IpAddressValidation.addressType("1:1:1:1"))
        .isEqualTo(IpAddressValidation.Type.Neither);
    assertThat(IpAddressValidation.addressType("-1.0.0.0"))
        .isEqualTo(IpAddressValidation.Type.Neither);
    assertThat(IpAddressValidation.addressType("300.99.99.99"))
        .isEqualTo(IpAddressValidation.Type.Neither);
    assertThat(IpAddressValidation.addressType("0:00:000:0000:00:00f:0:00f0:"))
        .isEqualTo(IpAddressValidation.Type.Neither);
  }
}
