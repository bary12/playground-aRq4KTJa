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
        String content = Util.getFromStdOut(BetterShop::shop, 25);
        Assert.assertTrue("ההודעה \nYou can buy pizza \nלא הודפסה למסך, למרות שיש ללקוח מספיק כסף", content.contains("can buy pizza"));
        Assert.assertFalse("הודפסה ההודעה הלא נכונה", content.contains("t have enough money"));
    }

    private void assertNotEnough() throws AssertionError {
        String content = Util.getFromStdOut(BetterShop::shop, 15);
        Assert.assertTrue("ההודעה \nYou don't have enough money\n לא הודפסה למסך, למרות שאין ללקוח מספיק כסף", content.contains("t have enough money"));
        Assert.assertFalse("הודפסה ההודעה\n You can buy pizza\nכאשר לא היה ללקוח מספיק כסף", content.contains("can buy pizza"));
    }

}
