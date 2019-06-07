package com.wilmol.hackerrank.regex.back_reference.easy;

import com.wilmol.hackerrank.regex.Regex;

/**
 * Created by Will on 2019-04-06 at 20:30
 * <p>
 * https://www.hackerrank.com/challenges/forward-references/problem
 */
class ForwardReferences
    implements
    Regex
{
  @Override
  public String regex()
  {
    // forward reference -> back reference to a group that would appear later
    // only useful if inside a repeated group (else may be evaluated as back reference)

    // only match 'tic' after at least two 'tac'
    // then only match non adjacent 'tic'

    // group 2 = 'tac'
    // i.e. the \2 will repeat 'tac'
    // therefore group 1 = 'tac' OR 'tactic'
    // alternatively (and probably preferred): ^tac(tac(tic)?)*$
    return "^(\\2tic|(tac))+$";
  }
}
