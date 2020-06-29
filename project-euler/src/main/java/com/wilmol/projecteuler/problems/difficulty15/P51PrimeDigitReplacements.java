package com.wilmol.projecteuler.problems.difficulty15;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.wilmol.projecteuler.problems.difficulty5.P52PermutedMultiples;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <a href=https://projecteuler.net/problem=51>https://projecteuler.net/problem=51</a>
 *
 * <p>Runtime: none - the search is linear (through the integers), but unknown when prime families
 * will be encountered
 *
 * @see P52PermutedMultiples
 * @author <a href=https://wilmol.com>Will Molloy</a>
 */
public final class P51PrimeDigitReplacements {

  private P51PrimeDigitReplacements() {}

  private static final Logger LOG = LogManager.getLogger();

  static int smallestPrimeOfNSizedPrimeFamilyFormedByReplacingDigits(int primeFamilySize) {
    Preconditions.checkArgument(primeFamilySize >= 6 && primeFamilySize <= 10);

    // iterate all odd values with 2 or more digits
    // (evens would only allow prime families of size at most 5)
    return IntStream.iterate(11, n -> n + 2)
        // try all templates of 'n'
        .mapToObj(n -> templates(String.valueOf(n)))
        .flatMap(List::stream)
        .map(
            template -> {
              // if replacing the first digit, cannot substitute with a '0'
              int start = template.startsWith("x") ? 1 : 0;

              int primesFound = 0;
              int firstPrime = -1;

              // substitute 'x' with each digit, counting the primes, until prime family of given
              // size is found
              for (int digit = start; digit <= 9; digit++) {
                int value = Integer.parseInt(template.replaceAll("x", String.valueOf(digit)));
                if (IntMath.isPrime(value)) {
                  primesFound += 1;
                  if (firstPrime == -1) {
                    // keep track of first prime in the family (in case it isn't 'n', 'n' could be a
                    // composite)
                    firstPrime = value;
                  }
                  if (primesFound == primeFamilySize) {
                    // leave once desired prime family size is found
                    // (technically could be a smaller prime from another template of 'n')
                    LOG.info(
                        "Found smallest prime [{}] of family size [{}] using template [{}]",
                        firstPrime,
                        primeFamilySize,
                        template);
                    return OptionalInt.of(firstPrime);
                  }
                }
                // (optimisation), if not enough digits to try form primes with, move on to next
                // template early
                int remainingDigits = 10 - start - digit;
                int remainingPrimes = primeFamilySize - primesFound;
                if (remainingDigits < remainingPrimes) {
                  break;
                }
              }
              return OptionalInt.empty();
            })
        .filter(OptionalInt::isPresent)
        .map(OptionalInt::getAsInt)
        .findFirst()
        .orElseThrow();
  }

  // generates the templates for 'n'
  // i.e. all possible ways 'n' can substitute digits
  // e.g. for '100' -> 'x00', '0x0', 'xx0'
  // notes:
  // - substitution may not necessarily be adjacent! (e.g. will have 'x0x0' for '1000')
  // - don't bother substituting last digit, it needs to be odd, otherwise prime families greater
  // than size 5 won't be
  // found
  // - ideally would be a true 'generator' i.e. use a template before generating all of them
  static List<String> templates(String n) {
    List<String> templates = new ArrayList<>();
    // iterate, substituting i'th digit for 'x' (except for last position)
    for (int i = 0; i < n.length() - 1; i++) {
      String prefix = n.substring(0, i) + "x";
      String suffix = n.substring(i + 1);
      templates.add(prefix + suffix);
      // recursively template the suffix (if it has two or more digits)
      if (suffix.length() > 1) {
        for (String templatedSuffix : templates(suffix)) {
          templates.add(prefix + templatedSuffix);
        }
      }
    }
    return templates;
  }
}
