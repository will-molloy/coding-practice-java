package com.willmolloy.hackerrank.regex.applications.easy;

import static com.google.common.truth.Truth.assertThat;

import org.junit.jupiter.api.Test;

/**
 * BuildAStackExchangeScraperTest.
 *
 * @author <a href=https://willmolloy.com>Will Molloy</a>
 */
final class BuildAStackExchangeScraperTest {

  @Test
  void sampleTestCase0() {
    // NOTE there was a typo on "operational" ... fixed it here
    String markUp =
        "        <div class=\"question-summary\" id=\"question-summary-80407\">\n"
            + "        <div class=\"statscontainer\">\n"
            + "            <div class=\"statsarrow\"></div>\n"
            + "            <div class=\"stats\">\n"
            + "                <div class=\"vote\">\n"
            + "                    <div class=\"votes\">\n"
            + "                        <span class=\"vote-count-post \"><strong>2</strong></span>\n"
            + "                        <div class=\"viewcount\">votes</div>\n"
            + "                    </div>\n"
            + "                </div>\n"
            + "                <div class=\"status answered\">\n"
            + "                    <strong>1</strong>answer\n"
            + "                </div>\n"
            + "            </div>\n"
            + "\n"
            + "\n"
            + "\n"
            + "    <div class=\"views \" title=\"60 views\">\n"
            + "                        60 views\n"
            + "    </div>\n"
            + "        </div>\n"
            + "        <div class=\"summary\">\n"
            + "            <h3><a href=\"/questions/80407/about-power-supply-of-operational-amplifier\" class=\"question-hyperlink\">about power supply of operational amplifier</a></h3>\n"
            + "            <div class=\"excerpt\">\n"
            + "                I am constructing an operational amplifier as shown in the following figure. I use a batter as supplier for the OP Amp and set it up as a non-inverting amp circuit. I saw that the output was clipped ...\n"
            + "            </div>\n"
            + "\n"
            + "            <div class=\"tags t-op-amp\">\n"
            + "                <a href=\"/questions/tagged/op-amp\" class=\"post-tag\" title=\"show questions tagged 'op-amp'\" rel=\"tag\">op-amp</a>\n"
            + "\n"
            + "            </div>\n"
            + "            <div class=\"started fr\">\n"
            + "\n"
            + "\n"
            + "        <div class=\"user-info \">\n"
            + "            <div class=\"user-action-time\">\n"
            + "\n"
            + "\n"
            + "                        asked <span title=\"2013-08-27 21:49:14Z\" class=\"relativetime\">11 hours ago</span>\n"
            + "            </div>\n"
            + "            <div class=\"user-gravatar32\">\n"
            + "                <a href=\"/users/17060/user1285419\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/08ee68b20a4eceff26f7eee99b708c08?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n"
            + "            </div>\n"
            + "            <div class=\"user-details\">\n"
            + "                <a href=\"/users/17060/user1285419\">user1285419</a><br>\n"
            + "                <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">165</span><span title=\"5 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">5</span></span>\n"
            + "            </div>\n"
            + "        </div>\n"
            + "\n"
            + "            </div>\n"
            + "        </div>\n"
            + "    </div>\n"
            + "\n"
            + "    <div class=\"question-summary\" id=\"question-summary-80405\">\n"
            + "        <div class=\"statscontainer\">\n"
            + "            <div class=\"statsarrow\"></div>\n"
            + "            <div class=\"stats\">\n"
            + "                <div class=\"vote\">\n"
            + "                    <div class=\"votes\">\n"
            + "                        <span class=\"vote-count-post \"><strong>4</strong></span>\n"
            + "                        <div class=\"viewcount\">votes</div>\n"
            + "                    </div>\n"
            + "                </div>\n"
            + "                <div class=\"status answered-accepted\">\n"
            + "                    <strong>2</strong>answers\n"
            + "                </div>\n"
            + "            </div>\n"
            + "\n"
            + "\n"
            + "\n"
            + "    <div class=\"views \" title=\"64 views\">\n"
            + "                        64 views\n"
            + "    </div>\n"
            + "        </div>\n"
            + "        <div class=\"summary\">\n"
            + "            <h3><a href=\"/questions/80405/5v-regulator-power-dissipation\" class=\"question-hyperlink\">5V Regulator Power Dissipation</a></h3>\n"
            + "            <div class=\"excerpt\">\n"
            + "                I am using a 5V regulator (LP2950) from ON Semiconductor. I am using this for USB power and I'm feeding in 9V from an adapter. USB requires maximum of 500mA right? So the maximum power dissipation in ...\n"
            + "            </div>\n"
            + "\n"
            + "            <div class=\"tags t-voltage-regulator t-surface-mount t-heatsink t-5v t-power-dissipation\">\n"
            + "                <a href=\"/questions/tagged/voltage-regulator\" class=\"post-tag\" title=\"show questions tagged 'voltage-regulator'\" rel=\"tag\">voltage-regulator</a> <a href=\"/questions/tagged/surface-mount\" class=\"post-tag\" title=\"show questions tagged 'surface-mount'\" rel=\"tag\">surface-mount</a> <a href=\"/questions/tagged/heatsink\" class=\"post-tag\" title=\"show questions tagged 'heatsink'\" rel=\"tag\">heatsink</a> <a href=\"/questions/tagged/5v\" class=\"post-tag\" title=\"show questions tagged '5v'\" rel=\"tag\">5v</a> <a href=\"/questions/tagged/power-dissipation\" class=\"post-tag\" title=\"show questions tagged 'power-dissipation'\" rel=\"tag\">power-dissipation</a>\n"
            + "\n"
            + "            </div>\n"
            + "            <div class=\"started fr\">\n"
            + "\n"
            + "\n"
            + "        <div class=\"user-info \">\n"
            + "            <div class=\"user-action-time\">\n"
            + "\n"
            + "\n"
            + "                        asked <span title=\"2013-08-27 21:39:31Z\" class=\"relativetime\">11 hours ago</span>\n"
            + "            </div>\n"
            + "            <div class=\"user-gravatar32\">\n"
            + "                <a href=\"/users/10082/david-norman\"><div class=\"\"><img src=\"https://www.gravatar.com/avatar/8b073417e471077280b3fc5ff2eaf1f7?s=32&d=identicon&r=PG\" alt=\"\" width=\"32\" height=\"32\"></div></a>\n"
            + "            </div>\n"
            + "            <div class=\"user-details\">\n"
            + "                <a href=\"/users/10082/david-norman\">David Norman</a><br>\n"
            + "                <span class=\"reputation-score\" title=\"reputation score\" dir=\"ltr\">322</span><span title=\"3 silver badges\"><span class=\"badge2\"></span><span class=\"badgecount\">3</span></span><span title=\"10 bronze badges\"><span class=\"badge3\"></span><span class=\"badgecount\">10</span></span>\n"
            + "            </div>\n"
            + "        </div>\n"
            + "\n"
            + "            </div>\n"
            + "        </div>\n"
            + "    </div>";

    assertThat(BuildAStackExchangeScraper.solve(markUp))
        .containsExactly(
            "80407;about power supply of operational amplifier;11 hours ago",
            "80405;5V Regulator Power Dissipation;11 hours ago")
        .inOrder();
  }
}
