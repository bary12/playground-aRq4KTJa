package com.yourself;

import org.junit.Assert;
import org.junit.Test;

public class BetterShopTest {

    @Test
    public void test(){
        try {
            assertEnough();
            assertNotEnough();
            Util.success(true);
        } catch (AssertionError ae) {
            Util.success(false);
            Util.msg("שגיאה!", ae.getMessage());
        }

    }

    private void assertEnough() throws AssertionError {
        Util.setUpStreams();
        BetterShop.shop(25);
        String content = Util.outContent.toString();
        Util.cleanUpStreams();
        Assert.assertTrue("ההודעה \nYou can buy pizza \nלא הודפסה למסך, למרות שיש ללקוח מספיק כסף", content.contains("can buy pizza"));
    }

    private void assertNotEnough() throws AssertionError {
        Util.setUpStreams();
        BetterShop.shop(15);
        String content = Util.outContent.toString();
        Util.cleanUpStreams();
        Assert.assertTrue("ההודעה \nYou don't have enough money\n לא הודפסה למסך, למרות שאין ללקוח מספיק כסף", content.contains("t have enough money"));
    }

}
