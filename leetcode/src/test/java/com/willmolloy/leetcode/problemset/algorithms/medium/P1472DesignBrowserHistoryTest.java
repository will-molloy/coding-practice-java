package com.willmolloy.leetcode.problemset.algorithms.medium;

import static com.google.common.truth.Truth.assertThat;

import com.willmolloy.leetcode.problemset.algorithms.medium.P1472DesignBrowserHistory.BrowserHistory;
import org.junit.jupiter.api.Test;

/**
 * P1472DesignBrowserHistoryTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
class P1472DesignBrowserHistoryTest {

  @Test
  void example() {
    BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
    browserHistory.visit("google.com");
    browserHistory.visit("facebook.com");
    browserHistory.visit("youtube.com");
    assertThat(browserHistory.back(1)).isEqualTo("facebook.com");
    assertThat(browserHistory.back(1)).isEqualTo("google.com");
    assertThat(browserHistory.forward(1)).isEqualTo("facebook.com");
    browserHistory.visit("linkedin.com");
    assertThat(browserHistory.forward(2)).isEqualTo("linkedin.com");
    assertThat(browserHistory.back(2)).isEqualTo("google.com");
    assertThat(browserHistory.back(7)).isEqualTo("leetcode.com");
  }
}
