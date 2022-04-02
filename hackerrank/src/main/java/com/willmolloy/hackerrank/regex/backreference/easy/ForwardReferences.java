package com.willmolloy.hackerrank.regex.backreference.easy;

import com.willmolloy.hackerrank.regex.Regex;
import java.util.regex.Pattern;

/**
 * <a
 * href=https://www.hackerrank.com/challenges/forward-references/problem>https://www.hackerrank.com/challenges/forward-references/problem</a>
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class ForwardReferences implements Regex {

  private static final Pattern PATTERN = Pattern.compile("^(\\2tic|(tac))+$");

  /**
   * forward reference -> back reference to a group that would appear later only useful if inside a
   * repeated group (else may be evaluated as back reference).
   *
   * <p>only match 'tic' after at least two 'tac' then only match non adjacent 'tic'.
   *
   * <p>group 2 = 'tac' i.e. the \2 will repeat 'tac' therefore group 1 = 'tac' OR 'tactic'
   * alternatively (and probably preferred): ^tac(tac(tic)?)*$.
   */
  @Override
  public Pattern pattern() {
    return PATTERN;
  }
}
