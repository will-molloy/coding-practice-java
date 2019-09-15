package wilmol.hackerrank.regex.applications.easy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wilmol on 2019-09-15.
 *
 * <p><a
 * href=https://www.hackerrank.com/challenges/utopian-identification-number/problem>https://www.hackerrank.com/challenges/utopian-identification-number/problem</a>
 *
 * <p>Runtime: O(n)
 *
 * @see AlienUserName
 */
class UtopianIdentificationNumber {

  private UtopianIdentificationNumber() {}

  private static final Pattern ID_PATTERN = Pattern.compile("^[a-z]{0,3}\\d{2,8}[A-Z]{3,}$");

  static boolean isValid(String userName) {
    Matcher m = ID_PATTERN.matcher(userName);
    return m.matches();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader reader =
        new BufferedReader(new InputStreamReader(System.in, StandardCharsets.UTF_8));
    reader.readLine(); // ignore (num lines)
    reader
        .lines()
        .forEach(
            line -> {
              if (isValid(line)) {
                // CHECKSTYLE IGNORE Regexp FOR NEXT 3 LINES
                System.out.println("VALID");
              } else {
                System.out.println("INVALID");
              }
            });
  }
}
