package com.wilmol.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;
import static com.wilmol.hackerrank.regex.applications.easy.IpAddressValidation.Type.IPv4;
import static com.wilmol.hackerrank.regex.applications.easy.IpAddressValidation.Type.IPv6;
import static com.wilmol.hackerrank.regex.applications.easy.IpAddressValidation.Type.Neither;
import static com.wilmol.hackerrank.regex.applications.easy.IpAddressValidation.addressType;

import org.junit.jupiter.api.Test;

/** Created by Will on 2019-04-07 at 15:25. */
class IpAddressValidationTest {

  @Test
  void ipv4Addresses() {
    assertThat(addressType("123.123.123.123")).isEqualTo(IPv4);
    assertThat(addressType("255.255.255.255")).isEqualTo(IPv4);
    assertThat(addressType("249.255.255.255")).isEqualTo(IPv4);
    assertThat(addressType("199.99.99.99")).isEqualTo(IPv4);
    assertThat(addressType("1.1.1.1")).isEqualTo(IPv4);
    assertThat(addressType("0.0.0.0")).isEqualTo(IPv4);
  }

  @Test
  void ipv6Addresses() {
    assertThat(addressType("2001:0db8:0000:0000:0000:ff00:0042:8329")).isEqualTo(IPv6);
    assertThat(addressType("ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff")).isEqualTo(IPv6);
    assertThat(addressType("F:F:F:F:F:F:abcF:F")).isEqualTo(IPv6);
    assertThat(addressType("0:00:000:0000:00:00f:0:00f0")).isEqualTo(IPv6);
  }

  @Test
  void invalidIpAddresses() {
    assertThat(addressType("123..123.123.123")).isEqualTo(Neither);
    assertThat(addressType("1.1.1.1.1")).isEqualTo(Neither);
    assertThat(addressType("1:1:1:1")).isEqualTo(Neither);
    assertThat(addressType("-1.0.0.0")).isEqualTo(Neither);
    assertThat(addressType("300.99.99.99")).isEqualTo(Neither);
    assertThat(addressType("0:00:000:0000:00:00f:0:00f0:")).isEqualTo(Neither);
  }
}
