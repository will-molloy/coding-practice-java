package com.wilmol.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/** Created by wilmol on 2020-06-16. */
class P468ValidateIpAddressTest {

  private final P468ValidateIpAddress p468 = new P468ValidateIpAddress();

  @Test
  void example1Ipv4() {
    assertThat(p468.validIpAddress("172.16.254.1")).isEqualTo("IPv4");
  }

  @Test
  void example2Ipv6() {
    assertThat(p468.validIpAddress("2001:0db8:85a3:0:0:8A2E:0370:7334")).isEqualTo("IPv6");
  }

  @Test
  void example3Neither() {
    assertThat(p468.validIpAddress("256.256.256.256")).isEqualTo("Neither");
  }

  @Test
  void ipv4Min() {
    assertThat(p468.validIpAddress("0.0.0.0")).isEqualTo("IPv4");
  }

  @Test
  void ipv4Max() {
    assertThat(p468.validIpAddress("255.255.255.255")).isEqualTo("IPv4");
  }

  @Test
  void ipv4CantLeadZeroes() {
    assertThat(p468.validIpAddress("0.0.0.00")).isEqualTo("Neither");
  }

  @Test
  void ipv4NotEnoughBytes() {
    assertThat(p468.validIpAddress("0.0.0")).isEqualTo("Neither");
  }

  @Test
  void ipv4TooManyBytes() {
    assertThat(p468.validIpAddress("0.0.0.0.0")).isEqualTo("Neither");
  }

  @Test
  void ipv4CantCollapse() {
    assertThat(p468.validIpAddress("0.0..0")).isEqualTo("Neither");
  }

  @Test
  void ipv6MinNonLeadingZeroes() {
    assertThat(p468.validIpAddress("0:0:0:0:0:0:0:0")).isEqualTo("IPv6");
  }

  @Test
  void ipv6MinLeadingZeroes() {
    assertThat(p468.validIpAddress("0000:0000:0000:0000:0000:0000:0000:0000")).isEqualTo("IPv6");
  }

  @Test
  void ipv6Max() {
    assertThat(p468.validIpAddress("ffff:ffff:ffff:ffff:ffff:ffff:ffff:ffff")).isEqualTo("IPv6");
  }

  @Test
  void ipv6NotEnoughHex() {
    assertThat(p468.validIpAddress("0:0:0:0:0:0:0")).isEqualTo("Neither");
  }

  @Test
  void ipv6TooManyHex() {
    assertThat(p468.validIpAddress("0:0:0:0:0:0:0:0:0")).isEqualTo("Neither");
  }

  @Test
  void ipv6CantCollapse() {
    assertThat(p468.validIpAddress("0:0:0:0:0:0::0")).isEqualTo("Neither");
  }
}
