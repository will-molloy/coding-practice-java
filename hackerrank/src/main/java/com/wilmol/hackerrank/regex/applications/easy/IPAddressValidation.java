package com.wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Pattern;

/**
 * Created by Will on 2019-04-07 at 15:25.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/ip-address-validation/problem>https://www.hackerrank.com/challenges/ip-address-validation/problem</a>
 *
 * <p>Runtime: O(n)
 */
final class IpAddressValidation {

  private IpAddressValidation() {}

  private static final String BYTE_REGEX = "([2][5][0-5]|[2][0-4][0-9]|[1]?[0-9]{1,2})";

  private static final Pattern IPV4_PATTERN =
      Pattern.compile("^(" + BYTE_REGEX + "[.]){3}" + BYTE_REGEX + "$");

  private static final String HEX_REGEX = "[0-9a-fA-F]{1,4}";

  private static final Pattern IPV6_PATTERN =
      Pattern.compile("^(" + HEX_REGEX + ":){7}" + HEX_REGEX + "$");

  enum Type {
    IPv6 {
      @Override
      boolean matches(String s) {
        return IPV6_PATTERN.matcher(s).matches();
      }
    },
    IPv4 {
      @Override
      boolean matches(String s) {
        return IPV4_PATTERN.matcher(s).matches();
      }
    },
    Neither;

    boolean matches(String s) {
      throw new UnsupportedOperationException();
    }
  }

  static Type addressType(String address) {
    if (Type.IPv4.matches(address)) {
      return Type.IPv4;
    } else if (Type.IPv6.matches(address)) {
      return Type.IPv6;
    }
    return Type.Neither;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    // CHECKSTYLE IGNORE Regexp FOR NEXT 1 LINES
    reader.lines().map(IpAddressValidation::addressType).forEach(System.out::println);
  }
}
